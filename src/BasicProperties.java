public class BasicProperties {

    private int x, y;
    private String emoji;


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    public void setX(int newLocation) {
        this.x = newLocation;
    }

    public void setY(int newLocation) {
        this.y = newLocation;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String newEmoji) {
        this.emoji = newEmoji;
    }
}