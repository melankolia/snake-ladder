public class Dice {
    Integer maxPoint;
    Integer minPoint = 1;

    Dice(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Integer shuffle() {

        /**
         * This is Formula For Calculate Min - Max Dice Point
         * */
        return (int) Math.floor(Math.random() * (maxPoint - minPoint + 1) + minPoint);
    }
}
