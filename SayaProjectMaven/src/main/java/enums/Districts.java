package enums;

/**
 * Created by lovel on 30-Oct-18.
 */
public enum Districts {
    EASTGODAVARI("East Godavari"),
    SRIKAKULAM("Srikakulam"),
    VIZAG("Visakhapatnam");

    @Override
    public String toString() {
        return value ;
    }

    private String value;

    Districts(String value)
    {
        this.value= value;
    }

}

