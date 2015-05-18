package sh.kinte.ConsoleMicroblog;

import sh.kinte.ConsoleMicroblog.Logic.Commander;

import java.util.Scanner;

/**
 * Created by kintesh on 16/05/15.
 */
public class App {

    public static void main(String[] args) {
        new App();
    }

    private Scanner scanner;
    private Commander commander;

    public App() {
        System.out.println("Welcome to Console Microblog!\n" +
                "=============================");

        scanner = new Scanner(System.in);
        commander = new Commander();

        while (true) {
            commander.runCommand(scanner.nextLine());
        }
    }
}
