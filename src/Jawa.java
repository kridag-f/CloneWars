/**
 * Created by Anthony on 29/02/2016.
 */
public class Jawa extends Personnage {

    public Jawa(String name) {
        setHp(400);
        setDef(400);
        setPower(400);
        setForce(0);
        setXp(0);
        setIntelligence(400);
        setName(name);
    }

    public void physicalAttack(Personnage ennemy) {
        Integer pointDegat = getPower() - (ennemy.getDef() / 2);
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }
    
    public void forceAttack(Personnage ennemy) {
        System.out.println("Jeune Jawa tu ne possèdes pas la Force");
    }

    public void armedAttack(Personnage ennemy) {
        Integer pointDegat = getIntelligence() - (ennemy.getDef() / 2);
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }

}
