package br.com.senai.modelos;

public abstract class Pessoa {

    private final String nome;
    private final String endereco;
    private final String telefone;
    private final Conta conta;

    protected Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.conta = new Conta();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {

        return String.format("Nome: %s%nEndereço: %s%nTelefone: %s%nSaldo da conta: %.2f",
                this.getNome(), this.getEndereco(), this.getTelefone(), this.getConta().getSaldo());
    }
}
