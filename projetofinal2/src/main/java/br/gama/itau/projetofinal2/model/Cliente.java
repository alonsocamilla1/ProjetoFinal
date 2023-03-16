package br.gama.itau.projetofinal2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    // Modelo de dados do Cliente
    // Cria uma tabela Cliente com Id, nome, cpf e telefone
    // O Id é incrementado automaticamente a cada cliente criado

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCliente;

    @Column(length = 100)
    private String nomeCliente;

    @Column(length = 20, unique = true)
    private String cpfCliente;

    @Column(length = 20, unique = true)
    private String telefoneCliente;

      //Um cliente tem várias contas
      @OneToMany(mappedBy = "cliente")
      @JsonIgnoreProperties("cliente") // quando for preencher a lista de contas, não coloque o cliente de cada conta
      private List<Conta> contas;
}