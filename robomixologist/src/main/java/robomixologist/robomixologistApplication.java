package robomixologist;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import robomixologist.resources.MixerResource;
import robomixologist.resources.JuiceResource;
import robomixologist.health.TemplateHealthCheck;

public class robomixologistApplication extends Application<robomixologistConfiguration> {

    public static void main(String[] args) throws Exception {
        new robomixologistApplication().run(args);
    }

    @Override
    public void run(robomixologistConfiguration configuration,
                    Environment environment) {
        final MixerResource resource = new MixerResource(
                configuration.getDefaultMixer()
        );
        String[] juiceMixer = {resource.toString()};
        final JuiceResource resource2 = new JuiceResource(
                configuration.getJuices()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getDefaultMixer());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(resource2);
    }

}
