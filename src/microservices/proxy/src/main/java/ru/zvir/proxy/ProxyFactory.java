package ru.zvir.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

@Component
public class ProxyFactory extends AbstractRoutePredicateFactory<ProxyFactory.Config> {


    @Value("${proxy.gradual-migration}")
    boolean gradualMigration;
    @Value("${proxy.movies-migration-percent}")
    int moviesMigrationPercent;

    public ProxyFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> gradualMigration && ThreadLocalRandom.current().nextInt(100) <= moviesMigrationPercent;
    }

    public static class Config {
    }
}
