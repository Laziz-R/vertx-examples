package uz.netex.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class MainVerticle extends AbstractVerticle {
    @Override
    public void start() {
        vertx.deployVerticle(WorkerVerticle.class,
                new DeploymentOptions()
                        .setWorker(true)
//                        .setInstances(2)
        );
    }

    private void createHttpServer() {
        vertx.createHttpServer()
                .requestHandler(req -> req
                        .response()
                        .putHeader("Content-Type", "text/html; charset=UTF-8")
                        .end("Hello, чувак."))
                .listen(8081)
                .onSuccess(http -> System.out.println("HTTP server started at: http://localhost:" + http.actualPort()));
    }
}
