/**
 * Created by Anthony on 29/02/2016.
 */
public abstract class Personnage {

    private Integer hp;
    private Integer def;
    private Integer power;
    private Integer force;
    private Integer intelligence;
    private Integer lvl;
    private Integer xp;

    public Personnage() {

        setDef(null);
        setHp(null);
        setForce(null);
        setIntelligence(null);
        setLvl(1);
        setPower(null);
        setXp(null);
    }


    // ATTAQUE
    public abstract void physicalAttack(Personnage ennemy);
    public abstract void lvlUp();
    public abstract void forceAttack(Personnage ennemy);
    public abstract void armedAttack(Personnage ennemy);

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

}
