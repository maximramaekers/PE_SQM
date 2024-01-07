package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.models.Postcode;
import postcodes.models.body.PostcodeBody;
import saucedemo.web.pageObjects.BasePageObject;

import static io.restassured.RestAssured.when;

public class NearestPostcode extends BaseService {
    public NearestPostcode() {
        super("postcodes/");
    }

    public Response getNearestResponse(String postcode) {
        Response response = when().get(this.baseUrl + this.endpoint + postcode +"/nearest");
        return response;
    }

    public PostcodeBody getNearestPostcode(String postcode) {
        return Postcode.getPostcode(this.getNearestResponse(postcode));
    }
}
