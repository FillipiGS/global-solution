package br.com.fiap.globalsolutions.globalsolutions.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EndPointsController {

    //PÁGINA INICIAL
    @GetMapping("/home")
    public String home(){
        return "home/index";
    }

    //PÁGINA CADASTRO
    @GetMapping("/cadastro")
    public String cadastro(){
        return "home/form";
    }

    //LOGIN
    @GetMapping("/login")
    public String login(){
        return "home/login";
    }

}
