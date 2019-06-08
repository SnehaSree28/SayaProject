package enums;

/**
 * Created by lovel on 14-Nov-18.
 */
public enum BannerAds {
    HorizontalBanner("Horizontal Banner"),
    VerticalBanner("Vertical Banner");

    private String value;

    BannerAds(String value){
        this.value= value;
    }

    @Override
    public String toString() {
        return  value ;
    }
}
