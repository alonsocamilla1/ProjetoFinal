package br.gama.itau.projetofinal2.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projetofinal2.model.Cliente;
import br.gama.itau.projetofinal2.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Integer>{

    List<Conta> findByCliente(Optional<Cliente> cliente);

}