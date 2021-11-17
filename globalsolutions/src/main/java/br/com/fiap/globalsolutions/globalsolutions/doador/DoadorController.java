package br.com.fiap.globalsolutions.globalsolutions.doador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
