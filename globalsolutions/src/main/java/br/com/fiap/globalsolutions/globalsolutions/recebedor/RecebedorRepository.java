package br.com.fiap.globalsolutions.globalsolutions.recebedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecebedorRepository extends JpaRepository<Recebedor, Long> {
}
