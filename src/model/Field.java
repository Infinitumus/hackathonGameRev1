package model;

public class Field {
    private final int SIZE;
    private String[][] stateField;
    private final String DEFAULT_SYMBOL = "x";
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;

    public Field(int SIZE) {
        this.SIZE = SIZE;
        this.MIN_NUMBER = 0;
        this.MAX_NUMBER = getSIZE();
        stateField = new String[getSIZE()][getSIZE()];
        setStateField(DEFAULT_SYMBOL);
    }

    public int getSIZE() {
        return SIZE;
    }

    public String[][] getStateField() {
        return stateField;
    }

    public String getDEFAULT_SYMBOL() {
        return DEFAULT_SYMBOL;
    }

    public int getMIN_NUMBER() {
        return MIN_NUMBER;
    }

    public int getMAX_NUMBER() {
        return MAX_NUMBER;
    }

    public void setStateField(String symbol) {
        for (int i = 0; i < getSIZE(); i++) {
            for (int j = 0; j < getSIZE(); j++) {
                setCellField(i, j, symbol);
            }
        }
    }

    public void setCellField(int i, int j, String symbol) {
        if (checkCoord(i) && checkCoord(j)) {
            if (stateField[i][j] == DEFAULT_SYMBOL || stateField[i][j] == null) {
                this.stateField[i][j] = symbol;
            }else {
                System.out.println("Поле занято");
            }
        }
    }

    public String getCellState(int i, int j){
        if (checkCoord(i) && checkCoord(j)) {
            return stateField[i][j];
        }
        return null;
    }

    private boolean checkCoord(int coord) {
        if (coord >= getMIN_NUMBER() && coord < getMAX_NUMBER()) {
            return true;
        } else {
            System.out.println("Проверьте координаты");
            return false;
        }
    }
}
