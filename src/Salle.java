import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Anthony on 29/02/2016.
 */
public class Salle {

    private Integer lvl;
    private Hashtable listEnnemis;

    public Salle() {

        setLvl(1);
        setListEnnemis(null);
    }

    public void creationSalle(Usine usine) {
        System.out.println("Une salle a été créée !");
        usine.vagueEnnemi(getLvl());
        setListEnnemis(usine.getListEnnemis());
        System.out.println("Bienvenue dans la zone " + getLvl());
        System.out.println(usine.getNumClone() + " Clone, " + usine.getNumSoldat() + " Soldat et " + usine.getNumDroid() + " Droid sont présent dans cette zone\n");
    }


    // GETTERS
    public Integer getLvl() {
        return lvl;
    }

    public Hashtable getListEnnemis() {
        return listEnnemis;
    }

    // SETTERS
    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public void setListEnnemis(Hashtable listEnnemis) {
        this.listEnnemis = listEnnemis;
    }
}
