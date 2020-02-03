package robomixologist;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class robomixologistConfiguration extends Configuration {

    @NotEmpty
    private String defaultMixer = "seltzer";

    @NotEmpty
    private String[] juices = new String[]{"pomegranate","passionfruit","blackberry","lime","grapefruit","lemon"};

    @JsonProperty
    public String[] getJuices() {
        return juices;
    }

    @JsonProperty
    public String getDefaultMixer(){
        return defaultMixer;
    }

    @JsonProperty
    public void setDefaultMixer(String mixer){
        this.defaultMixer = mixer;
    }
}
