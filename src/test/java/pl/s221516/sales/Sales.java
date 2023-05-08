package pl.s221516.sales;

import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;


    public void addToCart(String customerId, String productId) {
        Optional<Cart> customersCart = loadForCustomer(customerId);


        Optional<ProductDetails> product = getProdactDetail(productId);

        customersCart.add(product);

        cartStorage.save(customerId, customersCart);
    }

    private Optional<ProductDetails> getProductDetails(String productId) {
        return productDetailsProvider.loadForProduct(productId);
    }

    private Optional<Cart> loadForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }
}
