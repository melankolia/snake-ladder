public class Player {
    String name;
    Integer position = 0;

    Player(String name) {
        this.name = name;
    }

    public void move(Integer number, Integer maxCell) {

        // Validate if Player move exceed the maxCell then it Doesn't Move at all
        if (position + number <= maxCell) position += number;
    }

    public void takeEffect(Integer number) {
        position = number;
    }

}
