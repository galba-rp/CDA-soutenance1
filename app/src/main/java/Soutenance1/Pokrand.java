package Soutenance1;

public class Pokrand extends Ptimos{

    Pokrand(){
        super();
        this.stress = stressLevel();
        this.dominance = dominanceLevel();
    }

    // Generating stress level of less then 65 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int stressLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(50, 65);
        } else return Helpers.randomValue(70, 81);
    }

    // Generating dominance level of more then 75 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int dominanceLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(75, 81);
        } else return Helpers.randomValue(50, 65);
    }

    // reduces player's life

    public static void magic(Player p, Ptimos ptimos){
        cards();
    }

    private static void cards(){

    }
}
