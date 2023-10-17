package co.com.bancolombia.usecase.crudproduct;

import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CrudProductUseCase {

    private ProductRepository productRepository;

    public void create (Product product){productRepository.create(product);}

    public Product read(String id){return  productRepository.read(id);}

    public Product update (String id, Product product)throws Exception{
        productRepository.update(id, product);
        return product;
    }

    public void delete (String id){productRepository.delete(id);}

    public List<Product>getAll(){return productRepository.getAll();}
}
