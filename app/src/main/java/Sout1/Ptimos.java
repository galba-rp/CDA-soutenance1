package Sout1;

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
    //abstract void sEloigner();
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

    public void rugir(){
        this.dominance +=10;
        this.stress -=10;
    }

    public void attaquer(){
        ;
    }

    public void setDominance(int dominance) {
        this.dominance = dominance;
    }
}
