package br.com.fiap.globalsolutions.globalsolutions.solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
