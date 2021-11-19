package br.com.fiap.globalsolutions.globalsolutions.utils;

import br.com.fiap.globalsolutions.globalsolutions.pedido.Pedido;
import br.com.fiap.globalsolutions.globalsolutions.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PedidoInicialBanco implements CommandLineRunner {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        Pedido pedido1 = new Pedido("Ação da Cidadania");
        pedido1.setInstituicao("Ação da Cidadania");
        pedido1.setCnpj("00.346.076/0001-73");
        pedido1.setEmail("acaodacidadania@plugue.com.br");
        pedido1.setTelefone("(21) 2233-7460");
        pedido1.setEndereco("Rua Atibaia, 218 - Perdizes, São Paulo - SP, 01235-010");
        pedido1.setAlimento("Perecíveis");
        pedido1.setDescricao("Estamos fazendo uma campanha de natal para crianças!");
        pedido1.setStatus(true);

        Pedido pedido2 = new Pedido("Amigos do Bem");
        pedido2.setInstituicao("Amigos do Bem ");
        pedido2.setCnpj("05.108.918/0001-72 ");
        pedido2.setEmail("informacoes@amigosdobem.org");
        pedido2.setTelefone("(11) 3019-0100");
        pedido2.setEndereco("Rua Dr. Gabriel de Resende, 122 - Vila Invernada, São Paulo - SP, 03350-005");
        pedido2.setAlimento("Não Perecíveis");
        pedido2.setDescricao("Estamos coletando alimentos como: Arroz, feijão e oléo. Para ajudar crianças de creches na periferia de SP");
        pedido1.setStatus(true);

        pedidoRepository.save(pedido1);
        pedidoRepository.save(pedido2);

    }
}
