package ninja.catfact.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreedPojo {
        private String breed;
        private String country;
        private String origin;
        private String coat;
        private String pattern;
}
