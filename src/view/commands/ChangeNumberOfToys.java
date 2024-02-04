package src.view.commands;

import src.view.ConsoleUI;

public class ChangeNumberOfToys extends Command {
    public ChangeNumberOfToys(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить количество по ID";
    }

    public void execute() {
        consoleUI.changeNumberOfToys();
    }
}
