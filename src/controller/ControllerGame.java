package controller;

import model.Field;
import model.Player;

import java.util.Scanner;

public class ControllerGame {

    Scanner scanner = new Scanner(System.in);
    private Field field;
    private Player player1;
    private Player player2;

    public ControllerGame(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int inputCoord(String coord) {
        System.out.printf("Введите координату %s:   ", coord);
        return scanner.nextInt();
    }

    //Установка фигуры игрока на поле, если не удалось, то !!!!
    public void movePlayer(int x, int y, Player player) {
        field.setCellField(x, y, player.getFIGURE());
    }

    public String currentMove() {
        String[][] temp = field.getStateField();
        int lenTemp = temp.length;
        int count = 0;
        for (int i = 0; i < lenTemp; i++) {
            for (int j = 0; j < lenTemp; j++) {
                if (temp[i][j] != field.getDEFAULT_SYMBOL()) {
                    count++;
                }
            }
        }
        if (count == field.getSIZE() * field.getSIZE()) {
            return null;
        }
        if (count % 2 == 0) {
            return player2.getFIGURE();
        } else return player1.getFIGURE();
    }

    public boolean endGame() {
        if (currentMove() != null) {
            return false;
        }
        return true;
    }

    //проверка по горизонтали
    private boolean checkHorizontal(Player player) {
        int count;

        for (int i = 0; i < field.getSIZE(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if (field.getCellState(i, j) == player.getFIGURE()) {
                    count++;
                }
                if (count == field.getSIZE()) {
                    return true;
                }
            }
        }
        return false;
    }

    //проверка по вертикали
    private boolean checkVertical(Player player) {
        int count;
        for (int j = 0; j < field.getSIZE(); j++) {
            count = 0;
            for (int i = 0; i < field.getSIZE(); i++) {
                if (field.getCellState(j, i) == player.getFIGURE()) {
                    count++;
                }
                if (count == field.getSIZE()) {
                    return true;
                }
            }
        }
        return false;
    }

    //проверка по диагонали1
    private boolean checkDiagonal1(Player player) {
        int count = 0;
        for (int i = 0; i < field.getSIZE(); i++) {
            if (field.getCellState(i, i) == player.getFIGURE()) {
                count++;
            }
        }
        if (count == field.getSIZE()) {
            return true;
        }
        return false;
    }

    //проверка по диагонали2
    private boolean checkDiagonal2(Player player) {
        int count = 0;
        for (int i = field.getSIZE() - 1; i >= 0; i--) {
            if (field.getCellState(i, field.getSIZE() - 1 - i) == player.getFIGURE()) {
                count++;
            }
        }
        if (count == field.getSIZE()) {
            return true;
        }
        return false;
    }

    public boolean getWinnerPlayer(Player player) {
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal1(player)
                || checkDiagonal2(player);
    }

    public String getWinnerName() {
        if (getWinnerPlayer(player1)) {
            return player1.getNAME();
        } else if (getWinnerPlayer(player2)) {
            return player2.getNAME();
        }
        return "Ничья";
    }

}
