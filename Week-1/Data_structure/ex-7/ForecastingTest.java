public class ForecastingTest {
    public static void main(String[] args) {
        double pv = 1000.0;     // Present Value: $1,000
        double rate = 0.05;     // Growth Rate: 5%
        int periods = 10;       // Periods: 10 years

        System.out.println("=== Financial Forecasting Test ===");
        System.out.println("Present Value: $" + pv);
        System.out.println("Growth Rate  : " + (rate * 100) + "%");
        System.out.println("Periods      : " + periods + " years\n");

        // 1. Recursive Forecasting
        long startRecursive = System.nanoTime();
        double fvRecursive = FinancialForecasting.calculateFutureValue(pv, rate, periods);
        long endRecursive = System.nanoTime();
        System.out.printf("Recursive Future Value: $%.2f (Time: %d ns)\n", fvRecursive, (endRecursive - startRecursive));

        // 2. Optimized Forecasting
        long startOptimized = System.nanoTime();
        double fvOptimized = FinancialForecasting.calculateFutureValueOptimized(pv, rate, periods);
        long endOptimized = System.nanoTime();
        System.out.printf("Optimized Future Value: $%.2f (Time: %d ns)\n", fvOptimized, (endOptimized - startOptimized));

        // 3. Testing stack limits to demonstrate recursion constraints
        int largePeriods = 20000;
        System.out.println("\n=== Testing with large periods (" + largePeriods + ") ===");
        
        try {
            System.out.println("Attempting recursive method with " + largePeriods + " periods...");
            FinancialForecasting.calculateFutureValue(pv, rate, largePeriods);
        } catch (StackOverflowError e) {
            System.out.println("Caught Expected Error: StackOverflowError due to deep call stack recursion!");
        }

        try {
            System.out.println("Attempting optimized iterative method with " + largePeriods + " periods...");
            double fvLargeOptimized = FinancialForecasting.calculateFutureValueOptimized(pv, rate, largePeriods);
            System.out.printf("Optimized Future Value (Large): $%.2f\n", fvLargeOptimized);
        } catch (Exception e) {
            System.out.println("Iterative method failed: " + e.getMessage());
        }
    }
}
