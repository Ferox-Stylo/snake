public class GameBoard {

    private final int width;
    private final int height;
    private final String[][] screenMatrix;

    private final String boarderOutline = "\uD83D\uDFE9";

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.screenMatrix = new String[this.height][this.width];
    }

    public void InitScreen() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.screenMatrix[i][j] = "⬜";
            }
        }
        int y = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < this.height; j++) {
                System.out.println(j);
                System.out.println(y);
                this.screenMatrix[j][y] = boarderOutline;
            }
            y = this.width - 1;
        }
        int x = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < this.width; j++) {
                this.screenMatrix[x][j] = boarderOutline;
            }
            x = this.height - 1;
        }
    }

    public void PrintScreen() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.screenMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.print(boarderOutline + "\uD83C\uDD68\uD83C\uDD5E\uD83C\uDD64\uD83C\uDD61 \uD83C\uDD62\uD83C\uDD52\uD83C\uDD5E\uD83C\uDD61\uD83C\uDD54  " + Apple.getScore());
        if (Apple.getScore() < 10)
            System.out.print(" ");
        System.out.println("                       "+ boarderOutline);
        for (int j = 0; j < 20; j++) {
            System.out.print(boarderOutline);
        }
        System.out.println();
    }

    public void ClearScreenLocation(int x, int y) {
        this.screenMatrix[y][x] = "⬜";
    }

    public int getScreenWidth() {
        return this.width;
    }

    public int getScreenHeight() {
        return this.height;
    }

    public String getObjectOnLocation(int x, int y) {
        return this.screenMatrix[y][x];
    }

    public void setObjectOnLocation(BasicProperties object, int x, int y) {
        this.screenMatrix[y][x] = object.getEmoji();
    }
    public String[][] returnScreenArray(){
        return this.screenMatrix;
    }
}