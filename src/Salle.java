import java.util.Vector;

/**
 * Created by Anthony on 29/02/2016.
 */
public class Salle {

    private Integer lvl;
    private Vector listEnnemis;

    public Salle(Integer lvl, Vector listEnnemis) {

        setLvl(lvl);
        setListEnnemis(listEnnemis);
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
