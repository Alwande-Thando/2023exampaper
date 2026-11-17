package za.ac.prog6112.q2;

public class EstateAgent implements IEstateAgent {
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double percentage = Double.parseDouble(agentCommission);
        if (price <= 0 || percentage <= 0)
            throw new IllegalArgumentException("Property price and commission percentage must be greater than zero.");
        return price * (percentage / 100.0);
    }

    @Override
    public boolean ValidateData(Data data) {
        if (data == null || data.getLocation() == null || data.getLocation().trim().isEmpty()
                || data.getAgentName() == null || data.getAgentName().trim().isEmpty()) return false;
        try {
            double price = Double.parseDouble(data.getPropertyPrice());
            double commission = Double.parseDouble(data.getAgentCommission());
            return Double.isFinite(price) && Double.isFinite(commission) && price > 0 && commission > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
