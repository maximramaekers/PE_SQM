package rest.integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodes.models.Postcode;
import postcodes.models.Validation;
import postcodes.models.body.PostcodeBody;
import postcodes.models.body.PostcodesBody;
import postcodes.serviceObjects.AllServices;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class NearestPostcodeTest {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }
    @Test(groups = {"integration"})
    public void NearestPostCode(){
        PostcodesBody response = postcodeServices.nearestPostcode.getNearestPostcode("NW5 1AD");

        // Expected postcodes array
        String[] expectedPostcodes = new String[] {
                "NW5 1AD",
                "NW5 2HG",
                "NW5 1BF",
                "NW5 1AE",
                "NW5 1UE",
                "NW5 2JP",
                "NW5 2HH",
                "NW5 2PA",
                "NW5 2HB",
                "NW5 1BD"
        };

        // Actual postcodes array from the response
        String[] actualPostcodes = response.result.stream()
                .map(postcode -> postcode.postcode)
                .toArray(String[]::new);

        // Compare expected and actual postcodes arrays
        assertArrayEquals("The postcodes should match", expectedPostcodes, actualPostcodes);
    }
}
