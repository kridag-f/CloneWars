import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("   _____ _                   __          __            \n" +
                "  / ____| |                  \\ \\        / /            \n" +
                " | |    | | ___  _ __   ___   \\ \\  /\\  / /_ _ _ __ ___ \n" +
                " | |    | |/ _ \\| '_ \\ / _ \\   \\ \\/  \\/ / _` | '__/ __|\n" +
                " | |____| | (_) | | | |  __/    \\  /\\  / (_| | |  \\__ \\\n" +
                "  \\_____|_|\\___/|_| |_|\\___|     \\/  \\/ \\__,_|_|  |___/\n" +
                "                                                       \n" +
                "                                                       \n");

        Jeu game = new Jeu();
        game.start();

    }

}
