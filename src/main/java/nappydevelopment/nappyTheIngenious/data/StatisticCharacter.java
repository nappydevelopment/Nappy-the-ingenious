package nappydevelopment.nappyTheIngenious.data;

/**
 * Created by Marc on 13.04.2016.
 */
public class StatisticCharacter {

    String name;
    int amount;

    public StatisticCharacter(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
