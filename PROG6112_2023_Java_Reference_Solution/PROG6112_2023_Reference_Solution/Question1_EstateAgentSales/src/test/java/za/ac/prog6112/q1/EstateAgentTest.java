package za.ac.prog6112.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstateAgentTest {
    private final EstateAgent agent = new EstateAgent();

    @Test
    void calculateTotalSalesReturnsTotalSales() {
        assertEquals(4_300_000.0, agent.EstateAgentSales(new double[]{800_000, 1_500_000, 2_000_000}), 0.001);
    }

    @Test
    void calculateTotalCommissionReturnsCommission() {
        assertEquals(86_000.0, agent.EstateAgentCommission(4_300_000.0), 0.001);
    }

    @Test
    void topAgentReturnsTopPosition() {
        assertEquals(0, agent.TopEstateAgent(new double[]{4_300_000, 3_500_000}));
    }
}
