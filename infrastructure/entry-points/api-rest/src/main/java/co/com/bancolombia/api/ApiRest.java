package co.com.bancolombia.api;
import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.usecase.crudproduct.CrudProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
  private final CrudProductUseCase crudProductUseCase;


    @GetMapping(path = "/product/{id}")
    public Product read (@PathVariable String id){return crudProductUseCase.read(id);}

    @PostMapping(path = "/product")
    public void create(@RequestBody Product product){crudProductUseCase.create(product);}

    @PutMapping(path = "/product/{id}")
    public void update(@PathVariable String id, @RequestBody Product product){
        try {
            crudProductUseCase.update(id, product);
        }catch (Exception g){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, g.getMessage());
        }
    }

    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable String id){crudProductUseCase.delete(id);}

    @GetMapping(path = "/product")
    public List<Product>getAll(){return crudProductUseCase.getAll();}

}
