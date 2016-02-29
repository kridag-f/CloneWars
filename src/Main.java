public class Main {

    public static void main(String[] args) {
        Jedi test = new Jedi();

        test.lvlUp();

        Sith test2 = new Sith();

        Integer i = test2.setHp((int) (test2.getHp() * 1.5));
        System.out.print(i);

    }
}
