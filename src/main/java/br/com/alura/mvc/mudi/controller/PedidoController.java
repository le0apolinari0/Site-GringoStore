package br.com.alura.mvc.mudi.controller;
import javax.validation.Valid;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;



@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PedidoRepository pedidoRepository;


    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return "pedido/formulario";
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User usuario= userRepository.findByUserName(username);
        Pedido pedido = requisicao.toPedido();
        pedido.setUser(usuario);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
