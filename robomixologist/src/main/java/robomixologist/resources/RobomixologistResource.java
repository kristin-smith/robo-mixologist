package robomixologist.resources;

import robomixologist.api.MixerSelection;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/mixer")
@Produces(MediaType.APPLICATION_JSON)

public class RobomixologistResource {
    private final String defaultMixer;
    private final AtomicLong counter;

    public RobomixologistResource (String defaultMixer) {
        this.defaultMixer = defaultMixer;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public MixerSelection sayHello(@QueryParam("mixer") Optional<String> mixer) {
        final String value = String.format(mixer.orElse(defaultMixer));
        return new MixerSelection(counter.incrementAndGet(), value);
    }
}
