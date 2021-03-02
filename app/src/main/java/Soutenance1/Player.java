package Soutenance1;
//TODO add messages for actions taken and their success
public class Player implements Helpers{
    String name = "";
    static int life;
    int cages;
    int arrow;
    int treats;


    Player(String name) {
        this.name = name;
        this.life = 100;
        this.cages = 10;
        this.arrow = 1;
        this.treats = 30;

    }
//TODO remove unused variable or add message
    public void observer(Ptimos p){
        String name  = p.getClass().getSimpleName();
    };

    public void approach(Ptimos p){
        Game.reduceDistance(Helpers.randomValue(3, 9));
    }

    // probability of reducing stress varies depending on the distance
    public void treat(Ptimos ptimos, int distance){
        if(Helpers.reduceStressWithTreat(distance) == 1){
            ptimos.reduceStress( 15);
        }
    }

    // dancing reduces dominance by random value
    public void dance(Ptimos ptimos){
        ptimos.reduceDominance(Helpers.randomValue(7, 22));
    }

    // arrow has a 50/50 chance to reach a target
    public void arrow(Player p,Ptimos ptimos){
        if(arrow == 1 ) {
            arrow = Math.max(arrow--, 0);
            int chance = Helpers.randomValue(0, 2);
            if (chance == 1) {
                Game.ptimosInTOCage(ptimos);
                CliMessages.captured(ptimos);
                Game.startGame();
            } else CliMessages.missed();
        } else CliMessages.noMoreArrows();
    }

    protected static int getLife(){
        return life;
    }

    protected static void setLife(int l){
        life = l;
    }

    protected static void reduceLife(int n){
        life -= n;
    }

    void checkDistance(Ptimos ptimos){
        if(Game.getDistance() <= 1){
            CliMessages.captured(ptimos);
            Game.startGame();
        }
    }
}
