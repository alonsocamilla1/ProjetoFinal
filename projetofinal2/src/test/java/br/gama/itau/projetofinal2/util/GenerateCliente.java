package br.gama.itau.projetofinal2.util;

import br.gama.itau.projetofinal2.model.Cliente;

public class GenerateCliente {

    public static Cliente novoClienteToSave() {
            return Cliente.builder()
            .cpfCliente("33333333")
            .telefoneCliente("(33)33333")
            .build();
  
               }
    
    
    public static Cliente clienteValido() {
        return Cliente.builder()
        .idCliente(3)
        .cpfCliente("33333333")
        .telefoneCliente("(33)33333")
        .build();
        }
    
}
