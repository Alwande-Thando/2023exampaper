package za.ac.prog6112.q1;

public class EstateAgentSalesApp {
    public static void main(String[] args) {
        String[] agents = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"January", "February", "March"};
        double[][] sales = {
            {800000, 1500000, 2000000},
            {700000, 1200000, 1600000}
        };

        EstateAgent calculator = new EstateAgent();
        double[] totals = new double[agents.length];

        System.out.println("ESTATE AGENT SALES REPORT");
        System.out.printf("%-15s %15s %15s %15s %18s %18s%n",
                "Agent", months[0], months[1], months[2], "Total sales", "2% commission");
        for (int row = 0; row < agents.length; row++) {
            totals[row] = calculator.EstateAgentSales(sales[row]);
            double commission = calculator.EstateAgentCommission(totals[row]);
            System.out.printf("%-15s R%14,.2f R%14,.2f R%14,.2f R%17,.2f R%17,.2f%n",
                    agents[row], sales[row][0], sales[row][1], sales[row][2], totals[row], commission);
        }
        int top = calculator.TopEstateAgent(totals);
        System.out.println("Top-selling estate agent: " + agents[top]);
    }
}
