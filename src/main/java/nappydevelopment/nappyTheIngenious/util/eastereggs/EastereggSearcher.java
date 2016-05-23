package nappydevelopment.nappyTheIngenious.util.eastereggs;

import java.util.ArrayList;
import java.util.List;

public class EastereggSearcher {
    private List<NelsonStage> ns = new ArrayList<>();

    public boolean lookFor(String str){
        if(str.equals("haha")){
            ns.add(NelsonStage.createNewNelson());
            return false;
        }
        else if(str.equals("doh") || str.equals("d'oh")) {
            return true;
        }
        else if(str.equals("nappy")) {
            new NappyStage();
            return false;
        }
        return false;
    }

    public List<NelsonStage> getNelsonStages(){
        return ns;
    }


}
