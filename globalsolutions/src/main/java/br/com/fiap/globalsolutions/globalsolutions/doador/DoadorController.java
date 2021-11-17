package br.com.fiap.globalsolutions.globalsolutions.doador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoadorController {

    private DoadorRepository doadorRepository;

    public DoadorController(DoadorRepository doadorRepository){
        this.doadorRepository = doadorRepository;
    }

    @GetMapping("/doadores")
    public String doadores(Model model) {

        model.addAttribute("listaDoadores", doadorRepository.findAll());
        return "/doadores/index";

    }

    @GetMapping("/doadores/cadastro")
    public String novoDoador(@ModelAttribute("doador") Doador doador) {
        return "/doadores/form";
    }

    @PostMapping("/doadores/salvar")
    public String salvarDoador(@ModelAttribute("doador") Doador doador){
        doadorRepository.save(doador);
        return "redirect:/doadores";
    }

}
