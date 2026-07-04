public class FinancialForecasting {

    // Method to calculate future value using recursion
    // Formula: Future Value = Present Value * (1 + Growth Rate)^Periods
    // We'll compute it as:
    // f(pv, r, n) = f(pv * (1 + r), r, n - 1)
    // Base case: n == 0 => pv
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods <= 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 years

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Periods: " + periods);

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: $%.2f%n", periods, futureValue);

        System.out.println("\n--- Analysis ---");
        System.out.println("Time Complexity: O(N) where N is the number of periods, because the method calls itself N times.");
        System.out.println("Optimization: If multiple predictions are made for overlapping periods, we could use memoization to store already computed values for specific (periods) to avoid redundant calculations. Alternatively, an iterative approach or using the direct mathematical formula O(1) time complexity by Math.pow(1+r, n) can optimize it entirely, avoiding the recursion overhead completely.");
    }
}
