package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 01.05.2016.
 */
public enum Age {
    YOUNG("young"),
    ADULT("adult"),
    OLD("old"),
    UNKNOWN("unknown");

    private final String text;

    Age(String str) {
        this.text=str;
    }

    public String getText(){
        return text;
    }

    public static Age fromString(String b) {
        Age age;
        if(b.equals("adult")){
            age = Age.ADULT;
        }else if(b.equals("old")){
            age = Age.OLD;
        }else{
            age = Age.YOUNG;
        }
        return age;
    }
}
