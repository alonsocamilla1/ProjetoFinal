package br.gama.itau.projetofinal2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Movimentacao> recuperarTodas(Integer id) {
        return movimentacaoRepo.findById(id);
    }

}
