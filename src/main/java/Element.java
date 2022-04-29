public class Element {
    private final int weight;
    private final int value;

    public Element(final int weight, final int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" +
                weight +
                ", " + value +
                '}';
    }
}
