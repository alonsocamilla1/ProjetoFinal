package br.gama.itau.projetofinal2.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projetofinal2.model.Cliente;
import br.gama.itau.projetofinal2.repositorio.ClienteRepo;
import lombok.RequiredArgsConstructor;
import br.gama.itau.projetofinal2.exception.NotFoundException;



@Service
@RequiredArgsConstructor
public class ClienteService {
    

    
    // Injeção de dependência
    @Autowired
    private ClienteRepo repo;

    // Método que cadastra um novo cliente
    // Recebe como entrada um objeto do tipo cliente e retorna-o completo caso ele tenha sido cadastrado com sucesso
    // Senão, retorna nulo (null)
    public Cliente cadastrarCliente(Cliente novoCliente) {
        if(novoCliente.getIdCliente() > 0) {
            throw new NotFoundException("cliente já cadastrado");
            //return null;
        }
        Cliente clienteInserido = repo.save(novoCliente);
        return clienteInserido; 
    }

    // Método que retorna uma lista com todos os clientes cadastrados (apenas dados de cliente)
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) repo.findAll();
    }
    
   // Método que recebe um ID de cliente e retorna seus dados se encontrado
    // Caso não foi encontrado, retorna uma exceção
    
    public Cliente recuperarPeloID(Integer id) {
        Optional<Cliente> clienteOptional = repo.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException("cliente não encontrado");
        }

        Cliente clienteEncontrado = clienteOptional.get();
        return clienteEncontrado;
    }

   
}