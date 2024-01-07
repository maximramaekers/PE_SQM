package rest.integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodes.models.body.PostcodeBody;
import postcodes.serviceObjects.AllServices;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

public class GetRandomPostcodeTest {
    private AllServices postcodeServices;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test(groups = {"integration"})
    public void GetRandomPostcode() {
        Set<String> postcodes = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            PostcodeBody response = postcodeServices.randomPostcode.getRandomPostcode();
            postcodes.add(response.result.postcode);
        }
        assertThat(postcodes.size()).isGreaterThan(1);
    }
}
