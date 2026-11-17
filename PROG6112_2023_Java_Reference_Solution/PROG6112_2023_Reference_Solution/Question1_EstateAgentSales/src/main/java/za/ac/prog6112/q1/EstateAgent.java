package za.ac.prog6112.q1;

import java.util.Objects;

public class EstateAgent implements IEstateAgent {
    @Override
    public double EstateAgentSales(double[] propertySales) {
        Objects.requireNonNull(propertySales, "Property sales cannot be null");
        double total = 0;
        for (double sale : propertySales) total += sale;
        return total;
    }

    @Override
    public double EstateAgentCommission(double propertySales) {
        return propertySales * 0.02;
    }

    @Override
    public int TopEstateAgent(double[] totalSales) {
        Objects.requireNonNull(totalSales, "Total sales cannot be null");
        if (totalSales.length == 0) throw new IllegalArgumentException("At least one agent is required");
        int topIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) topIndex = i;
        }
        return topIndex;
    }
}
