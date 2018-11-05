package de.msg.vertxtraining;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class HttpServerVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(HttpServerVerticle.class);

    @Override
    public void start() {
        vertx.createHttpServer()
                .requestHandler(httpRequest -> sendMessage())
                .listen(8080);
    }
    
    private void sendMessage() {
        vertx.eventBus().send(Services.HELLO_WORLD.toString(), Operations.HELLO_WORLD_OPERATION.toString(),
                messageAsyncResult -> {
                    if (messageAsyncResult.succeeded()) {
                        logger.info(messageAsyncResult.result().body().toString());
                    } else {
                        logger.info(messageAsyncResult.cause().getMessage());
                    }
                });
    }
}   


        
