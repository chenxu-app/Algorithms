public class Item implements Comparable<Item> {
    private String name;
    private int weight;
    private float value;
    private float avgValue;

    public Item(String name, int weight, float value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.avgValue = value / weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(float avgValue) {
        this.avgValue = avgValue;
    }

    @Override
    public int compareTo(Item o) {
        return avgValue >= o.avgValue ? 1 : -1;
    }
}
