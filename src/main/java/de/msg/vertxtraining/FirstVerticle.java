package de.msg.vertxtraining;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;

public class FirstVerticle extends AbstractVerticle {


    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        vertx.eventBus().consumer(Services.HELLO_WORLD.toString(), message -> {
            dispatchMessage(message);
        });
    }

    private void dispatchMessage(Message<Object> message) {
        final Operations operations = Operations.valueOf(message.body().toString());

        switch (operations){
            case HELLO_WORLD_OPERATION:
                message.reply("Hello World");
                break;

                default:
                message.reply("Error");

        }

    }
}
