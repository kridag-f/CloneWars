
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
    private String name;
    private Integer maxHp;

    public Personnage() {

        setHp(null);
        setDef(null);
        setForce(null);
        setIntelligence(null);
        setLvl(1);
        setPower(null);
        setXp(null);
        setName(null);
        setMaxHp(null);
    }

    public void lvlUp(Personnage hero, Boolean verifHero) {
        setHp((int) (getMaxHp() * 1.5));
        setMaxHp(getHp());
        setDef((int) (getDef() * 1.5));
        setForce((int) (getForce() * 1.5));
        setIntelligence((int) (getIntelligence() * 1.5));
        setLvl(getLvl() + 1);
        setPower((int) (getPower() * 1.5));
        if (verifHero) System.out.println("Votre " + hero.getClass().getName() + " est passé au niveau " + getLvl());
    }

    public void modifNiveau(Integer lvl, Personnage ennemy) {
        Integer i;

        for (i = 0; i < lvl; i++){
            lvlUp(ennemy, false);
        }
    }

    public void choixAttaque(Integer choix, Personnage perso, Personnage ennemy) {

        if (choix == 1) { perso.physicalAttack(ennemy); }
        else if (choix == 2) { perso.forceAttack(ennemy); }
        else if (choix == 3) { perso.armedAttack(ennemy); }
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

    public String getName() {
        return name;
    }

    public Integer getMaxHp() {
        return maxHp;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    // ABSTRACT METHODS

    public abstract void physicalAttack(Personnage ennemy);
    public abstract void forceAttack(Personnage ennemy);
    public abstract void armedAttack(Personnage ennemy);

}
