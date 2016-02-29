/**
 * Created by Anthony on 29/02/2016.
 */
public class Personnage {

    private static Integer hp;
    private static Integer def;
    private static Integer power;
    private static Integer force;
    private static Integer intelligence;
    private static Integer lvl;
    private static Integer xp;
    private static Personnage instance = null;

    public Personnage() {
        setDef(null);
        setHp(null);
        setForce(null);
        setIntelligence(null);
        setLvl(1);
        setPower(null);
        setXp(null);
        setInstance(null);
    }

    public void lvlUp() {
        setLvl(getLvl() + 1);
    }

    // GETTERS
    public Integer getDef() {
        return def;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getForce() {
        return force;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getLvl() {
        return lvl;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getXp() {
        return xp;
    }

    public static Personnage getInstance() {
        if (instance == null) instance = new Personnage();
            return instance;
    }


    // SETTERS
    public void setDef(Integer def) {
        this.def = def;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }


    public static void setInstance(Personnage instance) {
        Personnage.instance = instance;
    }
}
