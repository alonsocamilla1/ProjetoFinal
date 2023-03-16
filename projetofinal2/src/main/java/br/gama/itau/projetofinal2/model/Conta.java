package br.gama.itau.projetofinal2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Conta {

    
    // Modelo de dados da Conta
    // Cria uma tabela Conta com número, agência, tipo, saldo e id do cliente
    // O número da conta (numeroConta) é incrementado automaticamente a cada conta
    // criada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroConta;

    private int agencia;
    private int tipoConta;
    private double saldo;

    // O idCliente é uma coluna de relacionamento N:1 da tabela Conta com Cliente,
    // pegando a chave estrangeira

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "conta")
    @JsonIgnoreProperties("contas")
    private List<Movimentacao> movimentacoes;
    
    /*@OneToMany
    @JoinColumn(name = "id_numSeq")
    @JsonIgnoreProperties("conta") 
    private Movimentacao movimentacao;*/
    
    

    //@ManyToOne
    //@JoinColumn(name = "id_cliente")
    //private Cliente cliente;
}


