package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.models.Postcode;
import postcodes.models.body.PostcodeBody;
import postcodes.models.body.PostcodesBody;
import saucedemo.web.pageObjects.BasePageObject;

import postcodes.models.Postcodes;
import static io.restassured.RestAssured.when;

public class NearestPostcode extends BaseService {
    public NearestPostcode() {
        super("postcodes/");
    }

    public Response getNearestResponse(String postcode) {
        Response response = when().get(this.baseUrl + this.endpoint + postcode +"/nearest");
        return response;
    }

    public PostcodesBody getNearestPostcode(String postcode) {
        return Postcode.getPostcodes(this.getNearestResponse(postcode));
    }
}
