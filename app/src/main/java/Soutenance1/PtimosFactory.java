package Soutenance1;

public class PtimosFactory implements Helpers{


    public static Ptimos createPtimos(){
        // creating Ptimos depending on total number in the cage and types captured
        // if less then five in the cage - creating either Sacbleu or Pyralia (2 to 1 proportion)
        // if more then five captured and both Sacbleu and Pyralia are in the cage -creating one of three types with equal probability
        if((Game.Sacbleu + Game.Pyralia) < 5 || Game.Sacbleu == 0 || Game.Pyralia == 0){
            if(Helpers.probabilityTwoToOne() == 1 ){
                return new Sacbleu();
            } else return new Pyralia();
        } else {
            int random = Helpers.randomValue(0,3);
            System.out.println("Random number :" + random);
            switch (random){
                case 0:
                    return new  Sacbleu();
                case 1:
                    return new Pyralia();
                default: return new Pokrand();
            }
        }
    }
}
