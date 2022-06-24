package view;

import model.Field;

public class View {
    private Field field;

    public View(Field field) {
        this.field = field;
        System.out.println("Hello! This is a new game");
        System.out.println("-------------------------");
    }

    public void showField() {
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (j != 0) {
                    System.out.print("|");
                }
                System.out.printf(" %s ", field.getCellState(i, j));
            }
            if (i != field.getSIZE() - 1) {
                System.out.println("\n-----------");
            }
        }
        System.out.println();
    }


}
