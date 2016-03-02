import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Faouzi on 29/02/2016.
 */
public class Usine {

    private Hashtable<Integer, Vector> listEnnemis;
    private Integer numClone;
    private Integer numSoldat;
    private Integer numDroid;
    private Integer numZone;
    private static Usine instance = null;

    private Usine() {
        setListEnnemis(new Hashtable<Integer, Vector>());
        setNumClone(2);
        setNumSoldat(1);
        setNumDroid(0);
    }

    public Personnage unEnnemi(Integer choixEnnemi) { return (Personnage) getListEnnemis().get(choixEnnemi).firstElement(); }

    public void vagueEnnemi(Integer numZone) {

        Integer i;
        Vector chqEnnemi = new Vector();

        setNumZone(numZone);

        Integer nbrCreerClone = getNumClone() + getNumZone();
        Integer nbrCreerSoldat = getNumSoldat() + getNumZone();
        Integer nbrCreerDroid = getNumDroid() + getNumZone();

        for (i = 0; i < (nbrCreerClone); i++) { chqEnnemi.add(lvlEnnemi(getNumZone(), new Clone())); }
        getListEnnemis().put(1, chqEnnemi);
        chqEnnemi = new Vector();
        setNumClone(nbrCreerClone);

        for (i = 0; i < (nbrCreerSoldat); i++) { chqEnnemi.add(lvlEnnemi(getNumZone(), new Soldat())); }
        getListEnnemis().put(2, chqEnnemi);
        chqEnnemi = new Vector();
        setNumSoldat(nbrCreerSoldat);

        for (i = 0; i < (nbrCreerDroid); i++) { chqEnnemi.add(lvlEnnemi(getNumZone(), new Droid())); }
        getListEnnemis().put(3, chqEnnemi);
        setNumDroid(nbrCreerDroid);
        System.out.println(chqEnnemi);

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
    public Hashtable<Integer, Vector> getListEnnemis() {
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
    public void setListEnnemis(Hashtable listEnnemis) {
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

