package ninja.catfact.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactPojo {
    @JsonProperty("fact")
    public String fact;
    @JsonProperty("length")
    public int length;
}
