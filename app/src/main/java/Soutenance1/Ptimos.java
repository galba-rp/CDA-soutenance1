package Soutenance1;

abstract class Ptimos {
    // possibility to add name attribute to identify by name
    int stress;
    int dominance;


    Ptimos() {}

    abstract int stressLevel();
    abstract  int dominanceLevel();

    protected int randomLevel(){
        return (int)Math.round(Math.random()*5);
    }

    //abstract int lowerStress();
    //abstract int raisedominance();
    //abstract void rugir();
    //abstract void attaque();

    //abstract void attaqueMagique();



    public String getStress() {
        if(this.stress <+ 25){
            return "detandu";
        } else if(this.stress > 25 && this.stress <= 50){
            return "mefiant";
        }else if (this.stress > 51 && this.stress <= 75){
            return "nerveux";
        }else{
            return "panique";
        }
    }

    public String getDominance() {
        if(this.dominance <+ 25){
            return "innoffensif";
        } else if(this.dominance > 25 && this.stress <= 50){
            return "neutre";
        }else if (this.dominance > 51 && this.stress <= 75){
            return "féroce";
        }else{
            return "dangereux";
        }
    }

    static void reaction(Player p, Ptimos ptimos){
        int d = p.getDistance();
        if(d > 15){
            escape(p, ptimos);
        }

        /*
        int probability = Helpers.probabilityHigh();
        if(this.stress > this.dominance){
            if(Player.distance > 3 && Player.distance < 10){
                if (probability == 1) {
                    this.rugir();
                } else {
                    this.attaquer();
                }
            }else if(Player.distance < 3){
                if (probability  == 1) {
                    this.attaquer();
                } else {
                    this.rugir();
                }
            } else{
                if (probability == 1) {
                    this.sEloigner();
                } else {
                    this.rugir();
                }
            }
        }else if (this.stress > this.dominance && Player.distance < 3) {
            this.attaquer();
        }else

         */
    }

    public void rugir(){
        this.dominance = Math.min(this.dominance +10, 100);
        this.stress = Math.max(0, this.stress -10);
    }

    public void attaquer(){
        ;
    }

    protected void sEloigner(){

    };

    private static void escape(Player p, Ptimos ptimos){
        CliMessages.ptimosEscapes(p, ptimos);
    }
    public void setDominance(int dominance) {
        this.dominance = dominance;
    }
}

