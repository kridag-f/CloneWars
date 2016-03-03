import jdk.internal.cmm.SystemResourcePressureImpl;

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
    private Integer recommencer;
    private Salle room;
    private Usine usine;
    private Integer choixEnnemyAttaquer;
    private Boolean checkNumber;

    public Jeu() {

        setEntreStd(new Scanner(System.in));
        setGameOver(false);
        setNomJoueur(null);
        setChoixEnnemi(0);
        setChoixAttaque(0);
        setRecommencer(0);
        setChoixJoueur(null);
        setTabChoixClasse(new Hashtable<Integer, Personnage>());
        setLeJoueur(null);
        setRecommencer(null);
        setRoom(null);
        setUsine(null);
        setChoixEnnemyAttaquer(null);
        setCheckNumber(false);
    }

    public void start() {

        initJeu();

        while (!getGameOver()) {

            persoChoixEnnemie();
            Personnage ennemie = usine.unEnnemi(getChoixEnnemi());
            Boolean ennemiExist = ennemie != null ? true : false;

            if (ennemiExist) {
                getStat(ennemie);

                while (ennemie.getHp() > 0) {

                    persoChoixAttaque(ennemie);
                    leJoueur.choixAttaque(getChoixAttaque(), getLeJoueur(), ennemie);

                    if (ennemie.getHp() > 0) {
                        Random rAttaque = new Random();
                        Integer attaqueRandom;

                        attaqueRandom = 1 + rAttaque.nextInt(3);
                        ennemie.choixAttaque(attaqueRandom, ennemie, getLeJoueur());
                    }

                    if (leJoueur.getHp() <= 0) {
                        persoGameOver(ennemie);
                    }
                }
                usine.destructionEnnemie(getLeJoueur(), ennemie, getChoixEnnemi());
            }
            persoChangeSalle();
        }
    }

    public void initJeu() {

        menuStart();
        tabChoix();
        setLeJoueur((Personnage) getTabChoixClasse().get(getChoixJoueur()));
        setRoom(new Salle());

        Usine factory = null;
        setUsine(factory.getInstance());

        room.creationSalle(usine);
        getStat(getLeJoueur());

        System.out.println("Le jeu peut commencer '" + getNomJoueur() + "' ! \n");
    }

    public void persoChoixEnnemie() {
        do {
            if (checkNumber) System.out.println("\nEntrez un nombre entre un 1 et 4\n");
            System.out.println("1 : Attaquer Clone");
            System.out.println("2 : Attaquer Soldat");
            System.out.println("3 : Attaquer Droid");
            System.out.println("4 : Fuir");
            System.out.print("Votre choix : ");
            try {
                choixEnnemyAttaquer = getEntreStd().nextInt();
                setChoixEnnemi(choixEnnemyAttaquer);
                checkNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("\nVous devez entrer un nombre entre un 1 et 4\n");
                getEntreStd().next();
                checkNumber = false;
            }
            if (getChoixEnnemi() == 4) quitter();

        } while (getChoixEnnemi() < 1 || getChoixEnnemi() > 3);
    }

    public void persoChoixAttaque(Personnage ennemie) {
        checkNumber = false;
        do {
            if (checkNumber) System.out.println("Entrez un nombre entre un 1 et 5\n");

            System.out.println("\n1 : Attaque physique");
            System.out.println("2 : Attaquer avec La Force");
            System.out.println("3 : Attaquer avec votre arme");
            System.out.println("4 : Pour voir les stats de votre " + leJoueur.getClass().getName());
            System.out.println("5 : Pour voir les stats du " + ennemie.getName());
            System.out.print("Votre choix : ");

            try {
                setChoixAttaque(getEntreStd().nextInt());
                checkNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous devez entrer un nombre entre un 1 et 5\n");
                getEntreStd().next();
                checkNumber = false;
            }
            if (getChoixAttaque() == 4) getStat(leJoueur);
            else if (getChoixAttaque() == 5) getStat(ennemie);

        } while (getChoixAttaque() < 1 || getChoixAttaque() > 3);
    }

    public void persoGameOver(Personnage ennemie) {
        System.out.println("\nVotre " + leJoueur.getClass().getName() + " est mort !!!\n");
        System.out.println("GAME OVER\n");
        checkNumber = false;

        do {
            if (checkNumber) System.out.println("Entrez 0 ou 1 !!\n");

            System.out.println("Tapez 0 pour quittez");
            System.out.println("Tapez 1 pour recommencer");
            System.out.print("Votre choix : ");

            try {
                setRecommencer(getEntreStd().nextInt());
                System.out.println("");
                checkNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous devez entrer 0 ou 1 !!\n");
                getEntreStd().next();
                checkNumber = false;
            }
            if (getChoixAttaque() == 4) getStat(leJoueur);
            else if (getChoixAttaque() == 5) getStat(ennemie);

        } while (getRecommencer() < 0 || getRecommencer() > 1);

        if (getRecommencer() == 1) {
            setEntreStd(new Scanner(System.in));
            setGameOver(false);
            setNomJoueur(null);
            setChoixEnnemi(0);
            setChoixAttaque(0);
            setRecommencer(0);
            setChoixJoueur(null);
            setTabChoixClasse(new Hashtable<Integer, Personnage>());
            setLeJoueur(null);
            usine = null;
            room = null;
            start();
        } else {
            setGameOver(true);
            System.exit(0);
        }
    }

    public void persoChangeSalle() {
        if (usine.getListEnnemis().get(1).isEmpty() && usine.getListEnnemis().get(2).isEmpty() && usine.getListEnnemis().get(3).isEmpty()) {
            room.setLvl(room.getLvl() + 1);
            room.creationSalle(usine);
            room.setListEnnemis(usine.getListEnnemis());
            System.out.println("Bienvenue dans la zone " + room.getLvl());
        }
    }

    public void quitter() {
        System.out.println("\nVous avez fui le combat !");
        System.exit(0);
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

    public void menuStart() {

        System.out.print("Donnez un nom à votre personnage : ");
        setNomJoueur(getEntreStd().nextLine());

        Boolean checkNumber = false;

        do {
            if (checkNumber) System.out.println("\nEntrez un nombre entre un 1 et 6");

            System.out.println("\nTapez 1 pour un Jedi");
            System.out.println("Tapez 2 pour un Sith");
            System.out.println("Tapez 3 pour un BountyHunters");
            System.out.println("Tapez 4 pour un ImperialAgent");
            System.out.println("Tapez 5 pour un Mercenary");
            System.out.println("Tapez 6 pour un Jawa");
            System.out.print("Votre choix : ");

            try {
                Integer choixFin = getEntreStd().nextInt();
                setChoixJoueur(choixFin);
                checkNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("\nVous devez entrer un nombre entre un 1 et 6");
                setChoixJoueur(0);
                getEntreStd().next();
                checkNumber = false;
            }
        } while (getChoixJoueur() < 1 || getChoixJoueur() > 6);
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

    public Integer getRecommencer() {
        return recommencer;
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

    public Boolean getCheckNumber() {
        return checkNumber;
    }

    public Integer getChoixEnnemyAttaquer() {
        return choixEnnemyAttaquer;
    }

    public Salle getRoom() {
        return room;
    }

    public Usine getUsine() {
        return usine;
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

    public void setRecommencer(Integer recommencer) {
        this.recommencer = recommencer;
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

    public void setCheckNumber(Boolean checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setChoixEnnemyAttaquer(Integer choixEnnemyAttaquer) {
        this.choixEnnemyAttaquer = choixEnnemyAttaquer;
    }

    public void setRoom(Salle room) {
        this.room = room;
    }

    public void setUsine(Usine usine) {
        this.usine = usine;
    }
}
