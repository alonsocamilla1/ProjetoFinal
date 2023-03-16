package br.gama.itau.projetofinal2.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.projetofinal2.exception.NotFoundException;
import br.gama.itau.projetofinal2.model.*;
import br.gama.itau.projetofinal2.repositorio.*;
import br.gama.itau.projetofinal2.util.GenerateConta;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;
    @Mock
    private ContaRepo repo;
   
    @Test
    public void alterarDados_returnDadosAlterados_whenSucess() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida());

        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida2());

        Conta contaParaAlterar = GenerateConta.contaValida2();
       // Conta contaAlterada = service.alterarDados(contaParaAlterar, 30.0);

       // assertThat(contaAlterada.getNumeroConta()).isEqualTo(2);
       // assertThat(contaAlterada.getSaldo()).isEqualTo(contaParaAlterar.getSaldo());
     
        verify(repo, Mockito.times(1)).save(contaParaAlterar);
    }

    @Test
    public void adicionarConta_returnContaAdicionada_whenContaValida() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida());

        Conta novaConta = GenerateConta.novaContaToSave();

       Conta contaAdicionada = service.adicionarConta(novaConta);
        assertThat(contaAdicionada).isNotNull();
        assertThat(contaAdicionada.getNumeroConta()).isPositive();
        assertThat(contaAdicionada.getSaldo()).isEqualTo(novaConta.getSaldo());
        verify(repo, Mockito.times(1)).save(novaConta);
    }

    @Test
    public void adicionarConta_returnNotFoundException_whenContaJaCadastrada() {
        Conta contaValida = GenerateConta.contaValida();
        
        assertThrows(NotFoundException.class, () -> {
            service.adicionarConta(contaValida);
        });
    }

    @Test
    public void recuperarPeloNumero_returnConta_whenNumeroExist() {
        BDDMockito.when(repo.findById(ArgumentMatchers.any(int.class)))
                .thenReturn(Optional.of(GenerateConta.contaValida()));
        Conta contaEncontrada = service.recuperarPeloNumero(2);
        assertThat(contaEncontrada).isNotNull();
        assertThat(contaEncontrada.getNumeroConta()).isGreaterThan(0);
        assertThat(contaEncontrada.getNumeroConta())
                .isEqualTo(GenerateConta.contaValida()
                .getNumeroConta());
    }

    @Test
    public void recuperarPeloNumero_throwException_whenNumeroNotExist() {
        Conta contaValida = GenerateConta.novaContaToSave();
        // verifica se uma exception do tipo NotFoundException é lançada
        assertThrows(NotFoundException.class, () -> {
            service.recuperarPeloNumero(contaValida.getNumeroConta());
        });
    }

    @Test
    public void recuperarContasPeloCliente_returnListaConta_whenIdExist() {
        List<Conta> listaContas = new ArrayList<>();
        listaContas.add(GenerateConta.contaValida());
        listaContas.add(GenerateConta.contaValida2());
        BDDMockito.when(repo.findAll()).thenReturn(listaContas);
        List<Conta> listaRecuperada = service.recuperarContasPeloCliente(1);
        assertThat(listaRecuperada).isNotNull();
        assertThat(listaRecuperada).isNotEmpty();
        assertThat(listaRecuperada.get(0).getNumeroConta()).isEqualTo(GenerateConta.contaValida().getNumeroConta());
    }

 
    
}
