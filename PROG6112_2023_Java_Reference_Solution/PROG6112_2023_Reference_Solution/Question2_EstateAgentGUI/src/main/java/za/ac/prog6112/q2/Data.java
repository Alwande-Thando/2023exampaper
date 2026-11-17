package za.ac.prog6112.q2;

/** Data entered by the user for an estate-agent commission report. */
public class Data {
    private final String location;
    private final String agentName;
    private final String propertyPrice;
    private final String agentCommission;

    public Data(String location, String agentName, String propertyPrice, String agentCommission) {
        this.location = location;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.agentCommission = agentCommission;
    }
    public String getLocation() { return location; }
    public String getAgentName() { return agentName; }
    public String getPropertyPrice() { return propertyPrice; }
    public String getAgentCommission() { return agentCommission; }
}
