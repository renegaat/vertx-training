package de.msg.vertxtraining;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HttpServerVerticle extends AbstractVerticle {
    
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        
        vertx.createHttpServer().requestHandler(httpServerRequest -> httpServerRequest.response()
                .end("Hello HttpServerVerticle ")).listen(8080, httpServerAsyncResult -> {
                    if (httpServerAsyncResult.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(httpServerAsyncResult.cause());
                    }
                }
        );
    }
}   


        
