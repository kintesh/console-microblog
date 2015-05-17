package sh.kinte.ConsoleMicroblog;

import java.util.Scanner;

/**
 * Created by kintesh on 16/05/15.
 */
public class App {

    public static void main( String[] args ) {
        new App();
    }


    private Scanner scanner;
    private String input;

    public App() {
        System.out.println("Console Microblog");

        scanner = new Scanner(System.in);

//        while (true) {
//            input = scanner.next();
//
//            System.out.println(input);
//
//        }
    }

}
