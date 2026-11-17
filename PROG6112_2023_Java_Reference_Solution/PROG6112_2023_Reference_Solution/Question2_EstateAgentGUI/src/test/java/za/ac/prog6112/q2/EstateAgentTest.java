package za.ac.prog6112.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstateAgentTest {
    private final EstateAgent agent = new EstateAgent();

    @Test
    void calculateCommissionCalculatedSuccessfully() {
        assertEquals(20_000.0, agent.CalculateCommission("500000", "4"), 0.001);
    }

    @Test
    void calculateCommissionCalculatedUnSuccessfully() {
        // A deliberately incorrect expected value demonstrates a calculation mismatch.
        double actual = agent.CalculateCommission("500000", "4");
        assertNotEquals(25_000.0, actual, 0.001);
    }

    @Test
    void validationRejectsInvalidPropertyPrice() {
        assertFalse(agent.ValidateData(new Data("Cape Town", "Joe Bloggs", "0", "2")));
        assertTrue(agent.ValidateData(new Data("Cape Town", "Joe Bloggs", "500000", "2")));
    }
}
