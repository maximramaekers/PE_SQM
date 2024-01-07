package rest.integration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postcodes.models.body.PostcodeBody;
import postcodes.serviceObjects.AllServices;

import static com.google.common.truth.Truth.assertThat;

public class ValidatePostcodesTest {
    private AllServices postcodeServices;

    @BeforeClass
    public void setup() {
        postcodeServices = new AllServices();
    }

///*    @Test
//    public void ValidatePostCode(){
//        PostcodeBody response = postcodeServices.validatePostcode.getValidatePostcode("NW5 1AD");
//        System.out.println(response.result.postcode);
//        //assertThat(response.result.).isEqualTo("true");
//    }*/
}
