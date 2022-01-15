package com.gmail.bishoybasily.vertx.knative.playground;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    vertx.createHttpServer().requestHandler(ctx -> {
      vertx.eventBus().<String>request("backend", "", reply -> {
        ctx.response().putHeader("content-type", "text/plain")
          .end(reply.result().body());
      });

    }).listen(8080, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("Server is up and running.");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
