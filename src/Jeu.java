import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Anthony on 29/02/2016.
 */
public class Jeu {

    private Scanner entreStd;
    private Boolean gameOver;
    private String nomJoueur;
    private Integer choixJoueur;
    private Hashtable tabChoixClasse;
    private Personnage leJoueur;

    public Jeu() {

        setEntreStd(new Scanner(System.in));
        setGameOver(false);
        setNomJoueur(null);
        setChoixJoueur(null);
        setTabChoixClasse(new Hashtable<Integer, Personnage>());
        setLeJoueur(null);
    }

    public void start() {

        menuStart(true);
        try {
            Integer choiceSafe = getEntreStd().nextInt();
            setChoixJoueur(choiceSafe);
        } catch (Exception e) {
            //System.out.println("Veuillez entrer un chiffre entre 1 et 6 !");
            menuStart(false);
        }
        tabChoix();

        while (!getGameOver()) {
            System.out.println("Le jeu peut commencer '" + getNomJoueur() + "' ! voici les stats de votre ");

            setGameOver(true);
        }
    }

    public void menuStart(Boolean first) {

        if (first) {
            System.out.print("Donnez un nom à votre personnage : ");
            setNomJoueur(getEntreStd().nextLine());
        }

        System.out.println("Tapez 1 pour un Jedi");
        System.out.println("Tapez 2 pour un Sith");
        System.out.println("Tapez 3 pour un BountyHunters");
        System.out.println("Tapez 4 pour un ImperialAgent");
        System.out.println("Tapez 5 pour un Mercenary");
        System.out.println("Tapez 6 pour un Jawa");
        System.out.print("Votre choix : ");

    }

    public void tabChoix() {

        getTabChoixClasse().put(1, new Jedi(getNomJoueur()));
        getTabChoixClasse().put(2, new Sith(getNomJoueur()));
        getTabChoixClasse().put(3, new BountyHunter(getNomJoueur()));
        getTabChoixClasse().put(4, new ImperialAgent(getNomJoueur()));
        getTabChoixClasse().put(5, new Mercenary(getNomJoueur()));
        getTabChoixClasse().put(6, new Jawa(getNomJoueur()));
    }

    // GETTERS
    public Scanner getEntreStd() {
        return entreStd;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public Integer getChoixJoueur() {
        return choixJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public Hashtable getTabChoixClasse() {
        return tabChoixClasse;
    }

    public Personnage getLeJoueur() {
        return leJoueur;
    }

    // SETTERS
    public void setEntreStd(Scanner entreStd) {
        this.entreStd = entreStd;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setChoixJoueur(Integer choixJoueur) {
        this.choixJoueur = choixJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setTabChoixClasse(Hashtable tabChoixClasse) {
        this.tabChoixClasse = tabChoixClasse;
    }

    public void setLeJoueur(Personnage leJoueur) {
        this.leJoueur = leJoueur;
    }
}