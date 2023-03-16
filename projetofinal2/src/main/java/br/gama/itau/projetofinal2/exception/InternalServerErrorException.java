package br.gama.itau.projetofinal2.exception;

public class InternalServerErrorException  extends RuntimeException   {
    
    public InternalServerErrorException( String message){
        super(message);
    }
}
