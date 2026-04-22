import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data // Cria os Getters (getTipo, getValor, etc)
@AllArgsConstructor // Cria o construtor (Data, Tipo, Valor, Descrição)
@NoArgsConstructor
public class Transacao {
    private LocalDateTime data;
    private String tipo;
    private double valor;
    private String descricao;
}