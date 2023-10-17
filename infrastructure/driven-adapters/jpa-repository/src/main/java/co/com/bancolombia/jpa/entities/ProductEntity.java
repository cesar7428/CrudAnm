package co.com.bancolombia.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    private String id;
    @Column
    private String nombre;
    @Column
    private String genero;
    @Column
    private String especie;
    @Column
    private String habitad;
    @Column
    private int numPatas;
    @Column
    private boolean domestico;
}
