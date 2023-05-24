import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int SCREEN_WIDTH = 20;
        final int SCREEN_HEIGHT = 10;


        GameBoard board = new GameBoard(SCREEN_WIDTH, SCREEN_HEIGHT);
        board.InitScreen();

        Snake snake = new Snake(board);
        board.setObjectOnLocation(snake, snake.getX(), snake.getY());


        Apple apple = new Apple();
        apple.addRandomApple(board, apple);

        while(true) {
            board.PrintScreen();
            snake.moveSnake(board, snake, new Scanner(System.in).nextLine().toLowerCase());

            if (!Apple.checkForApple(board)) {
                apple.addRandomApple(board, apple);
            }
        }
    }

}
