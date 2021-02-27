package Sout1;

public class PtimosFactory implements Helpers{


    public Ptimos createPtimos(){
        // creating Ptimos depending on total number in the cage and types captured
        // if less then five in the cage creating either Sacbleu or Pyralia (2 to 1 proportion)
        // if more then five captured and both Sacbleu and Pyralia in the cage creating one of three types ith equal probability
        if((Game.sacbleuCaptured + Game.pyraliaCaptured) < 5 && Game.sacbleuCaptured > 0 && Game.pyraliaCaptured > 0){
            if(Helpers.probabilityTwoToOne() == 1 ){
                return new Sacbleu();
            } else return new Pyralia();
        }
    }
}
