package previousProjects.wearableDevices.classes;

public class Wearable {
    private int ranking;
    private String name;
    private Double price;
    private String bodyLocation;
    private String category;
    private String companyName;
    private String companyURL;
    private String companyMappingLocation;
    private String companyCity;
    private String companyUSState;
    private String companyCountry;

    public Wearable(int ranking, String name, Double price, String bodyLocation,
                    String category, String companyName, String companyURL,
                    String companyMappingLocation, String companyCity,
                    String companyUSState, String companyCountry) {
        this.ranking = ranking;
        this.name = name;
        this.price = price;
        this.bodyLocation = bodyLocation;
        this.category = category;
        this.companyName = companyName;
        this.companyURL = companyURL;
        this.companyMappingLocation = companyMappingLocation;
        this.companyCity = companyCity;
        this.companyUSState = companyUSState;
        this.companyCountry = companyCountry;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBodyLocation() {
        return bodyLocation;
    }

    public String getCategory() {
        return category;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public String getCompanyMappingLocation() {
        return companyMappingLocation;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public String getCompanyUSState() {
        return companyUSState;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    @Override
    public String toString() {
        return "Wearable{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bodyLocation='" + bodyLocation + '\'' +
                ", category='" + category + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyURL='" + companyURL + '\'' +
                ", companyMappingLocation='" + companyMappingLocation + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyUSState='" + companyUSState + '\'' +
                ", companyCountry='" + companyCountry + '\'' +
                '}';
    }
}
