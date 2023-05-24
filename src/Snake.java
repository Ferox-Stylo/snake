import java.util.Objects;

public class Snake extends BasicProperties {

    private boolean notQuit = true;

    private final String boarderOutline = "\uD83D\uDFE9";


    public Snake(GameBoard board) {
        setEmoji("\uD83D\uDC0D");
        setX((int) (Math.random() * (board.getScreenWidth() - 2)) + 1);
        setY((int) (Math.random() * (board.getScreenHeight() - 2)) + 1);
    }

    public void moveSnake(GameBoard board, Snake snake, String direction) {
        switch (direction) {
            case "a" -> {
                int newX = snake.getX() - 1;
                if (newX >= 0 && !Objects.equals(board.getObjectOnLocation(newX, snake.getY()), boarderOutline)) {
                    snake.setX(newX);
                    board.setObjectOnLocation(snake, snake.getX(), snake.getY());
                    board.ClearScreenLocation(snake.getX() + 1, snake.getY());
                } else {
                    GameOver.printScreen();
                }
            }
            case "d" -> {
                int newX = snake.getX() + 1;
                if (newX < board.getScreenWidth() && !Objects.equals(board.getObjectOnLocation(newX, snake.getY()), boarderOutline)) {
                    snake.setX(newX);
                    board.setObjectOnLocation(snake, snake.getX(), snake.getY());
                    board.ClearScreenLocation(snake.getX() - 1, snake.getY());
                } else {
                    GameOver.printScreen();
                }
            }
            case "w" -> {
                int newY = snake.getY() - 1;
                if (newY >= 0 && !Objects.equals(board.getObjectOnLocation(snake.getX(), newY), boarderOutline)) {
                    snake.setY(newY);
                    board.setObjectOnLocation(snake, snake.getX(), snake.getY());
                    board.ClearScreenLocation(snake.getX(), snake.getY() + 1);
                } else {
                    GameOver.printScreen();
                }
            }
            case "s" -> {
                int newY = snake.getY() + 1;
                if (newY < board.getScreenHeight() && !Objects.equals(board.getObjectOnLocation(snake.getX(), newY), boarderOutline)) {
                    snake.setY(newY);
                    board.setObjectOnLocation(snake, snake.getX(), snake.getY());
                    board.ClearScreenLocation(snake.getX(), snake.getY() - 1);
                } else {
                    GameOver.printScreen();
                }
            }
            case "stop" -> System.exit(0);
            default -> System.out.println("You can only enter w,a,s,d");
        }
    }
}
