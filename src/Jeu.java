import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by Anthony on 29/02/2016.
 */
public class Jeu {

    private Scanner entreStd;
    private Boolean gameOver;
    private String nomJoueur;
    private Integer choixJoueur;
    private Hashtable<Integer, Personnage> tabChoixClasse;
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

        while (getChoixJoueur() == null){
            menuStart(false);
        }

        tabChoix();

        leJoueur = (Personnage) getTabChoixClasse().get(getChoixJoueur());

        Usine factory = null;
        
        factory.getInstance();

        while (!getGameOver()) {

            getStat();

            //leJoueur.forceAttack();

            setGameOver(true);
        }
    }

    public void getStat() {

        System.out.println("Le jeu peut commencer '" + getNomJoueur() + "' ! Voici les stats de votre " + leJoueur.getClass().getName() + " :");
        System.out.println("Level : " + leJoueur.getLvl());
        System.out.println("PV : " + leJoueur.getHp());
        System.out.println("Défense : " + leJoueur.getDef());
        System.out.println("Puissance : " + leJoueur.getPower());
        System.out.println("La Force : " + leJoueur.getForce());
        System.out.println("Intelligence : " + leJoueur.getIntelligence());
        System.out.println("XP : " + leJoueur.getXp());
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

        try {
            Integer choixFin = getEntreStd().nextInt();
            setChoixJoueur(choixFin);
        } catch (InputMismatchException e) {
            System.out.println("\nEntrez un nombre entre un 1 et 6\n");
            getEntreStd().next();
        }


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
