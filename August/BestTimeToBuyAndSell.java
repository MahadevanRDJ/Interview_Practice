package August;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();
        int[] A = {7, 1, 5, 3, 6, 4};
        bestTimeToBuyAndSell.find(A);
        bestTimeToBuyAndSell.findUsingSlidingWindow(A);
    }

    private void find(int[] a) {
        int min = Integer.MAX_VALUE, tProfit = 0, finalProfit = 0;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(a[i], min);

            tProfit = a[i] - min;

            finalProfit = Math.max(finalProfit, tProfit);
        }

        System.out.println(finalProfit);
    }

    public void findUsingSlidingWindow(int[] prices) {
        int left = 0, right = 1, finalProfit = 0, tProfit = 0;

        while(right < prices.length) {

            if(prices[left] < prices[right]) {
                tProfit = prices[right] - prices[left];
                finalProfit = Math.max(tProfit, finalProfit);
            }

            else left = right;

            right++;
        }

        System.out.println(finalProfit);
    }


}
