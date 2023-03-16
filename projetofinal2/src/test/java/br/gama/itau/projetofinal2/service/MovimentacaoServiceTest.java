package br.gama.itau.projetofinal2.service;

import static org.assertj.core.api.Assertions.assertThat;
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

import br.gama.itau.projetofinal2.model.Movimentacao;
import br.gama.itau.projetofinal2.repositorio.MovimentacaoRepo;
import br.gama.itau.projetofinal2.util.GenerateMovimentacao;

@ExtendWith(MockitoExtension.class)
public class MovimentacaoServiceTest {

    @InjectMocks
    private MovimentacaoService service;
    @Mock
    private MovimentacaoRepo repo;

    @Test
    public void cadastrarMovimentacao_returnMovimentacaoCadastrada_whenMovimentacaoExist() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
                .thenReturn(GenerateMovimentacao.moviValida());

        Movimentacao novaMovi = GenerateMovimentacao.novaMoviToSave();
        Movimentacao moviCadastrada = service.cadastrarMovimentacao(novaMovi);

        assertThat(moviCadastrada).isNotNull();
        assertThat(moviCadastrada.getNumSeq()).isPositive();
        assertThat(moviCadastrada.getValor()).isEqualTo(novaMovi.getValor());
        
        verify(repo, Mockito.times(1)).save(novaMovi);
    }

    @Test
    public void cadastrarMovimentacao_returnNull_whenMovimentacaoNotExist() {
        Movimentacao novaMovi = GenerateMovimentacao.moviValida();
        Movimentacao moviCadastrada = service.cadastrarMovimentacao(novaMovi);

        assertThat(moviCadastrada).isNull();

        verify(repo, Mockito.times(1)).save(novaMovi);
    }

    @Test
    public void recuperarTodas_returnTodasAsMovimentacoesCadastradas_whenSucesso() {
       // preparação
       BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
       .thenReturn(GenerateMovimentacao.moviValida());

       BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
       .thenReturn(GenerateMovimentacao.moviValida2());

        //ação
        Optional<Movimentacao> listaCompleta = service.recuperarTodas(1);

        // verificações
        assertThat(listaCompleta).isNotNull();
    }

}
