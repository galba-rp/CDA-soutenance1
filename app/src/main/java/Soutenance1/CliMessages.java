package Soutenance1;

interface CliMessages {
    static void chooseName(){
        System.out.format("Hi choose your name %n");
    }

    static void hello(Player p){
        System.out.format("Hello %s %n", p.name);
    }

    static void ptimosToMeet(Ptimos p){
        System.out.format("Un " + p.getClass().getSimpleName() + " ce cache dans ce bois, voulez-vous le caprturer ?%n" +
                "[O] - Oui %n" + "[N] - Non %n");
    }

    static void actions(Player p, Ptimos ptimos){
        System.out.format("[1] - Observer%n" +
                "[2] - Se raprocher%n"+
                "[3] - Lancer une friandise(x%d)%n" +
                "[4] - Faire une danse impresionnante%n"+
                "[5] - Tirer une flechette endormante (%d)%n%n" +
                "[0] - Laisser le %s.%n", p.treats, p.arrow, ptimos.getClass().getSimpleName());
    }

    static void youLost(){
        System.out.format("Vous avez perdu %n%n");
        System.out.format("Voulez-vous recommencer [O] - Oui %n [N] - Non %n%n [Q] - Quiter le jeu%n");
    }

    static void bye(Player p){
        System.out.format("Au revoir %s %n%n", p.name);
    }

    static void playerPtimosInfo(Player p, Ptimos ptimos){
        System.out.format("%s (%d)%n%n", p.name, p.life);
        System.out.format("%s semble %s et %s%n%n", ptimos.getClass().getSimpleName(), ptimos.getStress(), ptimos.getDominance());
        System.out.format("Vous etes à %dm d'un %s suavage, que souhatitez-vous faire%n", Game.getDistance(), ptimos.getClass().getSimpleName());
    }

    static void ptimosInfo(Ptimos ptimos){
        System.out.format("his Stress : %d  his Dominance : %d%n%n", ptimos.getStressNum(), ptimos.getDominanceNum());
    }

    static void ptimosEscapes(Player p, Ptimos ptimos){
        System.out.format("Vous etes à %dm d'un %s suavage, %s e'enfuit !!!%n", Game.getDistance(), ptimos.getClass().getSimpleName(), ptimos.getClass().getSimpleName());
    }

    static void captured(Ptimos ptimos){
        System.out.format("Un %s dans la cage%n", ptimos.getClass().getSimpleName());
    }

    static void roar(Ptimos ptimos){
        System.out.format("%s vient de rugir%n", ptimos.getClass().getSimpleName());
    }

    static void getAway(Ptimos ptimos){
        System.out.format("%s vient de s'eloigner%n", ptimos.getClass().getSimpleName());
    }

    static void attack(Ptimos ptimos){
        System.out.format("%s vient de vous attaquer%n", ptimos.getClass().getSimpleName());
    }

    static void magicAttack(Ptimos ptimos){
        System.out.format("%s vient de lancer une  attaque magique%n", ptimos.getClass().getSimpleName());
    }

    static void noMoreArrows(){
        System.out.format("No more arrows left%n");
    }

    static void missed(){
        System.out.format("You have missed, No more arrows left%n");
    }

    static void pokerandEscapes(){
        System.out.format("Pokerand s'enfuit%n");
    }

    static void pokerandWins(){
        System.out.format("Pokerand vous assomme et libere les ptimos%n");
    }

    static void pokerandMagicAttack(){System.out.format("Pokerand  vient de lancer une  attaque magique%n");}
}
