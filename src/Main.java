import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Jeu game = new Jeu();
        game.start();


        /*Usine test = null;

        test = test.getInstance();


        Clone testClone;

        test.vagueEnnemi(1);
        testClone = (Clone) test.getListEnnemis().get(2);
        System.out.println(testClone.getLvl());
        System.out.println(testClone.getHp());



        Scanner sc = new Scanner(System.in);

        Personnage perso = null;

        System.out.print("Donnez un nom à votre personnage : ");
        String name = sc.nextLine();




        System.out.println("Tapez 1 pour un Jedi : ");
        System.out.println("Tapez 2 pour un Sith : ");
        System.out.println("Tapez 3 pour un BountyHunters : ");
        System.out.println("Tapez 4 pour un ImperialAgent : ");
        System.out.println("Tapez 5 pour un Mercenary : ");
        System.out.println("Tapez 6 pour un Jawa : ");
        System.out.print("Votre choix : ");
        Integer choix = sc.nextInt();


        Hashtable<Integer,Personnage> h = new Hashtable<Integer,Personnage>();
        h.put(1 , new Jedi(name));
        h.put(2, new Sith(name));
        h.put(3, new BountyHunter(name));
        h.put(4, new ImperialAgent(name));
        h.put(5, new Mercenary(name));
        h.put(6, new Jawa(name));


        perso = h.get(choix);

        System.out.println(testClone.getHp());*/

    }



}
