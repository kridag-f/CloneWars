/**
 * Created by Faouzi on 29/02/2016.
 */
public class Jedi extends Personnage {

    public Jedi(String name) {
        setHp(100);
        setDef(200);
        setPower(100);
        setXp(0);
        setForce(200);
        setIntelligence(200);
        setName(name);
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
        Integer pointDegat = (getForce()/10)*4;
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println(getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!");
    }


    @Override
    public void armedAttack(Personnage ennemy) {
        System.out.println("Jeune Jedi tu possèdes la Force !");
    }
}
