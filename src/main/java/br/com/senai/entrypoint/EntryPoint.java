package br.com.senai.entrypoint;

import br.com.senai.modelos.Cliente;
import br.com.senai.modelos.Diarista;

public class EntryPoint {

    public static void main(String[] args) {

        Diarista marlene = new Diarista("Marilene Domingues", "Rua Direita N 8", "11 4141-4242", 80.0);

        Cliente frederico = new Cliente("Francesco Virgulini Fiaaaunnnnn", "R Numere Quarent i Tchinquê", "11 5252-4141");
        frederico.getConta().depositar(1000.0);

        System.out.println("Dados de Francesco: " + frederico);
        System.out.println("\nDados de Marilene: " + marlene);

        frederico.contratarDiarista(marlene, 8);

        System.out.println("\nExtrato Frederico");
        frederico.getConta().exibirExtrato();

        System.out.println("\nExtrato Marilene");
        marlene.getConta().exibirExtrato();

    }
}
