package br.com.senai.modelos;

public enum Operacao {

    DEBITO_TRANSFERENCIA("Débito transferência"),
    CREDITO_TRANSFERENCIA("Crédito transferência"),
    CREDITO_DEPOSITO("Crédito deposito");

    private final String descricao;

    Operacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
