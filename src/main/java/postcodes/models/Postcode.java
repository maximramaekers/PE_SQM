package postcodes.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import postcodes.models.body.PostcodeBody;
import postcodes.models.body.PostcodesBody;

public class Postcode extends BaseModel {
    public String postcode;
    public int quality;
    public int eastings;
    public int northings;
    public String country;
    public String nhs_ha;
    public double longitude;
    public double latitude;
    public String european_electoral_region;
    public String primary_care_trust;
    public String region;
    public String lsoa;
    public String msoa;
    public String incode;
    public String outcode;
    public String parliamentary_constituency;
    public String admin_district;
    public String parish;
    public String admin_county;
    public String date_of_introduction;
    public String admin_ward;
    public String ced;
    public String ccg;
    public String nuts;
    public String pfa;
    public Codes codes;

    public static PostcodeBody getPostcode(Response response){
        return gson.fromJson(response.body().asString(), PostcodeBody.class);
    }

    public static PostcodesBody getPostcodes(Response response){
        return gson.fromJson(response.body().asString(), PostcodesBody.class);
    }
}

class Codes{
    public String admin_district;
    public String admin_county;
    public String admin_ward;
    public String parish;
    public String parliamentary_constituency;
    public String ccg;
    public String ccg_id;
    public String ced;
    public String nuts;
    public String lsoa;
    public String msoa;
    public String lau2;
    public String pfa;
}