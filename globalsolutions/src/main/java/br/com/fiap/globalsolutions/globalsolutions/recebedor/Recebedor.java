package br.com.fiap.globalsolutions.globalsolutions.recebedor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_recebedor")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Recebedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String instituicao;

    private String cnpj;

    private String email;

    private String telefone;

    private String endereco;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    public Recebedor(String instituicao) {
    }

}
