package postcodes.models;


import io.restassured.response.Response;

public class Validation extends BaseModel {
    public int status;
    public boolean result;

    public static Validation getValidationResponse(Response response){
        return gson.fromJson(response.body().asString(), Validation.class);
    }
}
