package nappydevelopment.nappyTheIngenious.util.eastereggs;

import java.util.ArrayList;
import java.util.List;

public class EastereggSearcher {
    private List<NelsonStage> ns = new ArrayList<>();

    public int lookFor(String str){
        if(str.equals("haha")){
            ns.add(NelsonStage.createNewNelson());
            return 1;
        }
        else if(str.equals("doh") || str.equals("d'oh")) {
            return 2;
        }
        else if(str.equals("nappy")) {
            return 3;
        }
        return 4;
    }

    public List<NelsonStage> getNelsonStages(){
        return ns;
    }


}
