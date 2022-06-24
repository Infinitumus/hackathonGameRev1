import controller.ControllerGame;
import model.Field;
import model.Player;
import view.View;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(3);
        Player player1 = new Player("Max", "0");
        Player player2 = new Player("Lev", "1");
        ControllerGame controller = new ControllerGame(field, player1, player2);
        View view = new View(field);
        view.showField();

        int x, y;
        x = controller.inputCoord("x");
        y = controller.inputCoord("y");
        controller.movePlayer(x, y, player1);
        view.showField();
    }
}
