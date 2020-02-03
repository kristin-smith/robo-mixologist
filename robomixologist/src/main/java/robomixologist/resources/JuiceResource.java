package robomixologist.resources;

import com.codahale.metrics.annotation.Timed;
import robomixologist.api.JuiceSelection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Path("/juice")
@Produces(MediaType.APPLICATION_JSON)

public class JuiceResource {
    private final String[] juices;
    private String value;
    private final AtomicLong counter;

    public JuiceResource(String[] juices) {
        this.juices = juices;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public JuiceSelection getJuice(@QueryParam("mixer") Optional<String> mixer) {
        String defaultMixer = "seltzer";
        final String selectedMixer = String.format(mixer.orElse(defaultMixer));
        final int[] selectRange = new int[2];
        switch(selectedMixer) {
            case "seltzer" : selectRange[0] = 0; selectRange[1] = 2;
                            break;
            case "tonic" : selectRange[0] = 3; selectRange[1] = 5;
                            break;
            default: selectRange[0] = 3; selectRange[1] = 5;
                            break;
        }
        int selectNumber = ThreadLocalRandom.current().nextInt(selectRange[0], selectRange[1]);
        value = this.juices[selectNumber];
        return new JuiceSelection(counter.incrementAndGet(), value);
    }
}
