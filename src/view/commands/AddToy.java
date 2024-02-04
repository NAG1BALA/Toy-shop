package src.view.commands;

import src.view.ConsoleUI;

public class AddToy extends Command {
    public AddToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушку";
    }

    public void execute() {
        consoleUI.addToy();
    }
}