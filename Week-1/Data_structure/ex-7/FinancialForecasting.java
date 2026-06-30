public class FinancialForecasting {

    /**
     * Recursive method to calculate the future value of an investment.
     * Formula: FV = PV * (1 + r)^periods
     * Recursive Step: FV(periods) = FV(periods - 1) * (1 + growthRate)
     * Base Case: FV(0) = PV
     *
     * @param presentValue The initial/present value.
     * @param growthRate The growth rate per period (e.g., 0.05 for 5%).
     * @param periods The number of periods (e.g. years) to forecast.
     * @return The predicted future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods is 0, future value is the present value
        if (periods == 0) {
            return presentValue;
        }

        // Validation for negative periods
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative.");
        }

        // Recursive call
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    /**
     * Optimized iterative method to calculate the future value.
     * Prevents StackOverflowError and runs in O(1) auxiliary space.
     *
     * @param presentValue The initial/present value.
     * @param growthRate The growth rate per period.
     * @param periods The number of periods.
     * @return The predicted future value.
     */
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative.");
        }
        
        double futureValue = presentValue;
        double factor = 1 + growthRate;
        for (int i = 0; i < periods; i++) {
            futureValue *= factor;
        }
        return futureValue;
    }
}
