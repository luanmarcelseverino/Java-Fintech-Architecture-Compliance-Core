import br.com.luanmarcelseverino.Cliente;
import br.com.luanmarcelseverino.Conta;
import br.com.luanmarcelseverino.ContaCorrente;
import br.com.luanmarcelseverino.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        Conta cc = new ContaCorrente(luan);
        Conta poupanca = new ContaPoupanca(luan);

        cc.depositar(1500);      // Saldo: 1500
        cc.sacar(100);           // Saldo: 1400
        cc.transferir(poupanca, 500); // Saldo CC: 900 | Poupança: 500

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}