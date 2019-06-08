package enums;

/**
 * Created by lovel on 04-Nov-18.
 */
public enum AdType {
    AudioAds("Audio Ads"),
    BannerAds("Banner Ads"),
    BugAds("Bug Ads"),
    LbarAds("Lbar Ads");
    private String value;
    @Override
    public String toString() {
        return value ;
    }
    AdType(String value)
    {
        this.value=value;
    }
}
