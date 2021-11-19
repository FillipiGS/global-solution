package br.com.fiap.globalsolutions.globalsolutions.utils;

import br.com.fiap.globalsolutions.globalsolutions.doador.Doador;
import br.com.fiap.globalsolutions.globalsolutions.doador.DoadorRepository;
import br.com.fiap.globalsolutions.globalsolutions.pedido.Pedido;
import br.com.fiap.globalsolutions.globalsolutions.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DoadorInicialBanco implements CommandLineRunner {

    @Autowired
    private DoadorRepository doadorRepository;
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        Doador doador1 = new Doador("CEAGESP");
        doador1.setNome("CEAGESP");
        doador1.setDocumento("62.463.005/0006-12");
        doador1.setEmail("bancodealimentos@ceagesp.gov.br");
        doador1.setTelefone("(11) 3643-3920");
        doador1.setEndereco("Av. Dr. Gastão Vidigal");
        doador1.setNumero(1946);
        doador1.setBairro("Vila Leopoldina");
        doador1.setCidade("São Paulo");
        doador1.setEstado("SP");
        doador1.setCep("05316-900");

        Doador doador2 = new Doador("Instituto Alimento para todos");
        doador2.setNome("Instituto Alimento para todos");
        doador2.setDocumento("31.774.125/0001-00");
        doador2.setEmail("grupoalimentoparatodos@gmail.com");
        doador2.setTelefone("(12) 98133-3043");
        doador2.setEndereco("R. Três, Jardim");
        doador2.setNumero(123);
        doador2.setBairro("Santa Helena");
        doador2.setCidade("São José dos Campos");
        doador2.setEstado("SP");
        doador2.setCep("12225-885");

        Pedido pedido3 = new Pedido("Teste");
        pedido3.setInstituicao("Teste");

        doadorRepository.save(doador1);
        doadorRepository.save(doador2);

    }
}
