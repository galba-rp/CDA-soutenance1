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

    public String getStress() {
        if(this.stress <= 25){
            return "detandu";
        } else if(this.stress > 25 && this.stress <= 50){
            return "mefiant";
        }else if (this.stress > 51 && this.stress <= 75){
            return "nerveux";
        }else{
            return "panique";
        }
    }

    protected int getStressNum(){
        return this.stress;
    }

    protected void setStress(int n){
        this.stress = n;
    }

    public String getDominance() {
        if(this.dominance <= 25){
            return "innoffensif";
        } else if(this.dominance > 25 && this.stress <= 50){
            return "neutre";
        }else if (this.dominance > 51 && this.stress <= 75){
            return "feroce";
        }else{
            return "dangereux";
        }
    }

    protected static int getDominanceNum(){
        return dominance;
    }

    public static void setDominance(int dominance) {
        dominance = dominance;
    }

    public static void roar(Ptimos ptimos){
        dominance = Math.min(ptimos.dominance +10, 100);
        stress = Math.max(0, ptimos.stress -10);
        CliMessages.roar(ptimos);
    }

    public static void attack(Player p, Ptimos ptimos){
        int life = p.getLife();
        life -=20;
        Player.setLife(life);
        ptimos.dominance += 5;
        CliMessages.attack(ptimos);
    }

    static void magic(Player p, Ptimos ptimos) {
        p.setLife(p.getLife() - 25);
        CliMessages.magickAttack(ptimos);
    }

    protected static void getAway(Ptimos ptimos){
        int distance = Game.getDistance();
        distance +=2;
        Game.setDistance(distance);
        CliMessages.getAway(ptimos);
    };

    protected static void escape(Player p, Ptimos ptimos){
        CliMessages.ptimosEscapes(p, ptimos);
        Game.startGame();
    }
}

