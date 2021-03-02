package Soutenance1;


import java.util.Scanner;


public class Game implements CliMessages {
    private static Player player;
    private static Ptimos ptimos;
    private static Scanner input = new Scanner(System.in);
    private static String s1 = "";
    protected static int Sacbleu= 0;
    protected static int Pyralia = 0;
    protected static int Pokrand = 0;
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

    protected static void raiseDistance(int n){
        distance += n;
    }

    protected static void reduceDistance(int n){
        distance -= n;
    }

    private static void chooseName(){
        CliMessages.chooseName();
        s1 = input.nextLine();
        player = new Player(s1);
    }

    protected static void startGame(){
        generateDistance();
        generatePtimos();
        player.setLife(100);

        // meeting Ptimos choices
        CliMessages.ptimosToMeet(ptimos);
        CliMessages.ptimosInfo(ptimos);
        s1 = input.nextLine().toLowerCase();
       if(s1.toLowerCase() == "n"){
                startGame();
        }
        while(player.getLife() > 0) {
            if (distance > 15) {
                ptimos.escape(player, ptimos);
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
                    ptimos.raiseStress(10);
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
            ptimos.getAway(ptimos);
        } else {
            if (Helpers.probabilityHigh() == 1) {
                ptimos.roar(ptimos);
            } else ptimos.attack(player, ptimos);
        }
    }

    // equal probability for all actions
    private static void attackOrRoarOrGetAway() {
        switch (Helpers.randomValue(0, 3)) {
            case 0:
                ptimos.attack(player, ptimos);
                break;
            case 1:
                ptimos.roar(ptimos);
                break;
            default:
                ptimos.getAway(ptimos);
        }
    }

    // roar probability is twice greater then attack
    private static void roarMoreOftenThenAttack() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.roar(ptimos);
        } else ptimos.attack(player, ptimos);
    }
    // attack probability is twice greater then roar
    private static void attackMoreOftenThenRoar() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.attack(player, ptimos);
        } else ptimos.roar(ptimos);
    }

    // attack probability is twice greater then roar and getAway
    private static void attackMoreOftenThenRoarAndGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.attack(player, ptimos);
        } else {
            roarMoreOftenThenGetAway();
        }
    }
    // roar probability is twice greater then attack and getAway
    private static void roarMoreOftenThenAttackAndGetAway(){
        if (Helpers.probabilityHigh() == 1) {
            ptimos.roar(ptimos);
        } else attackMoreOftenThenGetAway();
    }

    //roar probability is twice greater then  getAway
    private static void roarMoreOftenThenGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.roar(ptimos);
        } else ptimos.getAway(ptimos);
    }

    //attack probability is twice greater then  getAway
    private static void attackMoreOftenThenGetAway() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.attack(player, ptimos);
        } else ptimos.getAway(ptimos);
    }

    // roar and attack probabilities are equal
    private void attackOrRoar() {
        if (Helpers.randomValue(0, 2) == 1) {
            ptimos.attack(player, ptimos);
        } else ptimos.roar(ptimos);
    }

    // probabilities of all 4 possible reactions are equal
    private static void magicAttackPossible() {
        switch (Helpers.randomValue(0, 4)) {
            case 0:
                ptimos.attack(player, ptimos);
                break;
            case 1:
                ptimos.roar(ptimos);
                break;
            case 2:
                ptimos.magic(player, ptimos);
                break;
            default:
                ptimos.getAway(ptimos);
        }
    }

    private static void roarAttackOrMagic(){
        if (Helpers.probabilityHigh() == 1){
            switch (Helpers.randomValue(0, 2)) {
                case 0:
                    ptimos.attack(player, ptimos);
                    break;
                default:
                    ptimos.roar(ptimos);
                    break;
            }
        } else ptimos.magic(player, ptimos);
    }
    private static void attackMoreOftenThenMagicOrRoar() {
        if (Helpers.probabilityHigh() == 1) {
            ptimos.attack(player, ptimos);
        } else {
            switch (Helpers.randomValue(0, 2)) {
                case 0:
                    ptimos.roar(ptimos);
                    break;
                default:
                    ptimos.magic(player, ptimos);
            }
        }
    }

        private static void getAwayOrAttackMoreOftenThenRoar(){
            if (Helpers.probabilityHigh() == 1){
                switch (Helpers.randomValue(0, 2)) {
                    case 0:
                        ptimos.attack(player, ptimos);
                        break;
                    default:
                        ptimos.getAway(ptimos);
                        break;
                }
            } else ptimos.roar(ptimos);
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

        private static void generateDistance(){
            distance = Helpers.randomValue(8, 15);
        }

    private static void generatePtimos(){
        ptimos = PtimosFactory.createPtimos();;
    }

    private void messageAfterReaction(String reaction){
        switch (reaction){
            case "roar":
                CliMessages.roar(ptimos);
                break;
            case "attack":
                CliMessages.attack(ptimos);
                break;
            case "magic":
                CliMessages.magicAttack(ptimos);
                break;
            case "getAway":
                CliMessages.getAway(ptimos);
                break;
            case "escape":
                CliMessages.ptimosEscapes(player, ptimos);
            case "Cards magic attack":
                CliMessages.pokerandMagicAttack();
                break;
            default: break;
        }
    }

}





