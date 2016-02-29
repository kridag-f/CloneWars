/**
 * Created by Faouzi on 29/02/2016.
 */
public class Jedi extends Personnage implements Attaque {

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
        ennemy.setHp(getPower() - ennemy.getDef());
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        ennemy.setHp((getForce()/10)*2);
    }


    @Override
    public void armedAttack(Personnage ennemy) {
        System.out.println("Désolé tu as la force tu peux pas utiliser cette technique !");
    }
}
