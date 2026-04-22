import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data // Gera Getters, Setters, Equals, HashCode e ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nome;
    private String cpf;
    private String email;
}