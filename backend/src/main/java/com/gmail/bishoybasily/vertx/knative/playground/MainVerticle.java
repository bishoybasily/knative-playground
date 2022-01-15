package com.gmail.bishoybasily.vertx.knative.playground;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import java.util.UUID;

public class MainVerticle extends AbstractVerticle {

  private String id;

  @Override
  public void start(Promise<Void> startPromise) {
    vertx.eventBus().consumer("backend", it -> {
      it.reply(String.format("Hello from clustered vertx, id: %s", getId()));
    });
    startPromise.complete();
  }

  private String getId() {
    if (id == null)
      id = UUID.randomUUID().toString();
    return id;
  }

}
