package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.models.Postcode;
import postcodes.models.body.PostcodeBody;

import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.when;

public class LookupPostcode extends BaseService {
    public LookupPostcode(String aze) {
        super("postcodes/" + aze);
    }

    public Response getLookupResponse() {
        Response response = when().get(this.baseUrl + this.endpoint);
        return response;
    }

    public PostcodeBody getLookupPostcode() {
        return Postcode.getPostcode(this.getLookupResponse());
    }
}
