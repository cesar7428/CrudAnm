package co.com.bancolombia.jpa;

import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JPAProductImpl implements ProductRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public void create(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public Product read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public Product update(String id, Product product) throws Exception {
        Product productDc = jpaRepositoryAdapter.findById(id);

        if (productDc == null){
            throw new Exception("Product Not Found: " + id);
        }

        productDc.setNombre(product.getNombre());
        productDc.setGenero(product.getGenero());
        productDc.setEspecie(product.getEspecie());
        productDc.setHabitad(product.getHabitad());
        productDc.setNumPatas(product.getNumPatas());
        productDc.setDomestico(product.isDomestico());

        jpaRepositoryAdapter.save(productDc);
        return productDc;
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
