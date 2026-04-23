package br.com.luanmarcelseverino;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

@Epic("Sistema Bancário")
@Feature("Transações")
public class ContaTest {

    @Test
    @DisplayName("Deve realizar depósito com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o saldo aumenta corretamente após um depósito")
    void deveRealizarDeposito() {
        // Agora o Java vai encontrar o Cliente e a ContaCorrente
        Cliente luan = new Cliente();
        luan.setNome("Luan");
        
        ContaCorrente cc = new ContaCorrente(luan);
        cc.depositar(100.0);
        
        assertEquals(100.0, cc.getSaldo(), "O saldo deve ser 100 após o depósito");
    }

    @Test
    @DisplayName("Deve realizar transferência entre contas")
    @Severity(SeverityLevel.BLOCKER)
    void deveRealizarTransferencia() {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        ContaCorrente cc = new ContaCorrente(luan);
        ContaPoupanca poupanca = new ContaPoupanca(luan);
        
        cc.depositar(500.0);
        cc.transferir(poupanca, 200.0);
        
        assertEquals(300.0, cc.getSaldo());
        assertEquals(200.0, poupanca.getSaldo());
    }
}