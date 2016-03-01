/**
 * Created by Faouzi on 29/02/2016.
 */
public class Soldat extends Personnage {

    public Soldat() {
        setHp(100);
        setDef(150);
        setPower(125);
        setXp(0);
        setForce(0);
        setIntelligence(125);
        setName("Soldat");
    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        Integer pointDegat = getPower() - ennemy.getDef();
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        System.out.println("Jeune Soldat tu ne possèdes pas la Force");
    }

    @Override
    public void armedAttack(Personnage ennemy) {
        Integer pointDegat = getIntelligence() - ennemy.getDef();
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }
}
