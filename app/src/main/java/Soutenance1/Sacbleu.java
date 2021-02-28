package Soutenance1;

public class Sacbleu extends Ptimos implements Helpers{
    int stress;
    int dominance;

    // TODO randimise initiall stress and dominance levels
    public Sacbleu() {
        super();
        this.stress = stressLevel();
        this.dominance = dominanceLevel();

    }

    // Generating stress level of more then 65 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int stressLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(65, 81);
        } else return Helpers.randomValue(50, 65);
    }

    // Generating dominance level of more less then 65 in 75% of cases.
    // Percentage can be adjusted in probability function
    public int dominanceLevel(){
        if(Helpers.probabilityHigh() == 1){
            return Helpers.randomValue(50, 65);
        } else return Helpers.randomValue(65, 81);
    }




    //abstract void attaque();
    //abstract void sEloigner();
    //abstract void attaqueMagique();
}
