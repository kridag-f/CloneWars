/**
 * Created by Anthony on 29/02/2016.
 */
public class ImperialAgent extends Personnage implements Attaque {

    public ImperialAgent() {
        setHp(350);
        setDef(100);
        setPower(100);
        setXp(0);
        setForce(0);
        setIntelligence(100);
    }

    public void physicalAttack(Personnage ennemy) {
        ennemy.setHp(getPower() - ennemy.getDef());
    }

    public void forceAttack(Personnage ennemy) {
        System.out.println("Désolé tu n'a pas de force tu peux pas utiliser cette technique !");
    }

    public void armedAttack(Personnage ennemy) {
        ennemy.setHp(getIntelligence() - ennemy.getDef());
    }
}
