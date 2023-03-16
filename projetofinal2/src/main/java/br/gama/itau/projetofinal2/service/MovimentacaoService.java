package br.gama.itau.projetofinal2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projetofinal2.exception.NotFoundException;
import br.gama.itau.projetofinal2.model.Conta;
import br.gama.itau.projetofinal2.model.Movimentacao;
import br.gama.itau.projetofinal2.repositorio.MovimentacaoRepo;

@Service
public class MovimentacaoService {

    // Injeção de dependência
    @Autowired
    private MovimentacaoRepo movimentacaoRepo;

    // Método que cadastra uma nova Movimentação
    // Recebe como parâmetro um objeto do tipo Movimentação que retorna os dados da
    // movimentação
    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        // return movimentacaoRepo.save(movimentacao);
        Movimentacao movimentacaoInserido = movimentacaoRepo.save(movimentacao);
        return movimentacaoInserido;
    }

    
    // Método que recebe um número da conta (numeroConta) e retorna uma lista de
    // todas as movimentações de uma determinada conta
    // ===== Fazer com que retorne uma lista de movimentações através do número da
    // conta (numeroConta) =====
    public List<Movimentacao> recuperarTodas(int id){
        Conta conta = new Conta();
        conta.setNumeroConta(id);
        List<Movimentacao> listaMov = movimentacaoRepo.findByConta(conta);

        if (listaMov.isEmpty()) {
            throw new NotFoundException("movimentaçao não existe");
        }
        
        return listaMov;
    }

}
