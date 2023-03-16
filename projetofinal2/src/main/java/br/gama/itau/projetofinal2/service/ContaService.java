package br.gama.itau.projetofinal2.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.gama.itau.projetofinal2.exception.NotFoundException;
import br.gama.itau.projetofinal2.model.Cliente;
import br.gama.itau.projetofinal2.model.Conta;
import br.gama.itau.projetofinal2.repositorio.ClienteRepo;
import br.gama.itau.projetofinal2.repositorio.ContaRepo;

import org.springframework.stereotype.Service;

@Service
public class ContaService {

    
    // Injeção de dependências
    @Autowired
    private ContaRepo repo;

    @Autowired
    private ClienteRepo clienteRepository;

    // Método que adicionas uma nova conta
    // Recebe como parâmetro uma conta (com ID do seu cliente) e retorna seus dados
    // completos caso tenha sido adicionado com sucessos
    // Senão, retorna nulo (null)
    public Conta adicionarConta(Conta novaConta) {
        if(novaConta.getNumeroConta() > 0) {
            throw new NotFoundException("conta já cadastrado"); 
        }
        Conta contaAdicionada = repo.save(novaConta);
        return contaAdicionada;

    }

    // Método que recebe um número da conta e retorna os dados dessa conta se for
    // encontrada
    // Senão, retorna uma exceção
    public Conta recuperarPeloNumero(Integer numeroConta) {
        Optional<Conta> contaOptional = repo.findById(numeroConta);
        if (contaOptional.isPresent()) {
            return contaOptional.get();
        } else {
            throw new NotFoundException("Cliente não encontrado");
        }
    }

    public List<Conta> recuperarContasPeloCliente(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return repo.findByCliente(cliente);
    }

    public void alterarDados(Conta conta, Double valor) {
        conta.setSaldo(valor);
        repo.save(conta);
    }

    
}
