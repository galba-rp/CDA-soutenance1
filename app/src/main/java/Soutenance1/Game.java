package Soutenance1;


import java.util.Scanner;


public class Game implements CliMessages {
    static Player player;
    static Ptimos ptimos;
    static Scanner input = new Scanner(System.in);
    static String s1 = "";
    static int Sacbleu= 0;
    static int Pyralia = 0;
    static int Pokrand = 0;
    private static int distance;

    public Game() {
        chooseName();
        CliMessages.hello(player);
        startGame();
        // 8 and 16 corresponds to minimum (inclusive) and maximum (exclusive) values
        // for randomValue to choose between
        // for randomValue to choose between


    }

    protected static int getDistance(){
        return distance;
    }
    protected static void setDistance(int d){
        distance = d;
    }

    private static void chooseName(){
        CliMessages.chooseName();
        s1 = input.nextLine();
        player = new Player(s1);
    }

    protected static void startGame(){
        distance = Helpers.randomValue(8, 15);
        ptimos = PtimosFactory.createPtimos();
        System.out.println("stress : " + ptimos.stress +", Dominance : " + ptimos.dominance);

        // meeting Ptimos choices
        CliMessages.ptimosToMeet(ptimos);
        s1 = input.nextLine().toLowerCase();
       if(s1.toLowerCase() == "n"){
                startGame();
        }
        while(player.getLife() > 0) {
            if (distance > 15) {
                Ptimos.escape(player, ptimos);
            }
            // interacting with Ptimos
            CliMessages.playerPtimosInfo(player, ptimos);
            CliMessages.ptimosInfo(ptimos);
            CliMessages.actions(player, ptimos);

            s1 = input.nextLine();
            switch (s1) {
                case "1":
                    player.observer(ptimos);
                    reaction();
                    break;
                case "2":
                    player.approach(ptimos);
                    ptimos.raiseStress(ptimos);
                    player.checkDistance(ptimos);
                    reaction();
                    break;
                case "3":
                    player.treat(ptimos, distance);
                    reaction();
                    break;
                case "4":
                    player.dance(ptimos);
                    reaction();
                    break;
                case "5":
                    player.arrow(player, ptimos);
                    reaction();
                    break;
                default:
                    break;
            }
        }
    }

    // ptimos reaction depending on distance stress level and dominance level
    protected static void reaction() {
        if(distance <= 1){
            ptimosInTOCage(ptimos);
           CliMessages.captured(ptimos);
           player.setLife(100);
           startGame();
        }
        if (ptimos.getDominanceNum() < 100) {
           if (distance >= 10) {
                reactionIfDistanceLarge();
            } else if(distance >= 3 && distance < 10) {
                reactionIfDistancMedium();
            } else reactionIfDistanceShort();
        } else ptimos.magic(player, ptimos);
    }

    private static void reactionIfDistanceLarge(){
        if (ptimos.getStressNum() <= 54) {
            if (ptimos.getDominanceNum() <= 56) {
                roarMoreOftenThenAttack();
            } else attackMoreOftenThenRoar();
        } else if (ptimos.getStressNum() > 54 && ptimos.getStressNum() <= 74){
            if (ptimos.getDominanceNum() <= 56) {
               getAwayOrAttackMoreOftenThenRoar();
            }
        } else if (ptimos.getStressNum() > 74 && ptimos.getStressNum() <= 85){
            getAwayMoreOftenThanRoarAndAttack();
        } else magicAttackPossible();
    }

    private static void reactionIfDistancMedium(){
        if (ptimos.getStressNum() <= 54) {
            if (ptimos.getDominanceNum() <= 56) {
                roarMoreOftenThenAttack();
            } else attackMoreOftenThenRoar() ;
        } else if (ptimos.getStressNum() > 54 && ptimos.getStressNum() <= 74){
            if (ptimos.getDominanceNum() <= 56) {
                roarMoreOftenThenAttackAndGetAway();
            } else {
                attackMoreOftenThenRoarAndGetAway();
            }
        } else if (ptimos.getStressNum() > 74 && ptimos.getStressNum() <= 85) {
            if (ptimos.getDominanceNum() <= 56) {
                getAwayMoreOftenThanRoarAndAttack();
            } else attackOrRoarOrGetAway();
        } else if(ptimos.getStressNum() > 85){
            if (ptimos.getDominanceNum() <= 56){
                roarAttackOrMagic();
            } else attackMoreOftenThenMagicOrRoar();
        }
    }
    // in all cases attack is most probable
    private static void reactionIfDistanceShort(){
        if (ptimos.getStressNum() <= 5){
            attackMoreOftenThenRoar();
        } else if(ptimos.getStressNum() > 54 && ptimos.getStressNum() <= 85){
            attackMoreOftenThenRoarAndGetAway();
        }else attackMoreOftenThenMagicOrRoar();
    }

    // probability to getAway is greater then other actions
    private static void getAwayMoreOftenThanRoarAndAttack(){
        if(Helpers.probabilityHigh() == 1){
            Ptimos.getAway(ptimos);
        } else {
            if (Helpers.probabilityHigh() == 1) {
                Ptimos.roar(ptimos);
            } else Ptimos.attack(player, ptimos);
        }
    }

    // equal probability for all actions
    private static void attackOrRoarOrGetAway() {
        switch (Helpers.randomValue(0, 3)) {
            case 0:
                Ptimos.attack(player, ptimos);
                break;
            case 1:
                Ptimos.roar(ptimos);
                break;
            default:
                Ptimos.getAway(ptimos);
        }
    }

    // roar probability is twice greater then attack
    private static void roarMoreOftenThenAttack() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.roar(ptimos);
        } else Ptimos.attack(player, ptimos);
    }
    // attack probability is twice greater then roar
    private static void attackMoreOftenThenRoar() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.attack(player, ptimos);
        } else Ptimos.roar(ptimos);
    }

    // attack probability is twice greater then roar and getAway
    private static void attackMoreOftenThenRoarAndGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.attack(player, ptimos);
        } else {
            roarMoreOftenThenGetAway();
        }
    }
    // roar probability is twice greater then attack and getAway
    private static void roarMoreOftenThenAttackAndGetAway(){
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.roar(ptimos);
        } else attackMoreOftenThenGetAway();
    }

    //roar probability is twice greater then  getAway
    private static void roarMoreOftenThenGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.roar(ptimos);
        } else Ptimos.getAway(ptimos);
    }

    //attack probability is twice greater then  getAway
    private static void attackMoreOftenThenGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.attack(player, ptimos);
        } else Ptimos.getAway(ptimos);
    }

    // roar and attack probabilities are equal
    private void attackOrRoar() {
        if (Helpers.randomValue(0, 2) == 1) {
            Ptimos.attack(player, ptimos);
        } else Ptimos.roar(ptimos);
    }

    // probabilities of all 4 possible reactions are equal
    private static void magicAttackPossible() {
        switch (Helpers.randomValue(0, 4)) {
            case 0:
                Ptimos.attack(player, ptimos);
                break;
            case 1:
                Ptimos.roar(ptimos);
                break;
            case 2:
                Ptimos.magic(player, ptimos);
                break;
            default:
                Ptimos.getAway(ptimos);
        }
    }

    private static void roarAttackOrMagic(){
        if (Helpers.probabilityHigh() == 1){
            switch (Helpers.randomValue(0, 2)) {
                case 0:
                    Ptimos.attack(player, ptimos);
                    break;
                default:
                    Ptimos.roar(ptimos);
                    break;
            }
        } else Ptimos.magic(player, ptimos);
    }
    private static void attackMoreOftenThenMagicOrRoar() {
        if (Helpers.probabilityHigh() == 1) {
            Ptimos.attack(player, ptimos);
        } else {
            switch (Helpers.randomValue(0, 2)) {
                case 0:
                    Ptimos.roar(ptimos);
                    break;
                default:
                    Ptimos.magic(player, ptimos);
            }
        }
    }

        private static void getAwayOrAttackMoreOftenThenRoar(){
            if (Helpers.probabilityHigh() == 1){
                switch (Helpers.randomValue(0, 2)) {
                    case 0:
                        Ptimos.attack(player, ptimos);
                        break;
                    default:
                        Ptimos.getAway(ptimos);
                        break;
                }
            } else Ptimos.roar(ptimos);
        }

        static void ptimosInTOCage(Ptimos ptimos){
            switch (ptimos.getClass().getSimpleName()){
                case "Sacbleu":
                    Sacbleu++;
                    break;
                case "Pyralia":
                    Pyralia++;
                    break;
                default:
                    Pokrand++;
                    break;
            }
        }


}





