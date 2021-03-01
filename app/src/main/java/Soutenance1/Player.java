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

;    }

    public void observer(Ptimos p){
        String name  = p.getClass().getSimpleName();
    };

    public void approach(Ptimos p){
        String name  = p.getClass().getSimpleName();
        reduceDisatnce();
        /*
        if (d <= 0){
            System.out .println("Ptimos dans la cage");
        }else{
            System.out .println("Tu est à " +d + "metres de "+ name);
        }
         */
    }

    public void treat(Ptimos ptimos, int d){
        if(Helpers.reduceStressWithTreat(d) == 1){
            int stress = ptimos.getStressNum();
            ptimos.setStress( stress - 15);
        }
    }

    public void dance(Ptimos ptimos){
        int d = ptimos.getDominanceNum();
        System.out.format("CURRENT DOMINANCE %d%n",d);
        System.out.format("DOMINANCE equels" + (d - Helpers.randomValue(7, 22)) + "%n");
        ptimos.setDominance(d - Helpers.randomValue(7, 22));
    }
    public void arrow(Player p,Ptimos ptimos){
        if(arrow == 1 ) {
            arrow = 0;
            int chance = Helpers.randomValue(0, 2);
            System.out.println("CHANCEEEE :" + chance);
            if (chance == 1) {
                Game.ptimosInTOCage(ptimos);
                CliMessages.captured(ptimos);
                p.setLife(100);
                Game.startGame();
            } else CliMessages.missed();
        } else CliMessages.noMoreArrows();
    }
    //public void partir();



    protected static int getLife(){
        return life;
    }

    protected static void setLife(int l){
        life = l;
    }

    private void reduceDisatnce(){
        int d = Game.getDistance();
        int dist  = Helpers.randomValue(3, 9);
        Game.setDistance(d - dist);
    }

    void checkDistance(Ptimos ptimos){
        if(Game.getDistance() <= 1){
            CliMessages.captured(ptimos);
            Game.startGame();
        }
    }
}
