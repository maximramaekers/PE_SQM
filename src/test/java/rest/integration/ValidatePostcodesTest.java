package rest.integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodes.models.Validation;
import postcodes.models.body.PostcodeBody;
import postcodes.models.body.ValidationBody;
import postcodes.serviceObjects.AllServices;

import static com.google.common.truth.Truth.assertThat;

public class ValidatePostcodesTest {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

    @Test(groups = {"integration"})
    public void ValidatePostCode(){
        Validation response = postcodeServices.validatePostcode.getValidatePostcode("NW5 1AD");
        assertThat(response.result).isEqualTo(true);
    }
}
