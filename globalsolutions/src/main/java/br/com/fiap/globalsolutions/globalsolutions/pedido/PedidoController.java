package br.com.fiap.globalsolutions.globalsolutions.pedido;

import br.com.fiap.globalsolutions.globalsolutions.doador.Doador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PedidoController {

    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model){
        model.addAttribute("listaPedidos", pedidoRepository.findAll());
        return "home/doadores/perfil";
    }

    @GetMapping("/pedidos/cadastro")
    public String novoPedido(@ModelAttribute("pedido") Pedido pedido) {
        return "home/solicitacoes/form";
    }

    @GetMapping("/pedidos/{id}")
    public String alterarPedido(@PathVariable("id") long id, Model model){

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isEmpty()) {
            throw new IllegalArgumentException("Esse pedido não existe!");
        }

        model.addAttribute("pedido", pedidoOptional.get());
        return "home/solicitacoes/form";
    }

    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@ModelAttribute("pedido") Pedido pedido){
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/excluir/{id}")
    public String deletarPedido(@PathVariable("id") long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isEmpty()) {
            throw new IllegalArgumentException("Esse doador não existe!");
        }

        pedidoRepository.delete(pedidoOptional.get());
        return "redirect:/pedidos";
    }


}
