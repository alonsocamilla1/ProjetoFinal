package br.gama.itau.projetofinal2.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projetofinal2.model.Conta;
import br.gama.itau.projetofinal2.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{
    
    List<Movimentacao> findByConta(Conta conta);
}
