package com.floricultura.controller;

import com.floricultura.model.Funcionario;
import com.floricultura.model.Usuario;
import com.floricultura.repository.FuncionarioRepository;
import com.floricultura.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String realizarLogin(String email, String senha, HttpSession session, RedirectAttributes ra) {

        Funcionario funcionario = funcionarioRepository.findByEmailAndSenha(email, senha);
        if (funcionario != null) {
            session.setAttribute("usuarioLogado", funcionario);
            session.setAttribute("tipo", "funcionario");
            return "redirect:/pagina-funcionario";
        }

        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            session.setAttribute("tipo", "usuario");
            return "inicio"; // página inicial normal
        }

        ra.addFlashAttribute("erro", "E-mail ou senha inválidos!");
        return "redirect:/login";
    }
}
