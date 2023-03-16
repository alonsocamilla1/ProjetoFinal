package br.gama.itau.projetofinal2.exception;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String titulo;
    private String mensagem;
    private int codigoStatus;
    private LocalDate timestamp;

}
