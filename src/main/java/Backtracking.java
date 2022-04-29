import java.util.Comparator;

public class Backtracking {
    Backpack backpack;

    public Backtracking(final Backpack backpack) {
        this.backpack = backpack;
    }

    public int getMaxProfit(int maxProfit, int profit, int weight, int index) {
        if (index < backpack.getNbOfElement()) {
            if (weight + backpack.getElement(index).getWeight() <= backpack.getMaxWeight()) {
                maxProfit = getMaxProfit(maxProfit,profit+backpack.getElement(index).getValue(), weight + backpack.getElement(index).getWeight(), index+1);
            }
            if (profit + nextProfit(index+1, backpack.getNbOfElement()) >= maxProfit) {
                maxProfit = getMaxProfit(maxProfit, profit, weight, index+1);
            }
        }
        return Math.max(maxProfit, profit);
    }

    public void sortElementsByRatio() {
        class ratioComparator implements Comparator<Element> {

            @Override
            public int compare(Element o1, Element o2) {
                return Double.compare((o1.getValue() / (double) o1.getWeight()), (o2.getValue() / (double) o2.getWeight()));
            }
        }
        backpack.getElements().sort(new ratioComparator());
    }

    public int nextProfit(final int start, final int end) {
        int nextProfit = 0;
        for (int index = start; index < end; index++) {
            nextProfit = nextProfit + backpack.getElement(index).getValue();
        }
        return nextProfit;
    }
}
