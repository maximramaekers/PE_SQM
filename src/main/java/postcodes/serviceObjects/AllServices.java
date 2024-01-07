package postcodes.serviceObjects;

public class AllServices {
    public RandomPostcode randomPostcode;
    public LookupPostcode lookupPostcode;

    public AllServices() {
        this.randomPostcode = new RandomPostcode();
        this.lookupPostcode = new LookupPostcode();
    }

}
