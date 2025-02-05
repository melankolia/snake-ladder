public class Dice {
    Double maxPoint;

    Dice(Integer maxPoint) {
        this.maxPoint = Double.valueOf(maxPoint);
    }

    public Integer shuffle() {
        return (int) (Math.random() * maxPoint);
    }
}
