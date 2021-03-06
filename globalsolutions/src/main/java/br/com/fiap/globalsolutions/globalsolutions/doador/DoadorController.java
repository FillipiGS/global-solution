package br.com.fiap.globalsolutions.globalsolutions.doador;

import br.com.fiap.globalsolutions.globalsolutions.solicitacao.SolicitacaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DoadorController {

    private DoadorRepository doadorRepository;

    public DoadorController(DoadorRepository doadorRepository){
        this.doadorRepository = doadorRepository;
    }

    @GetMapping("/doadores")
    public String doadores(Model model) {
        model.addAttribute("listaDoadores", doadorRepository.findAll());
        return "home/doadores/perfil";
    }

    @GetMapping("/doadores/cadastro")
    public String novoDoador(@ModelAttribute("doador") Doador doador) {
        return "home/doadores/form";
    }

    @GetMapping("/doadores/{id}")
    public String alterarDoador(@PathVariable("id") long id, Model model){

        Optional<Doador> doadorOptional = doadorRepository.findById(id);

        if (doadorOptional.isEmpty()) {
            throw new IllegalArgumentException("Esse doador não existe!");
        }

        model.addAttribute("doador", doadorOptional.get());
        return "home/doadores/form";

    }

    @PostMapping("/doadores/salvar")
    public String salvarDoador(@ModelAttribute("doador") Doador doador){
        doadorRepository.save(doador);
        return "redirect:/pedidos";
    }

    @GetMapping("/doadores/excluir/{id}")
    public String deletarDoador(@PathVariable("id") long id){
        Optional<Doador> doadorOptional = doadorRepository.findById(id);

        if (doadorOptional.isEmpty()) {
            throw new IllegalArgumentException("Esse doador não existe!");
        }

        doadorRepository.delete(doadorOptional.get());
        return "redirect:/doadores";
    }

}
