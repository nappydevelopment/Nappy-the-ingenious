package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 01.05.2016.
 */
public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    public static Gender fromBool(Boolean male) {
        Gender gen;
        if(male == true){
            gen = Gender.MALE;
        }else if(male == false){
            gen = Gender.FEMALE;
        }else{
            gen = Gender.UNKNOWN;
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
