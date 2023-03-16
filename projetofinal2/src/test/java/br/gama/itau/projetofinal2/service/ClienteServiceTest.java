package br.gama.itau.projetofinal2.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.Optional;

//import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.projetofinal2.exception.NotFoundException;
import br.gama.itau.projetofinal2.model.Cliente;
import br.gama.itau.projetofinal2.repositorio.ClienteRepo;
import br.gama.itau.projetofinal2.util.GenerateCliente;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;
    
    @Mock
    private ClienteRepo repo;

    @Test
    public void cadastrarCliente_returnNovoCliente_whenClienteValido() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Cliente.class)))
            .thenReturn(GenerateCliente.clienteValido());

        Cliente novoCliente = GenerateCliente.novoClienteToSave();
        Cliente clienteCriado = service.cadastrarCliente(novoCliente);

        assertThat(clienteCriado).isNotNull();
        assertThat(clienteCriado.getIdCliente()).isPositive();
        assertThat(clienteCriado.getTelefoneCliente()).isEqualTo(GenerateCliente.clienteValido().getTelefoneCliente());
        // verifica se o método save foi chamado 1 vez
        verify(repo, Mockito.times(1)).save(novoCliente);
    }


    @Test
    public void cadastrarCliente__returnNotFoundException_whenClienteInvalido() {
        Cliente clienteValido = GenerateCliente.clienteValido();

        assertThrows(NotFoundException.class, () ->{
            service.cadastrarCliente(clienteValido);
        });
    }

    @Test
    public void recuperarPeloId_returnCliente_whenIdExist() {
        BDDMockito.when(repo.findById(ArgumentMatchers.any(int.class)))
            .thenReturn(Optional.of(GenerateCliente.clienteValido()));

        Cliente clienteEncontrado = service.recuperarPeloID(1);
        
        assertThat(clienteEncontrado)
            .isNotNull();
        assertThat(clienteEncontrado.getIdCliente())
            .isGreaterThan(0);
        assertThat(clienteEncontrado.getTelefoneCliente())
            .isEqualTo(GenerateCliente.clienteValido().getTelefoneCliente())
            .isNotNull();
}


    @Test
    public void recuperarPeloId_throwException_whenIdNotExist() {
        Cliente clienteValido = GenerateCliente.novoClienteToSave();
    // verifica se uma exception do tipo NotFoundException é lançada
    // () -> { } é uma chamada de método anônimo
        assertThrows(NotFoundException.class, () -> {
        service.recuperarPeloID(clienteValido.getIdCliente());
        });
}
}

