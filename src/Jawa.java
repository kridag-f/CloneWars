/**
 * Created by Anthony on 29/02/2016.
 */
public class Jawa extends Personnage implements Attaque {

    public Jawa() {
        setHp(400);
        setDef(400);
        setPower(400);
        setForce(0);
        setXp(0);
        setIntelligence(400);
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
