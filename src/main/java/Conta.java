import lombok.Getter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter 
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> extrato = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            this.extrato.add(new Transacao(LocalDateTime.now(), "SAQUE", valor, "Saque em espécie"));
            
            // Integração com serviços de Robustez
            AuditoriaService.registrarEvento(this.cliente.getNome(), "SAQUE REALIZADO");
            NotificacaoService.enviarAlerta(String.format("Saque de R$ %.2f realizado.", valor));
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.extrato.add(new Transacao(LocalDateTime.now(), "DEPÓSITO", valor, "Depósito recebido"));
            
            // Integração com serviços de Robustez
            AuditoriaService.registrarEvento(this.cliente.getNome(), "DEPÓSITO RECEBIDO");
            NotificacaoService.enviarAlerta(String.format("Depósito de R$ %.2f identificado.", valor));
        }
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            this.extrato.add(new Transacao(LocalDateTime.now(), "TRANSFERÊNCIA", valor, "Para conta: " + contaDestino.getNumero()));

            // Auditoria e Notificação específicas para Transferência
            AuditoriaService.registrarEvento(this.cliente.getNome(), "TRANSFERÊNCIA ENVIADA");
            NotificacaoService.enviarAlerta(String.format("Transferência de R$ %.2f enviada com sucesso!", valor));
        } else {
            System.out.println("Erro: Saldo insuficiente para transferência.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println("========================================");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
        
        System.out.println("--- Histórico de Transações ---");
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transacao t : extrato) {
                System.out.println(String.format("%s | %-15s | R$ %8.2f", 
                    t.getData().withNano(0), 
                    t.getTipo(), 
                    t.getValor()));
            }
        }
        System.out.println("========================================");
    }
}