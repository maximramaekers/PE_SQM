package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.serviceObjects.BaseService;
import postcodes.models.Postcode;
import postcodes.models.body.PostcodeBody;

import static io.restassured.RestAssured.when;

public class RandomPostcode extends BaseService {
    public RandomPostcode() {
        super("random/postcodes");
    }

    public Response getRandomPostcodeResponse() {
        Response response = when().get(this.baseUrl + this.endpoint);
        return response;
    }

    public PostcodeBody getRandomPostcode() {
        return Postcode.getPostcode(this.getRandomPostcodeResponse());
    }
}
