package br.com.fiap.globalsolutions.globalsolutions.solicitacao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_solicitacao")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Solicitacao {

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

    public Solicitacao(String instituicao) {
    }


}
