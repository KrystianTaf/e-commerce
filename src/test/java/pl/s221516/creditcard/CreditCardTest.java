package pl.s221516.creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itMyFirstTestRun() {
        boolean value = true;
        assertTrue(value);
    }

    @Test
    void my2ndTest() {
        boolean value = false;
    }

    @Test
    void testSchema() {
        //Arrange // Given // Input

        //Act // When // Action

        //Assert // Then // Expected // Output
    }

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert // Then

        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert // Then
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());
    }


    @Test
    void itCantAssignLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-5678");
        assertThrows(CreditBelowLimitException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));

        CreditCard card2 = new CreditCard("1234-5678");
        assertThrows(CreditBelowLimitException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        CreditCard card3 = new CreditCard("1234-5678");
        assertDoesNotThrow(() -> card3.assignCredit(BigDecimal.valueOf(100)));

        try {
            card1.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditBelowLimitException e) {
            assertTrue(true);
        }

    }

    @Test
    void itCantAssignLimitTwice() {
        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignCredit(BigDecimal.valueOf(1000));

    }

    @Test
    void itAllowsToWithdraw() {
        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignCredit(BigDecimal.valueOf(1000));

        card1.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card1.getBalance());
    }

}
