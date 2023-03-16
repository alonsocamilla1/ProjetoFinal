package br.gama.itau.projetofinal2.util;

import java.time.LocalDate;

import br.gama.itau.projetofinal2.model.Movimentacao;

public class GenerateMovimentacao {
    
    public static Movimentacao novaMoviToSave() {
        return Movimentacao.builder()
            .dataOperacao(LocalDate.now())
            .valor(1.0)
            .tipoOperacao(1)
            .build();
    }

    public static Movimentacao moviValida() {
        return Movimentacao.builder()
            .numSeq(1)
            .dataOperacao(LocalDate.now())
            .valor(1.0)
            .tipoOperacao(1)
            .build();
    
}
}
