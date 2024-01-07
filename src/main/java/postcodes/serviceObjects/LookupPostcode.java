package postcodes.serviceObjects;

import io.restassured.response.Response;
import postcodes.models.Postcode;
import postcodes.models.body.PostcodeBody;
import static io.restassured.RestAssured.when;

public class LookupPostcode extends BaseService {
    public LookupPostcode() {
        super("postcodes/");
    }

    public Response getLookupResponse(String postcode) {
        Response response = when().get(this.baseUrl + this.endpoint + postcode);
        return response;
    }

    public PostcodeBody getLookupPostcode(String postcode) {
        return Postcode.getPostcode(this.getLookupResponse(postcode));
    }
}
