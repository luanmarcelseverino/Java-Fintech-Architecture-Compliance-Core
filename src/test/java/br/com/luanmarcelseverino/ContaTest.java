package br.com.luanmarcelseverino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Sistema Bancário")
@Feature("Transações")
public class ContaTest {

    @Test
    @DisplayName("Deve realizar depósito com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o saldo aumenta corretamente após um depósito")
    void deveRealizarDeposito() {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        ContaCorrente cc = new ContaCorrente(luan);
        cc.depositar(100.0);

        assertEquals(100.0, cc.getSaldo(), "O saldo deve ser 100 após o depósito");
    }

    @Test
    @DisplayName("Deve realizar saque com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o saldo diminui corretamente após um saque")
    void deveRealizarSaque() {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        ContaCorrente cc = new ContaCorrente(luan);
        cc.depositar(300.0);
        cc.sacar(100.0);

        assertEquals(200.0, cc.getSaldo(), "O saldo deve ser 200 após o saque");
    }

    @Test
    @DisplayName("Não deve permitir saque com saldo insuficiente")
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida que o saldo não é alterado quando não há fundos suficientes")
    void naoDevePermitirSaqueSemSaldo() {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        ContaCorrente cc = new ContaCorrente(luan);
        cc.depositar(50.0);
        cc.sacar(200.0);

        assertEquals(50.0, cc.getSaldo(), "O saldo deve permanecer 50 após tentativa de saque inválido");
    }

    @Test
    @DisplayName("Deve realizar transferência entre contas")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Valida se os saldos são atualizados corretamente após uma transferência")
    void deveRealizarTransferencia() {
        Cliente luan = new Cliente();
        luan.setNome("Luan");

        ContaCorrente cc = new ContaCorrente(luan);
        ContaPoupanca poupanca = new ContaPoupanca(luan);

        cc.depositar(500.0);
        cc.transferir(poupanca, 200.0);

        assertEquals(300.0, cc.getSaldo(), "Conta corrente deve ter 300 após transferência");
        assertEquals(200.0, poupanca.getSaldo(), "Conta poupança deve ter 200 após transferência");
    }
}