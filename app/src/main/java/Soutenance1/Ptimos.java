package Soutenance1;

abstract class Ptimos {
    // possibility to add name attribute to identify by name
    static int stress;
    static int dominance;


    Ptimos() {}

    abstract int stressLevel();
    abstract  int dominanceLevel();

    // checking if ptimios more stressed or more dominant for reaction decision
    protected static String stressDominanceRatio(){
        if(stress > dominance){
            return "stressed";
        } else return "dominant";
    }
    //abstract int lowerStress();
    //abstract int raisedominance();
    //abstract void rugir();
    //abstract void attaque();

    //abstract void attaqueMagique();

    protected int getStressNum(){
        return this.stress;
    }

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




    public void rugir(){
        this.dominance = Math.min(this.dominance +10, 100);
        this.stress = Math.max(0, this.stress -10);
    }

    public static void attack(Player p, Ptimos ptimos){
        int life = p.getLife();
        life -=20;
        Player.setLife(life);
        ptimos.domin  ance += 5;
    }

    protected static void getAway(Player p){
        int distance = p.getDistance();
        distance +=2;
        Player.setDistance(distance);
    };

    protected static void escape(Player p, Ptimos ptimos){
        CliMessages.ptimosEscapes(p, ptimos);
        Game.startGame();
    }
    public void setDominance(int dominance) {
        this.dominance = dominance;
    }
}

