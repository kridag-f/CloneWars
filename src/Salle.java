import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Vector;

/**
 * Created by Anthony on 29/02/2016.
 */
public class Salle {

    private Integer lvl;
    private Vector listEnnemis;
    private Usine factory;

    public Salle() {

        setLvl(1);
        setListEnnemis(new Vector());
    }

    public void creationSalle(Usine usine) {
        System.out.println("Une salle a été créée !");
        usine.vagueEnnemi(getLvl());
        setListEnnemis(usine.getListEnnemis());
        System.out.println("Bienvenue dans la zone " + getLvl());
        System.out.println(usine.getNumClone() + " Clone, " + usine.getNumSoldat() + " Soldat et " + usine.getNumDroid() + " Droid sont présent dans cette zone");
    }


    // GETTERS
    public Integer getLvl() {
        return lvl;
    }

    public Vector getListEnnemis() {
        return listEnnemis;
    }

    // SETTERS
    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public void setListEnnemis(Vector listEnnemis) {
        this.listEnnemis = listEnnemis;
    }
}
