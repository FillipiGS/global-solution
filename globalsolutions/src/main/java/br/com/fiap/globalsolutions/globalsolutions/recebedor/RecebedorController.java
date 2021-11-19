package br.com.fiap.globalsolutions.globalsolutions.recebedor;

import br.com.fiap.globalsolutions.globalsolutions.solicitacao.Solicitacao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RecebedorController {

    private RecebedorRepository recebedorRepository;

    public RecebedorController(RecebedorRepository recebedorRepository){
        this.recebedorRepository = recebedorRepository;
    }

    @GetMapping("/recebedores")
    public String recebedores(Model model){
        model.addAttribute("listaRecebedores", recebedorRepository.findAll());
        return "home/recebedores/index";
    }

    @GetMapping("/recebedores/cadastro")
    public String novoRecebedor(@ModelAttribute("recebedor") Recebedor recebedor) {
        return "home/recebedores/form";
    }

    @GetMapping("/recebedores/{id}")
    public String alterarRecebedor(@PathVariable("id") long id, Model model){

        Optional<Recebedor> recebedorOptional = recebedorRepository.findById(id);

        if (recebedorOptional.isEmpty()) {
            throw new IllegalArgumentException("Essa instituição não existe!");
        }

        model.addAttribute("recebedor", recebedorOptional.get());
        return "home/recebedores/form";
    }

    @PostMapping("/recebedores/salvar")
    public String salvarRecebedor(@ModelAttribute("recebedor") Recebedor recebedor){
        recebedorRepository.save(recebedor);
        return "redirect:/recebedores";
    }

    @GetMapping("/recebedores/excluir/{id}")
    public String deletarRecebedor(@PathVariable("id") long id){
        Optional<Recebedor> recebedorOptional = recebedorRepository.findById(id);

        if (recebedorOptional.isEmpty()) {
            throw new IllegalArgumentException("Essa instituição não existe!");
        }

        recebedorRepository.delete(recebedorOptional.get());
        return "redirect:/recebedores";
    }

}
