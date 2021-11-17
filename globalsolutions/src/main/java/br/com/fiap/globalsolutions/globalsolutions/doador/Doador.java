package br.com.fiap.globalsolutions.globalsolutions.doador;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity (name = "tb_doador")
@Getter
@Setter
@ToString
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String documento;

    private String email;

    private String telefone;

    private String endereco;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    public Doador(String nome) {
    }

    public Doador() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doador doador = (Doador) o;
        return Objects.equals(id, doador.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
