package br.gama.itau.projetofinal2.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projetofinal2.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{
    
}
