package robomixologist.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final String defaultMixer;

    public TemplateHealthCheck(String defaultMixer) {
        this.defaultMixer = defaultMixer;
    }

    @Override
    protected Result check() throws Exception {
        final String mixer = String.format(defaultMixer, "TEST");
        if (!mixer.contains("TEST")) {
            return Result.unhealthy("defaultMixer is missing - your bar has run dry");
        }
        return Result.healthy();
    }
}
