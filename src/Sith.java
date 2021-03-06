/**
 * Created by Faouzi on 29/02/2016.
 */
public class Sith extends Personnage {

    public Sith(String name) {
        setHp(100);
        setDef(100);
        setPower(200);
        setForce(200);
        setXp(0);
        setIntelligence(200);
        setName(name);
        setMaxHp(getHp());

    }

    @Override
    public void physicalAttack(Personnage ennemy) {
        Integer pointDegat = getPower() - (ennemy.getDef() / 4);
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println("\n" + getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!\n");
    }

    @Override
    public void forceAttack(Personnage ennemy) {
        Integer pointDegat = (getForce()/10)*4;
        if (pointDegat < 0) pointDegat = 0;
        ennemy.setHp(ennemy.getHp() - pointDegat);
        System.out.println("\n" + getName() + " a infligé : " + pointDegat + " dégats au " + ennemy.getName() + " !!\n");
    }

    @Override
    public void armedAttack(Personnage ennemy) {
        System.out.println("\nJeune Sith tu possèdes la Force !\n");
    }
}
