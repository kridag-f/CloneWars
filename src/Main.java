public class Main {

    public static void main(String[] args) {

        Usine test = new Usine();

        Clone testClone;

        test.vagueEnnemi(6);
        System.out.println(test.getListEnnemis().get(0));
        System.out.println(test.getListEnnemis().get(1));
        testClone = (Clone) test.getListEnnemis().get(2);
        System.out.println(testClone.getLvl());
        System.out.println(testClone.getHp());
        System.out.println(testClone.getDef());
        System.out.println(testClone.getPower());
        System.out.println(testClone.getForce());
        System.out.println(testClone.getIntelligence());
        System.out.println(testClone.getXp());
    }
}
