public class Apple extends BasicProperties {


    static int score = 0;

    public Apple() {
        setEmoji("\uD83C\uDF4E");
    }

    public void addRandomApple(GameBoard screen, Apple apple) {
        int width = (int) (Math.random() * (screen.getScreenWidth() - 1));
        int height = (int) (Math.random() * (screen.getScreenHeight() - 1));
        String boarderOutline = "\uD83D\uDFE9";
        if (!screen.getObjectOnLocation(width, height).equals(boarderOutline))
            screen.setObjectOnLocation(apple, width, height);
        else addRandomApple(screen, apple);

    }

    public static boolean checkForApple(GameBoard screen) {
        String[][] array = screen.returnScreenArray();
        for (String[] strings : array) {
            for (String string : strings) {
                if (string.equals("\uD83C\uDF4E")) {
                    return true;
                }
            }
        }
        score++;
        return false;
    }

    public static int getScore() {
        return score;
    }

}