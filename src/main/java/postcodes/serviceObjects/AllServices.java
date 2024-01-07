package postcodes.serviceObjects;

public class AllServices {
    public RandomPostcode randomPostcode;
    public LookupPostcode lookupPostcode;
    public ValidatePostcode validatePostcode;
    public NearestPostcode nearestPostcode;

    public AllServices() {
        this.randomPostcode = new RandomPostcode();
        this.lookupPostcode = new LookupPostcode();
        this.validatePostcode = new ValidatePostcode();
        this.nearestPostcode = new NearestPostcode();
    }
}
