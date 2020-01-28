package robomixologist;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class robomixologistConfiguration extends Configuration {

    @NotEmpty
    private String defaultMixer = "Seltzer";

    @JsonProperty
    public String getDefaultMixer(){
        return defaultMixer;
    }

    @JsonProperty
    public void setDefaultMixer(String mixer){
        this.defaultMixer = mixer;
    }
}
