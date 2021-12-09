package uz.netex.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.nio.file.Path;

public class WorkerVerticle extends AbstractVerticle {
    @Override
    public void start() {
        vertx.deploymentIDs().forEach(System.out::println);
        String path = "C:\\Users\\user5\\Downloads\\";
        String f1 = "udig-2.2.0.RC1.win32.win32.x86_64.zip";
        String f2 = "datagrip-2021.2.4.exe";

        readFile(Path.of(path + f1));
        readFile(Path.of(path + f2));
    }

    Future<Void> readFile(Path path) {
        Promise<Void> promise = Promise.promise();
        vertx.fileSystem().readFile(path.toString())
                .onSuccess(ar -> {
                    System.out.println("File: " + path.getFileName() + "\n" +
                            "Thread: " + Thread.currentThread().getId() + "\n" +
                            "size: " + ar.length());
                    promise.complete();
                });
        return promise.future();
    }
}
