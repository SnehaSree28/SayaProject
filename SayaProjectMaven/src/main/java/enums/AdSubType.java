package enums;

/**
 * Created by lovel on 04-Nov-18.
 */
public enum AdSubType {
    HorizontalBannner("Horizontal Banner"),
    VerticalBanner("Vertical Banner"),
    BouncingBug("Bouncing Bug"),
    FlyingBug("Flying Bug"),
    BoxBug("Box Bug"),
    AnimatingLBar("Animating LBar"),
    StaticLbar("Static LBar");


    private String value;

    AdSubType(String value){
        this.value= value;
    }

    @Override
    public String toString() {
        return  value;
    }
}
