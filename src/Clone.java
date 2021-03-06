import java.util.Vector;

/**
 * Created by Faouzi on 29/02/2016.
 */
public class Clone extends Personnage {

    public Clone() {
        setHp(100);
        setDef(100);
        setPower(100);
        setXp(0);
        setForce(0);
        setIntelligence(100);
        setName("Clone");
        setMaxHp(getHp());
    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        Integer pointDegat = getPower() - (ennemy.getDef() / 2);
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println("C'est au tour du " + getName() + " d'attaquer");
        System.out.println(getName() + " a utilisé l'attaque physique !!");
        System.out.println("\n" + getName() + " a infligé : " + pointDegat + " dégats à " + ennemy.getName() + " !!");
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        System.out.println("Jeune Clone tu ne possèdes pas la Force");
    }

    @Override
    public void armedAttack(Personnage ennemy) {
        Integer pointDegat = getIntelligence() - (ennemy.getDef() / 2);
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println("C'est au tour du " + getName() + " d'attaquer");
        System.out.println(getName() + " a attaqué avec son arme !!");
        System.out.println("\n" + getName() + " a infligé : " + pointDegat + " dégats à " + ennemy.getName() + " !!");
    }
}
