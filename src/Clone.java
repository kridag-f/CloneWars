import java.util.Vector;

/**
 * Created by Faouzi on 29/02/2016.
 */
public class Clone extends Personnage implements Attaque {

    public Clone() {
        setHp(100);
        setDef(100);
        setPower(100);
        setXp(0);
        setForce(0);
        setIntelligence(100);
        setName("Clone");
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
