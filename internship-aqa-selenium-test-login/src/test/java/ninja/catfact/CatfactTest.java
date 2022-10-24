package ninja.catfact;

import ninja.catfact.pojos.BreedPojo;
import ninja.catfact.pojos.FactPojo;
import ninja.catfact.steps.BreedSteps;
import ninja.catfact.steps.FactSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Catfact API tests")
public class CatfactTest {

    @Test
    @DisplayName("Receiving of total amount of objects with given fact length")
    public void getFactsWithLength(){
        Integer length = 40;
        Integer total = FactSteps.getTotal(length);

        assertEquals(total, 15);
    }

    @Test
    @DisplayName("Comparison of texts of facts")
    public void getFact(){
        List<FactPojo> facts = FactSteps.getFacts();
        String fact = facts.get(6).getFact();
        assertEquals(fact, "Every year, nearly four million cats are eaten in Asia.");
    }

    @Test
    @DisplayName("Comparison of facts")
    public void getFacts(){
        FactPojo fact = new FactPojo("Every year, nearly four million cats are eaten in Asia.", 55);
        List<FactPojo> facts = FactSteps.getFacts();
        assertEquals(facts.get(6), fact);
    }

    @Test
    @DisplayName("Comparison of breeds")
    public void getBreeds(){
        BreedPojo breed = new BreedPojo("Devon Rex", "United Kingdom (England)",
                "Mutation", "Rex", "All");

        List<BreedPojo> breeds = BreedSteps.getBreeds();

        assertEquals(breed, breeds.get(30));
    }

    @Test
    @DisplayName("Comparison given objects length on one page")
    public void getBreedsLimited(){
        Integer givenLimit = 50;
        Integer limit = BreedSteps.getLimit(givenLimit);

        assertEquals(limit, 50);
    }
}
