import java.util.Random;
import java.util.Vector;

/**
 * Created by Faouzi on 29/02/2016.
 */
public class Usine {

    private Vector listEnnemis;
    private Integer numClone;
    private Integer numSoldat;
    private Integer numDroid;
    private Integer numZone;

    private static Usine instance = null;



    private Usine() {
        setListEnnemis(new Vector());
        setNumClone(2);
        setNumSoldat(1);
        setNumDroid(0);
    }

    public void vagueEnnemi(Integer numZone) {

        Integer i;

        setNumZone(numZone);

        Integer nbrCreerClone = getNumClone() + getNumZone();
        Integer nbrCreerSoldat = getNumSoldat() + getNumZone();
        Integer nbrCreerDroid = getNumDroid() + getNumZone();

        for (i = 0; i < (nbrCreerClone); i++) {
            getListEnnemis().add(lvlEnnemi(getNumZone(), new Clone()));
            setNumClone(nbrCreerClone);
        }

        for (i = 0; i < (nbrCreerSoldat); i++) {
            getListEnnemis().add(lvlEnnemi(getNumZone(), new Soldat()));
            setNumSoldat(nbrCreerSoldat);
        }

        for (i = 0; i < (nbrCreerDroid); i++) {
            getListEnnemis().add(lvlEnnemi(getNumZone(), new Droid()));
            setNumDroid(nbrCreerDroid);
        }
    }

    public Personnage lvlEnnemi(Integer numZone, Personnage perso){

        Random rLvl = new Random();
        Integer lvlRandom;

        lvlRandom = (numZone - 1) + rLvl.nextInt((numZone + 2) - (numZone - 1));
        perso.modifNiveau(lvlRandom);

        return perso;
    }

    public void experience(Personnage hero, Personnage ennemy) {
        hero.setXp(hero.getXp() + (50 * ennemy.getLvl()));
        if (hero.getXp() >= (hero.getLvl() * 112)) {
            hero.setXp(hero.getXp() - (hero.getLvl() * 112));
            hero.lvlUp();
        }
    }

    // GETTEURS
    public Vector getListEnnemis() {
        return listEnnemis;
    }

    public Integer getNumClone() {
        return numClone;
    }

    public Integer getNumDroid() {
        return numDroid;
    }

    public Integer getNumSoldat() {
        return numSoldat;
    }

    public Integer getNumZone() {
        return numZone;
    }

    public static Usine getInstance() {
        if (instance == null) instance = new Usine();
        else System.out.println("Vous avez déja créé une usine");
        return instance;
    }

    // SETTEURS
    public void setListEnnemis(Vector listEnnemis) {
        this.listEnnemis = listEnnemis;
    }

    public void setNumClone(Integer numClone) {
        this.numClone = numClone;
    }

    public void setNumDroid(Integer numDroid) {
        this.numDroid = numDroid;
    }

    public void setNumSoldat(Integer numSoldat) {
        this.numSoldat = numSoldat;
    }

    public void setNumZone(Integer numZone) {
        this.numZone = numZone;
    }
}

