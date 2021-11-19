package br.com.fiap.globalsolutions.globalsolutions.utils;

import br.com.fiap.globalsolutions.globalsolutions.doador.Doador;
import br.com.fiap.globalsolutions.globalsolutions.doador.DoadorRepository;
import br.com.fiap.globalsolutions.globalsolutions.recebedor.Recebedor;
import br.com.fiap.globalsolutions.globalsolutions.recebedor.RecebedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class RecebedorInicialBanco implements CommandLineRunner {

    @Autowired
    private RecebedorRepository recebedorRepository;

    @Override
    public void run(String... args) throws Exception {

        Recebedor recebedor1 = new Recebedor("CEAGESP");
        recebedor1.setInstituicao("CEAGESP");
        recebedor1.setCnpj("62.463.005/0006-12");
        recebedor1.setEmail("bancodealimentos1@ceagesp.gov.br");
        recebedor1.setTelefone("(11) 3643-3920");
        recebedor1.setEndereco("Av. Dr. Gastão Vidigal");
        recebedor1.setNumero(1946);
        recebedor1.setBairro("Vila Leopoldina");
        recebedor1.setCidade("São Paulo");
        recebedor1.setEstado("SP");
        recebedor1.setCep("05316-900");

        Recebedor recebedor2 = new Recebedor("Instituto Alimento para todos");
        recebedor2.setInstituicao("Instituto Alimento para todos");
        recebedor2.setCnpj("31.774.125/0001-00");
        recebedor2.setEmail("grupoalimentoparatodos1@gmail.com");
        recebedor2.setTelefone("(12) 98133-3043");
        recebedor2.setEndereco("R. Três, Jardim");
        recebedor2.setNumero(123);
        recebedor2.setBairro("Santa Helena");
        recebedor2.setCidade("São José dos Campos");
        recebedor2.setEstado("SP");
        recebedor2.setCep("12225-885");

        recebedorRepository.save(recebedor1);
        recebedorRepository.save(recebedor2);

    }
}
