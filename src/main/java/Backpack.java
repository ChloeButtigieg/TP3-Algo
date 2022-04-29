import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Backpack {
    private int maxWeight;
    private ArrayList<Element> elements = new ArrayList<>();

    public Backpack(final String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            this.maxWeight = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            while (line != null) {
                String[] elementData = line.split(" ");
                elements.add(new Element(Integer.parseInt(elementData[0]), Integer.parseInt(elementData[1])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public int getNbOfElement() {
        return elements.size();
    }

    public ArrayList<Element> getElements() {
        return this.elements;
    }

    public Element getElement(final int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        return "max weight : " + maxWeight +
                "\nelements : " + elements.toString();
    }
}

