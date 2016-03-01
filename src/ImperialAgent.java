/**
 * Created by Anthony on 29/02/2016.
 */
public class ImperialAgent extends Personnage {

    public ImperialAgent(String name) {
        setHp(350);
        setDef(100);
        setPower(100);
        setXp(0);
        setForce(0);
        setIntelligence(100);
        setName(name);
    }

    public void physicalAttack(Personnage ennemy) {
        Integer pointDegat = getPower() - ennemy.getDef();
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }

    public void forceAttack(Personnage ennemy) {
        System.out.println("Jeune ImperialAgent tu ne possèdes pas la Force");
    }

    public void armedAttack(Personnage ennemy) {
        Integer pointDegat = getIntelligence() - ennemy.getDef();
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }
}
