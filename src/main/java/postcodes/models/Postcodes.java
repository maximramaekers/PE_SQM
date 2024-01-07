package postcodes.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import postcodes.models.body.PostcodesBody;

import java.util.ArrayList;

public class Postcodes extends BaseModel {
    public ArrayList<Postcode> postcodes;

    public static PostcodesBody getPostcodes(Response response){
        return gson.fromJson(response.body().asString(), PostcodesBody.class);
    }
}