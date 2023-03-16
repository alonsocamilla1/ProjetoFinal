package br.gama.itau.projetofinal2.util;

import br.gama.itau.projetofinal2.model.Conta;

public class GenerateConta {
    public static Conta novaContaToSave() {
        return Conta.builder()
            .agencia(1111)
            .tipoConta(2)
            .saldo(10.0)
            .build();
    }

public static Conta contaValida() {
    return Conta.builder()
            .numeroConta(1)
            .agencia(1111)
            .tipoConta(2)
            .saldo(10.0)
            .build();
    }

    public static Conta novaContaToSave2() {
        return Conta.builder()
            .agencia(2222)
            .tipoConta(1)
            .saldo(20.0)
            .build();
    }

    public static Conta contaValida2() {
        return Conta.builder()
            .numeroConta(2)
            .agencia(2222)
            .tipoConta(1)
            .saldo(20.0)
            .build();
    }
}
