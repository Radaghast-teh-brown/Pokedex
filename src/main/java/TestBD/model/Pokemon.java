package TestBD.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nome;
    @Column
    private String tipo;
}
