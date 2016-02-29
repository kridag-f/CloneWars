/**
 * Created by Faouzi on 29/02/2016.
 */
public class Jedi extends Personnage implements Attaque {

    public Jedi() {
        if (getInstance() == null) {
            setHp(100);
            setDef(200);
            setPower(100);
            setXp(0);
            setForce(200);
            setIntelligence(200);
            setInstance(new Jedi());
        } else {
            setInstance(null);
            System.exit(0);
        }

    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        ennemy.setHp(getPower() - ennemy.getDef());
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        ennemy.setHp((getForce()/10)*2);
    }


    public void creationPerso() {
        System.out.println("Tu as créé un JEDI");

    }

    @Override
    public void armedAttack(Personnage ennemy) {
        System.out.println("Désolé tu as la force tu peux pas utiliser cette technique !");
    }
}
