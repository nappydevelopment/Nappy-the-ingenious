package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 01.05.2016.
 */
public class CharacterFilter{

    private String searchStr;
    private Gender gender;
    private Age age;

    public CharacterFilter(String searchStr, Gender gender, Age age) {
        this.searchStr=searchStr;
        this.gender=gender;
        this.age=age;
    }

    public CharacterFilter(String searchStr) {
        this.searchStr=searchStr;
        this.gender=Gender.UNKNOWN;
        this.age=Age.UNKNOWN;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public Gender getGender() {
        return gender;
    }

    public Age getAge() {
        return age;
    }
}
