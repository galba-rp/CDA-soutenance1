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
                "[O] - Oui %n" + "[N] - Non %n" + "%n [Q] - Quiter le jeu%n");
    }

    static void actions(Player p, Ptimos ptimos){
        System.out.format("[1] - Observer%n" +
                "[2] - Se raprocher%n"+
                "[3] - Lancer une friandise(x%d)%n" +
                "[4] - Faire une danse impresionnante%n"+
                "[5] - Tirer une flechette endormante (%d)%n%n" +
                "[0] - Laisser le %s.%n", p.friandise, p.flechette, ptimos.getClass().getSimpleName());
    }

    static void bye(Player p){
        System.out.format("Good-bye %s %n", p.name);
    }

    static void playerPtimosInfo(Player p, Ptimos ptimos){
        System.out.format("%s (%d)%n%n", p.name, p.vie);
        System.out.format("Vous êtes à %dm d'un %s suavage, que souhatitez-vous faire%n", p.getDistance(), ptimos.getClass().getSimpleName());
    }

    static void ptimosEscapes(Player p, Ptimos ptimos){
        System.out.format("Vous êtes à %dm d'un %s suavage, %s e'enfuit !!!%n", p.getDistance(), ptimos.getClass().getSimpleName());
    }
}
