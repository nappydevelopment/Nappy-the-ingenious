package nappydevelopment.nappyTheIngenious.data.character;

public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    public static Gender fromBool(Boolean male) {
        Gender gen;
        if(male == null){
            gen = Gender.UNKNOWN;
        }else if(male){
            gen = Gender.MALE;
        }else{
            gen = Gender.FEMALE;
        }
        return gen;
    }

    public boolean equals(Gender other){
        if(this == UNKNOWN || other == UNKNOWN){
            return true;
        }
        return this == other;
    }
}
