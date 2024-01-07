package postcodes.serviceObjects;

public class BaseService {
    protected String baseUrl = "https://postcodes.io/";
    protected String endpoint;

    public BaseService(String endpoint) {
        this.endpoint = endpoint;
    }
}
