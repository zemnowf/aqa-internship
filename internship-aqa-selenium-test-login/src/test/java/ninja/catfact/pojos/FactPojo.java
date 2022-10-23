package ninja.catfact.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactPojo {
    @JsonProperty("fact")
    public String fact;
    @JsonProperty("length")
    public int length;

    @JsonCreator
    public FactPojo(@JsonProperty("fact") String fact, @JsonProperty("length") int length){
        this.fact = fact;
        this.length = length;
    }

    public FactPojo() {
    }
}
