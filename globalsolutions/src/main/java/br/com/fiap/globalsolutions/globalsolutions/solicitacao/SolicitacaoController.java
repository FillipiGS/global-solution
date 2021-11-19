package br.com.fiap.globalsolutions.globalsolutions.solicitacao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SolicitacaoController {

    private SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoController(SolicitacaoRepository solicitacaoRepository){
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @GetMapping("/solicitacoes")
    public String solicitacoes(Model model) {

        model.addAttribute("listaSolicitacoes", solicitacaoRepository.findAll());
        return "home/solicitacoes/index";

    }

    @GetMapping("/solicitacoes/cadastro")
    public String novaSolicitacao(@ModelAttribute("solicitacao") Solicitacao solicitacao) {
        return "home/solicitacoes/form";
    }

    @GetMapping("/solicitacoes/{id}")
    public String alterarSolicitacao(@PathVariable("id") long id, Model model){

        Optional<Solicitacao> solicitacaoOptional = solicitacaoRepository.findById(id);

        if (solicitacaoOptional.isEmpty()) {
            throw new IllegalArgumentException("Essa solicitação não existe!");
        }

        model.addAttribute("solicitacao", solicitacaoOptional.get());
        return "home/solicitacoes/form";

    }

    @PostMapping("/solicitacoes/salvar")
    public String salvarSolicitacao(@ModelAttribute("solicitacao") Solicitacao solicitacao){
        solicitacaoRepository.save(solicitacao);
        return "redirect:/solicitacoes";
    }

    @GetMapping("/solicitacoes/excluir/{id}")
    public String deletarSolicitacao(@PathVariable("id") long id){
        Optional<Solicitacao> solicitacaoOptional = solicitacaoRepository.findById(id);

        if (solicitacaoOptional.isEmpty()) {
            throw new IllegalArgumentException("Essa solicitação não existe!");
        }

        solicitacaoRepository.delete(solicitacaoOptional.get());
        return "redirect:/solicitacoes";
    }

}
