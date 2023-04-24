package pl.s221516.productcatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductCatalogController {

    private ProductCatalog productCatalog;

    ProductCatalogController(ProductCatalog catalog) {
        this.productCatalog = catalog;
    }

    @GetMapping("/api/products")
    List<Product> allProducts() {
        return productCatalog.allPublishedProducts();

    }
}
