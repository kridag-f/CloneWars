/**
 * Created by Faouzi on 29/02/2016.
 */
public class Droid extends Personnage implements Attaque {

    public Droid() {
        setHp(50);
        setDef(100);
        setPower(25);
        setXp(0);
        setForce(0);
        setIntelligence(200);
        setName("Droid");
    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        ennemy.setHp(getPower() - ennemy.getDef());
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        System.out.println("Désolé tu n'as pas la force tu peux pas utiliser cette technique !");
    }

    @Override
    public void armedAttack(Personnage ennemy) {
        ennemy.setHp(getIntelligence() - ennemy.getDef());
    }
}
