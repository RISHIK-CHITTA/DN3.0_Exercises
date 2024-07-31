public class FinancialForecasting {
    public static double calculateFutureValue(double initialAmount, double annualGrowthRate, int timePeriods) {
        if (timePeriods == 0) {
            return initialAmount;
        }
        return calculateFutureValue(initialAmount * (1 + annualGrowthRate), annualGrowthRate, timePeriods - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 1000.0;
        double annualGrowthRate = 0.05; // 5% growth rate
        int timePeriods = 10;
        double futureValue = calculateFutureValue(initialAmount, annualGrowthRate, timePeriods);
        System.out.println("Predicted Future Value: $" + futureValue);
    }
}
