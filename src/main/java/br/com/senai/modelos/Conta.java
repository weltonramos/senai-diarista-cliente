package br.com.senai.modelos;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private final String nomeCorrentista;
    private double saldo = 0.0;
    private final List<String> extrato = new ArrayList<>();

    public Conta(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void sacar(double valor) {
        validarValor(valor);
        realizarRetirada(valor);
    }

    public void depositar(double valor) {

        validarValor(valor);
        realizarCredito(valor);

        realizarRegistroExtrato(Operacao.CREDITO_DEPOSITO, valor, this.getNomeCorrentista());
    }

    public void transferir(double valor, Conta contaDestino) {

        validarValor(valor);

        realizarRetirada(valor);
        contaDestino.realizarCredito(valor);

        realizarRegistroExtrato(Operacao.DEBITO_TRANSFERENCIA, valor, nomeCorrentista);
        contaDestino.realizarRegistroExtrato(Operacao.CREDITO_TRANSFERENCIA, valor, contaDestino.getNomeCorrentista());
    }

    public void exibirExtrato() {
        extrato.forEach(System.out::println);
    }

    private void validarValor(double valor) {

        if (valor <= 0)
            throw new InvalidParameterException("Valor não pode ser zero ou negativo");
    }

    private void realizarCredito(double valor) {
        this.saldo += valor;
    }

    private void realizarRetirada(double valor) {

        if (this.saldo < valor)
            throw new InvalidParameterException("Valor a retirar não pode ser maior que saldo atual:" +
                    "\nSaldo atual: " + this.saldo);

        this.saldo -= valor;
    }

    private void realizarRegistroExtrato(Operacao operacao, double valor, String titular) {

        String registro = String.format("%s no valor de %.2f para %s", operacao, valor, titular);
        extrato.add(registro);
    }
}
