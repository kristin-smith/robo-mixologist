package robomixologist.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class JuiceSelection {
    private long id;

    //Set some limits on your return value (thankfully, just returning id and content)
    @Length(max = 15)
    private String content;

    public JuiceSelection() {
        // what does the deserializer need this for?
    }

    //Turn your outputs into JSON properties
    public JuiceSelection(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
