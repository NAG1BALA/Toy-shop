package src.view.commands;

import src.view.ConsoleUI;
public class ViewResult extends Command {
    public ViewResult(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать результат розыгрыша";
    }

    public void execute() {
        consoleUI.viewResultList();
    }
}
