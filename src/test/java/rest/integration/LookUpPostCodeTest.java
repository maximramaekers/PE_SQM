package rest.integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodes.models.body.PostcodeBody;
import postcodes.serviceObjects.AllServices;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

public class LookUpPostCodeTest {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }
    @Test
    public void LookUpPostCode(){
        PostcodeBody response = postcodeServices.lookupPostcode.getLookupPostcode("NW5 1AD");
        assertThat(response.result.latitude).isEqualTo(51.553646);
        assertThat(response.result.longitude).isEqualTo(-0.141062);
    }
}
