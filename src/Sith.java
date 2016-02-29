/**
 * Created by Faouzi on 29/02/2016.
 */
public class Sith extends Personnage implements Attaque {

    public Sith() {
        setHp(100);
        setDef(100);
        setPower(200);
        setForce(200);
        setIntelligence(200);
    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        ennemy.setHp(getPower() - ennemy.getDef());
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        ennemy.setHp((getForce()/10)*2);
    }


    @Override
    public void armedAttack(Personnage ennemy) {
        ennemy.setHp(getIntelligence() - ennemy.getDef());
    }
}
