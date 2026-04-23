package br.com.luanmarcelseverino;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter protected int agencia;
    @Getter protected int numero;
    @Getter protected double saldo;
    @Getter protected Cliente cliente;
    @Getter protected List<Transacao> extrato;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            extrato.add(new Transacao("SAQUE", valor));
        } else {
            System.out.println("Erro: Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.add(new Transacao("DEPOSITO", valor));
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            extrato.add(new Transacao("TRANSFERENCIA ENVIADA", valor));
            contaDestino.depositar(valor);
        } else {
            System.out.println("Erro: Saldo insuficiente para transferência.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

        System.out.println("=== Extrato ===");
        for (Transacao t : extrato) {
            System.out.println(String.format("%s: R$ %.2f", t.getTipo(), t.getValor()));
        }
    }
}