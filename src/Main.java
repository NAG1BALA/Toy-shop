package src;

import src.view.ConsoleUI;
import src.model.writer.FileHandler;

public class Main {
    public static void main(String[] args) {

        ConsoleUI test = new ConsoleUI();
        test.setWritable(new FileHandler());
        test.start();

    }
}
