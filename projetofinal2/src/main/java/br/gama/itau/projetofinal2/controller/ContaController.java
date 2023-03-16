package br.gama.itau.projetofinal2.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.gama.itau.projetofinal2.exception.NotFoundException;
import br.gama.itau.projetofinal2.model.Conta;
//import br.gama.itau.projetofinal2.repositorio.ContaRepo;
import br.gama.itau.projetofinal2.service.ContaService;



@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    
 //   @Autowired
 //   private ContaRepo contaRepo;

    

    // - /contas (POST) - para cadastrar uma nova conta, chamando o serviço
    // adicionarConta, podendo retornar 201 ou 400
    @PostMapping // OK
    public ResponseEntity<Conta> adicionarConta(@RequestBody Conta novaConta) {
        Conta contaInserida = contaService.adicionarConta(novaConta);
        if (contaInserida == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Conta>(contaInserida, HttpStatus.CREATED);
    }


    // - /contas/{id} (GET)- chama o serviço recuperarPeloNumero,
    // podendo retornar 200 ou 404
    @GetMapping("/{numeroConta}")
    public Conta recuperarPeloNumero(@PathVariable Integer numeroConta) {
        return contaService.recuperarPeloNumero(numeroConta);
    }

    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Conta>> recuperarContasPeloCliente(@PathVariable Integer id) {
        List<Conta> conta = contaService.recuperarContasPeloCliente(id);
        return ResponseEntity.ok().body(conta);
    }

  /*  @PutMapping
    public ResponseEntity<Object> alterarDados(@PathVariable @RequestBody Conta conta, int numeroConta) {
        Conta contaSalva = contaRepo.findByConta(conta)
            .orElseThrow(() -> new NotFoundException("Conta naão encontrada"));
        Conta contaAtualizada = contaService.alterarDados(conta, saldo);
        if(contaAtualizada == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contaAtualizada);
    } */
}    
    
    
