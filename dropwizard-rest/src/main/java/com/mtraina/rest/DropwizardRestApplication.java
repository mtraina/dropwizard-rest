package com.mtraina.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardRestApplication extends Application<DropwizardRestConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardRestApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DropwizardRestConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropwizardRestConfiguration configuration,
                    Environment environment) {
        final DropwizardRestResource resource = new DropwizardRestResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
