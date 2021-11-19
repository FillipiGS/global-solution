package br.com.fiap.globalsolutions.globalsolutions.utils;

import br.com.fiap.globalsolutions.globalsolutions.doador.Doador;
import br.com.fiap.globalsolutions.globalsolutions.solicitacao.Solicitacao;
import br.com.fiap.globalsolutions.globalsolutions.solicitacao.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class SolicitacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Override
    public void run(String... args) throws Exception {

        Solicitacao solicitacao1 = new Solicitacao("Ação da Cidadania");
        solicitacao1.setInstituicao("Ação da Cidadania");
        solicitacao1.setCnpj("00.346.076/0001-73");
        solicitacao1.setEmail("acaodacidadania@plugue.com.br");
        solicitacao1.setTelefone("(21) 2233-7460");
        solicitacao1.setEndereco("Rua Atibaia, 218 - Perdizes, São Paulo - SP, 01235-010");
        solicitacao1.setAlimento("Perecíveis");
        solicitacao1.setDescricao("Estamos fazendo uma campanha de natal para crianças!");

        Solicitacao solicitacao2 = new Solicitacao("Amigos do Bem");
        solicitacao2.setInstituicao("Amigos do Bem");
        solicitacao2.setCnpj("05.108.918/0001-72");
        solicitacao2.setEmail("informacoes@amigosdobem.org");
        solicitacao2.setTelefone("(11) 3019-0100");
        solicitacao2.setEndereco("Rua Dr. Gabriel de Resende, 122 - Vila Invernada, São Paulo - SP, 03350-005");
        solicitacao2.setAlimento("Não Perecíveis");
        solicitacao2.setDescricao("Estamos coletando alimentos como: Arroz, feijão e oléo. Para ajudar crianças de creches na periferia de SP");

        solicitacaoRepository.save(solicitacao1);
        solicitacaoRepository.save(solicitacao2);


    }

}
