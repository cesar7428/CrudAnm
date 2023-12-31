package co.com.bancolombia.model.product.gateways;

import co.com.bancolombia.model.product.Product;

import java.util.List;

public interface ProductRepository {

    void create (Product product);

    Product read (String id);

    default Product update (String id, Product product)throws Exception{
        return product;
    }

    void delete (String id);

    List<Product>getAll();
}
