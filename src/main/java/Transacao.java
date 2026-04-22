import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data // Cria todos os Getters, Setters e toString automaticamente
@AllArgsConstructor // Cria o construtor com os 4 argumentos que a Conta está pedindo
public class Transacao {
    private LocalDateTime data;
    private String tipo;
    private double valor;
    private String descricao; // ou o nome que você usou para o 4º argumento
}