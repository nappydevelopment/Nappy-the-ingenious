package nappydevelopment.nappyTheIngenious.util.eastereggs;

import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.data.character.CharacterFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marc on 07.06.2016.
 */
public class ShowNelsonOnHaha {

    public List<Character> getThem(List<Character> list, CharacterFilter search) {
        List<Character> nelsonList = new ArrayList<Character>();
        List<Character> charList = list.stream()
                .filter(c -> {
                    if(search.getSearchStr().isEmpty()){return true;}
                    return c.getName().toLowerCase().contains("nelson");
                }).collect(Collectors.toList());
            nelsonList.add(charList.get(0));

        return (List<Character>)nelsonList;
    }
}
