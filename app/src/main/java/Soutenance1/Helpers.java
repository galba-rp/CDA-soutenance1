package Soutenance1;

import java.util.Random;

interface Helpers {

    static int randomValue(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    // returns 1 in 75% of cases
    static int probabilityHigh(){
        int random = randomValue(0, 100);
        if(random<75) {
            return 1;
        } else return 0;
    }

    static int probabilityTwoToOne(){
        int random = randomValue(0, 75);
        if(random<50) {
            return 1;
        } else return 0;
    }


}
