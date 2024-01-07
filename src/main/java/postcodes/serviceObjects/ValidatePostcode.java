package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.models.Postcode;
import postcodes.models.Validation;

import static io.restassured.RestAssured.when;

public class ValidatePostcode extends BaseService {
    public ValidatePostcode() {
        super("postcodes/");
    }

    public Response getValidateResponse(String postcode) {
        Response response = when().get(this.baseUrl + this.endpoint + postcode +"/validate");
        return response;
    }

    public Validation getValidatePostcode(String postcode) {
        return Postcode.getValidationResponse(this.getValidateResponse(postcode));
    }
}
