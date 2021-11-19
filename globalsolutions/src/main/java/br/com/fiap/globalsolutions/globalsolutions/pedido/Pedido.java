package br.com.fiap.globalsolutions.globalsolutions.pedido;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_pedido")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String instituicao;

    private String email;

    private String telefone;

    private String endereco;

    private String cnpj;

    private String alimento;

    private String descricao;

    private boolean status;

    public Pedido(String instituicao){

    }


}
