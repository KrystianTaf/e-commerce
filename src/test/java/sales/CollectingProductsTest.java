package sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.s221516.sales.Sales;

import java.util.UUID;

public class CollectingProductsTest {

    @BeforeEach
    void setup() {
        cartStorage = new CartStorage();
        productDetailsProvider = new productDetailsProvider();

    }


    @Test
    void itAllowsToCollectProductsToCart() {
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customer = thereIsCustomer("Kuba");
    
        //Act
        sales.addToCart(customer, productId);
        
        
        //Assert
        assertThereIsNProductInCustomerCart(customer, 1);
    }

    private void assertThereIsNProductInCustomerCart(String customer, int i) {
        
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private Sales thereIsSalesModule() {
        return new Sales();
    }


}
