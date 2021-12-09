package uz.netex.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public record M1Router(Vertx vertx) {

    public Router createRouter() {
        return null;
    }
}