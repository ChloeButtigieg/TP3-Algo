import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Backpack backpack = new Backpack("src/main/resources/Backpacks/sac2.txt");
        Dynamic algo = new Dynamic(backpack);
        int maxProfit = algo.getMaxProfit();
        System.out.println("Max profit : " + maxProfit);
    }
}
