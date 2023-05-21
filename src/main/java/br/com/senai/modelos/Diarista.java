package br.com.senai.modelos;

import java.security.InvalidParameterException;

public class Diarista extends Pessoa {

    private double valorHora;

    public Diarista(String nome, String endereco, String telefone, double valorHora) {

        super(nome, endereco, telefone);
        this.valorHora = valorHora;
    }

    public double calcularValorHora(int quantidadeHoras) {

        if (quantidadeHoras < 1 || quantidadeHoras > 12)
            throw new InvalidParameterException("Horas contratadas não devem ser inferior a 1 hora ou superior a 12 horas");

        return this.valorHora * quantidadeHoras;
    }

    public void realizarAtendimento() {
        System.out.println("Realizando atendimento");
    }
}
