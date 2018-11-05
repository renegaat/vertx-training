package de.msg.vertxtraining;

import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class VertxTraining {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(VertxTraining.class);

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new HttpServerVerticle(), res -> {
            if (res.succeeded()) {
                logger.info("verticle HttpServer deployed successfully");
            } else {
                logger.info("verticle HttServer deployed with error");
            }
        });

        vertx.deployVerticle(new FirstVerticle(), res -> {
            if (res.succeeded()) {
                logger.info("verticle one deployed successfully");
            } else {
                logger.info("verticle one deployed with error");
            }
        });

        vertx.deployVerticle(new SecondVerticle(), res -> {
            if (res.succeeded()) {
                logger.info("verticle two deployed successfully");
            } else {
                logger.info("verticle two deployed with error");
            }
        });

    }
}
