package com.ezequiel.biblioteca.repository;

public enum TelasID {
    ENTRAR_TELA(1, "entrar"),
    CADASTRAR_TELA(2, "cadastrar");
    private final int valor;
    private final String tela;

    TelasID(int valor, String tela) {
        this.valor = valor;
        this.tela = tela;
    }

    public int getValor() {
        return valor;
    }

    public String getTela() {
        return tela;
    }


}
