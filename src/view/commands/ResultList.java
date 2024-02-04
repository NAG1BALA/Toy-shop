package src.view.commands;

import src.view.ConsoleUI;
public class ResultList extends Command {
    public ResultList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сформировать список розыгрыша";
    }

    public void execute() {
        consoleUI.resultList();
    }
}