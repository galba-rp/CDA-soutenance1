package Soutenance1;

public class Player implements Helpers{
    String name = "";
    static int life;
    int cages;
    int flechette;
    int friandise;
    private static int  distance;


    Player(String name) {
        this.name = name;
        this.life = 100;
        this.cages = 10;
        this.flechette = 1;
        this.friandise = 30;

        // 8 and 16 corresponds to minimum (inclusive) and maximum (exclusive) values
        // for randomValue to choose between
        this.distance = Helpers.randomValue(8, 15);

    }

    public void observer(Ptimos p){
        String name  = p.getClass().getSimpleName();
        System.out.format("%s semble %s et %s%n", name, p.getStress(), p.getDominance());

    };

    public void approcher(Ptimos p){
        String name  = p.getClass().getSimpleName();
        int dist  = Helpers.randomValue(3, 9);
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

    protected static int getDistance(){
        return distance;
    }

    protected static void setDistance(int d){
        distance = d;
    }

    protected static int getLife(){
        return life;
    }

    protected static void setLife(int l){
        life = l;
    }

}
