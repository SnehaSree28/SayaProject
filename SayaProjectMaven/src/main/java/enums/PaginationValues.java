package enums;

/**
 * Created by lovel on 07-Dec-18.
 */
public enum PaginationValues
{
    one("1"),
    two("2"),
    three("3"),
    four("4"),
    five("5"),
    six("6"),
    seven("7"),
    eight("8"),
    nine("9");
    private String value;

    @Override
    public String toString() {
        return  value ;
    }
    PaginationValues(String value){
        this.value=value;
        }
    }

