import java.util.ArrayList;
import java.util.Arrays;

public class Dynamic {
    private Integer[][] profitTable;
    private final Backpack backpack;

    public Dynamic(final Backpack backpack) {
        this.backpack = backpack;
        this.profitTable = new Integer[this.backpack.getNbOfElement()+1][this.backpack.getMaxWeight()+1];
        computeProfitTable();
    }

    public void computeProfitTable() {
        int nbOfElement = this.backpack.getNbOfElement();
        int maxWeight = this.backpack.getMaxWeight();

        for (int index = 0; index <= nbOfElement; index++) {
            profitTable[index][0] = 0;
        }
        for (int weight = 0; weight <= maxWeight; weight++) {
            profitTable[0][weight] = 0;
        }

        for (int index = 1; index <= nbOfElement; index++) {
            for (int weight = 1; weight <= maxWeight; weight++) {
                Element element  = this.backpack.getElement(index-1);
                if (element.getWeight() > weight) {
                    profitTable[index][weight] = profitTable[index-1][weight];
                } else {
                    int maxProfit = Math.max(profitTable[index-1][weight],
                            profitTable[index-1][weight-element.getWeight()] + element.getValue());
                    profitTable[index][weight] = maxProfit;
                }
            }
        }
    }

    public int getMaxProfit() {
        return profitTable[this.backpack.getNbOfElement()][this.backpack.getMaxWeight()];
    }

    public ArrayList<Element> getBestLoad() {
        final ArrayList<Element> load = new ArrayList<>();
        int sum = 0;
        int weight = this.backpack.getMaxWeight();
        for (int index = this.backpack.getNbOfElement(); index > 0; index--) {
            if (profitTable[index][weight] > profitTable[index-1][weight]) {
                sum = sum + backpack.getElement(index-1).getValue();
                load.add(backpack.getElement(index-1));
                weight = weight - backpack.getElement(index-1).getWeight();
            }
        }
        return load;
    }
}
