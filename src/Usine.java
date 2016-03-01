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

    private static Usine instance = null;



    private Usine() {
        setListEnnemis(new Vector());
        setNumClone(2);
        setNumSoldat(1);
        setNumDroid(0);
    }

    public void vagueEnnemi(Integer numZone) {

        Integer i;

        for (i = 0; i < (getNumClone() + numZone); i++) {
            getListEnnemis().add(lvlEnnemi(numZone, new Clone()));
        }

        for (i = 0; i < (getNumSoldat() + numZone); i++) {
            getListEnnemis().add(lvlEnnemi(numZone, new Soldat()));
        }

        for (i = 0; i < (getNumDroid() + numZone); i++) {
            getListEnnemis().add(lvlEnnemi(numZone, new Droid()));
        }
    }

    public Personnage lvlEnnemi(Integer numZone, Personnage perso){

        Random rLvl = new Random();
        Integer lvlRandom;

        lvlRandom = (numZone - 1) + rLvl.nextInt((numZone + 2) - (numZone - 1));
        perso.modifNiveau(lvlRandom);

        return perso;
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

}

