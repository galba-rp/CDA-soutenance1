package Soutenance1;

import Poker.Combo;
import Poker.Deal;

abstract class Ptimos {
    // possibility to add name attribute to identify by name
    protected int stress;
    protected static int dominance;


    Ptimos() {}

    // stress and dominance generators to implement for each type of Ptimos
    abstract int stressLevel();
    abstract int dominanceLevel();

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
        } else if(this.dominance > 25 && this.dominance <= 50){
            return "neutre";
        }else if (this.dominance > 51 && this.dominance <= 75){
            return "feroce";
        }else{
            return "dangereux";
        }
    }

    protected int getDominanceNum(){
        return this.dominance;
    }

    protected void setDominance(int dom) {
        this.dominance = dom;
    }

    protected static void reduceDominance(int n){
        dominance -= n;
    }

    protected void raiseDominance(int n){
        this.dominance += n;
        this.limitDominance();
    }

    protected void raiseStress(int n){
        stress += n;
    }

    protected void reduceStress(int n){
        this.stress -= n;
        limitStress();
    }

    private void limitDominance(){
        dominance = Math.min(dominance, 100);
        dominance = Math.max(dominance, 0);
    }

    protected void limitStress(){
        stress = Math.min(stress, 100);
        stress = Math.max(stress, 0);
    }

    public String roar(Ptimos ptimos){
        raiseDominance(10);
        reduceStress(10);
        return "roar";
    }

    public String attack(Player p, Ptimos ptimos){
        int life = p.getLife();
        life -=20;
        p.setLife(life);
        ptimos.raiseDominance(20);
        return "attack";
    }

    protected String magic(Player p, Ptimos ptimos) {
       return commonMagic(p,ptimos);
    }

    protected String getAway(Ptimos ptimos){
        Game.raiseDistance(2);
        return "getAway";
    };

    protected String escape(Player p, Ptimos ptimos){
        Game.startGame();
        return "escape";
    }

    protected static String commonMagic(Player p, Ptimos ptimos){
        p.reduceLife(25);
        reduceDominance(20);
        return "magic";
    }
}

