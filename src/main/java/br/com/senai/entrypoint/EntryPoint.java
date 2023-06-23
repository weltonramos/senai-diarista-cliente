package br.com.senai.entrypoint;

import br.com.senai.modelos.Cliente;
import br.com.senai.modelos.Diarista;

public class EntryPoint {

    public static void main(String[] args) {

        Diarista marilene = new Diarista("Marilene Domingues", "Rua Direita N 8", "11 4141-4242", 80.0);

        Cliente francesco = new Cliente("Francesco Virgulini Fiaaaunnnnn", "R Numere Quarent i Tchinquê", "11 5252-4141");
        francesco.getConta().depositar(100.0);

        System.out.println("\nDados de Francesco: " + francesco);
        System.out.println("\nDados de Marilene: " + marilene);

        francesco.contratarDiarista(marilene, 8);

        System.out.println("\nExtrato Francesco");
        francesco.getConta().exibirExtrato();

        System.out.println("\nExtrato Marilene");
        marilene.getConta().exibirExtrato();

    }
}
