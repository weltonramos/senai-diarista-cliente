package br.com.senai.modelos;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String nomeCorrentista;
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

        String registro = String.format(" + Depósito realizado no valor de %.2f", valor);
        this.extrato.add(registro);
    }

    public void transferir(double valor, Conta contaDestino) {

        validarValor(valor);

        this.realizarRetirada(valor);
        contaDestino.realizarCredito(valor);

        String registroDeDebito = String.format(" - Transferência realizada para %s no valor de %.2f", contaDestino.getNomeCorrentista(), valor);
        this.extrato.add(registroDeDebito);

        String registroDeCredito = String.format(" + Transferência recebida de %s no valor de %.2f", this.getNomeCorrentista(), valor);
        contaDestino.realizarRegistroExtrato(registroDeCredito);
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

    //ToDo: Verificar uma forma de separar o que é crédito e o que é débito
    private void realizarRegistroExtrato(String registro) {
        this.extrato.add(registro);
    }
}
