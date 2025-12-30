package Arrays;

public class StockBuyAndSell {
    public int stockbuySell(int[] prices) {
        // Initialize the minimum price to a large number
        int minPrice = Integer.MAX_VALUE;

        // Initialize the maximum profit to 0
        int maxProfit = 0;

        // Traverse each price in the array
        for (int price : prices) {
            // If current price is less than minPrice, update minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Else calculate profit and update maxProfit if it's greater
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }

    public static void main(String[] args) {
        StockBuyAndSell obj = new StockBuyAndSell();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(obj.stockbuySell(prices));
    }

}
