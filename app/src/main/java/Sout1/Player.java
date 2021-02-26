package Sout1;

import java.util.Random;

public class Player {
    String name = "";
    int vie ;
    int cages;
    int flechette;
    int friandise;
    int distance;

   Player(String name) {
        this.name = name;
        this.vie = 100;
        this.cages = 10;
        this.flechette = 1;
        this.friandise = 30;

        // 8 and 16 corresponds to minimum (inclusive) and maximum (exclusive) values
       // for randomDdistance to choose between
        this.distance = randomDistance(8, 16);

    }

    public void observer(Ptimos p){
       String name  = p.getClass().getSimpleName();
       System.out.format("Niveax de stress de %1$s est: %2$s\n", name, p.getStress());
        System.out.format("Niveax de dominance est: %s\n", p.getDominance());
    };

   private int randomDistance( int min, int max){
       Random r = new Random();
       return r.nextInt(max - min) + min;
   }

    public void approcher(Ptimos p){
        String name  = p.getClass().getSimpleName();
        int dist  = randomDistance(3, 9);
        this.distance = this.distance - dist;
        if (this.distance <= 0){
            System.out .println("Ptimos dans la cage");
        }else{
            System.out .println("Tu est à " +this.distance + "metres de "+ name);
        }
    }

    //public void friandise();
    //public void danser();
    //public void fleechette();
    //public void partir();

}
