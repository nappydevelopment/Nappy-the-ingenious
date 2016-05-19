package nappydevelopment.nappyTheIngenious.data.character;

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

    public boolean equals(Age other){
        if(this == UNKNOWN || other == UNKNOWN){
            return true;
        }
        return this == other;
    }
}
