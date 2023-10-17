package co.com.bancolombia.model.product;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

    private String id;
    private String nombre;
    private String genero;
    private String especie;
    private String habitad;
    private int numPatas;
    private boolean domestico;
}
