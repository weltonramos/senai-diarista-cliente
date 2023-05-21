package br.com.senai.modelos;

import java.security.InvalidParameterException;

public class Cliente extends Pessoa {

    public Cliente(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }

    public void contratarDiarista(Diarista diarista, int quantidadeHoras) {

        double horasASePagar = diarista.calcularValorHora(quantidadeHoras);
        double saldoAtual = this.getConta().getSaldo();

        if (saldoAtual <= horasASePagar)
            throw new InvalidParameterException(
                    "Não há saldo suficiênte para contratar a diarista " + diarista.getNome() +
                            " \nSaldo atual: " + saldoAtual + "\nValor do serviço: " + horasASePagar);

        this.getConta().transferir(horasASePagar, diarista.getConta());
    }
}
