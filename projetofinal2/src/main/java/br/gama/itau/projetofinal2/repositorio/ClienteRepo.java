package br.gama.itau.projetofinal2.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projetofinal2.model.Cliente;


public interface ClienteRepo extends  CrudRepository<Cliente, Integer>{
    
}