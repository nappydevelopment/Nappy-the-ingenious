package nappydevelopment.nappyTheIngenious.util.eastereggs;

public class EastereggSearcher {

    public static boolean lookFor(String str){
        if(str.equals("haha")){
            NelsonStage.createNewNelson();
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

}
