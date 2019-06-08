package enums;

/**
 * Created by lovel on 14-Oct-18.
 */
public enum States {
NORTHANDHRAPRADESH("NORTH ANDHRAPRADESH"),
KERALA("KERALA");

private String value;

    @Override
    public String toString() {
        return value;
    }

    States(String value){
    this.value=value;





}
}
