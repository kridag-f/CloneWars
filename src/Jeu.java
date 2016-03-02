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
    private Integer choixEnnemi;
    private Integer choixAttaque;
    private Hashtable<Integer, Personnage> tabChoixClasse;
    private Personnage leJoueur;

    public Jeu() {

        setEntreStd(new Scanner(System.in));
        setGameOver(false);
        setNomJoueur(null);
        setChoixEnnemi(0);
        setChoixAttaque(0);
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

        Salle room = new Salle();

        Usine factory = null;

        Usine usine = factory.getInstance();

        Integer choixEnnemyAttaquer;

        Boolean checkNumber = false;

        room.creationSalle(usine);

        getStat(getLeJoueur());
        System.out.println("Le jeu peut commencer '" + getNomJoueur() + "' ! ");

        while (!getGameOver()) {

            do {
                if (checkNumber) System.out.println("\nEntrez un nombre entre un 1 et 3\n");
                System.out.println("1 : Attaquer Clone");
                System.out.println("2 : Attaquer Soldat");
                System.out.println("3 : Attaquer Droid");
                System.out.print("Votre choix : ");
                try {
                    choixEnnemyAttaquer = getEntreStd().nextInt();
                    setChoixEnnemi(choixEnnemyAttaquer);
                    checkNumber = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nEntrez un nombre entre un 1 et 3\n");
                    getEntreStd().next();
                    checkNumber = false;
                }

            } while (getChoixEnnemi() < 1 || getChoixEnnemi() > 3);



            Personnage ennemie = usine.unEnnemi(getChoixEnnemi());
            //Boolean ennemiExist = ennemie != null ? true : false;


            while (ennemie.getHp() > 0) {
                checkNumber = false;

                do {
                    if (checkNumber) System.out.println("\nEntrez un nombre entre un 1 et 3\n");

                    System.out.println("1 : Attaque physique");
                    System.out.println("2 : Attaquer avec La Force");
                    System.out.println("3 : Attaquer avec votre arme");
                    System.out.print("Votre choix : ");

                    try {
                        setChoixAttaque(getEntreStd().nextInt());
                        checkNumber = true;
                    } catch (InputMismatchException e) {
                        System.out.println("\nEntrez un nombre entre un 1 et 3\n");
                        getEntreStd().next();
                        checkNumber = false;
                    }

                } while (getChoixAttaque() < 1 || getChoixAttaque() > 3);

                leJoueur.choixAttaque(getChoixAttaque(), getLeJoueur(), ennemie);

                getStat(ennemie);



                if (leJoueur.getHp() <= 0) setGameOver(true);

                usine.getListEnnemis().get(getChoixAttaque()).remove(ennemie);

                while (usine.getListEnnemis().isEmpty()) {
                    room.setLvl(room.getLvl() + 1);
                    room.creationSalle(usine);
                    room.setListEnnemis(usine.getListEnnemis());
                    System.out.println("Bienvenue dans la zone " + room.getLvl());
                }
            }




        }
    }

    public void getStat(Personnage perso) {

        Integer pvCheck = perso.getHp() > 0 ? perso.getHp() : 0;

        System.out.println("Voici les stats de " + perso.getClass().getName() + " :");
        System.out.println("\nLevel : " + perso.getLvl());
        System.out.println("PV : " + pvCheck);
        System.out.println("Défense : " + perso.getDef());
        System.out.println("Puissance : " + perso.getPower());
        System.out.println("La Force : " + perso.getForce());
        System.out.println("Intelligence : " + perso.getIntelligence());
        System.out.println("XP : " + perso.getXp() + "\n");
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

    public Integer getChoixEnnemi() {
        return choixEnnemi;
    }

    public Integer getChoixAttaque() {
        return choixAttaque;
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

    public void setChoixEnnemi(Integer choixEnnemi) {
        this.choixEnnemi = choixEnnemi;
    }

    public void setChoixAttaque(Integer choixAttaque) {
        this.choixAttaque = choixAttaque;
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
