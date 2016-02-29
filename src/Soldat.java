/**
 * Created by Faouzi on 29/02/2016.
 */
public class Soldat extends Usine implements Attaque {

    public Soldat() {
        super();
        Soldat();
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
