package robomixologist;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import robomixologist.resources.RobomixologistResource;
import robomixologist.health.TemplateHealthCheck;

public class robomixologistApplication extends Application<robomixologistConfiguration> {

    public static void main(String[] args) throws Exception {
        new robomixologistApplication().run(args);
    }

   /* @Override
    public String getName() {
        return "robomixologist";
    }

    @Override
    public void initialize(Bootstrap<robomixologistConfiguration> bootstrap) {
        // nothing to do yet
    }*/

    @Override
    public void run(robomixologistConfiguration configuration,
                    Environment environment) {
        final RobomixologistResource resource = new RobomixologistResource(
                configuration.getDefaultMixer()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getDefaultMixer());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
