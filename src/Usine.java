/**
 * Created by Faouzi on 29/02/2016.
 */
public class Usine extends Personnage {

    private Integer zone;

    public Usine() {

    }
    public Usine(Integer zone) {

        setZone(zone);
    }

    public void Clone() {
        setHp(100);
        setDef(100);
        setPower(100);
        setXp(0);
        setForce(0);
        setIntelligence(100);
        setName("Clone");
    }

    public void Soldat() {
        setHp(100);
        setDef(150);
        setPower(125);
        setXp(0);
        setForce(0);
        setIntelligence(125);
        setName("Soldat");
    }

    public void Droid() {
        setHp(50);
        setDef(100);
        setPower(25);
        setXp(0);
        setForce(0);
        setIntelligence(200);
        setName("Droid");
    }

    public void creationEnnemi(Personnage ennemy) {

    }

    // GETTERS
    public Integer getZone() {
        return zone;
    }

    // SETTERS
    public void setZone(Integer zone) {
        this.zone = zone;
    }
}
