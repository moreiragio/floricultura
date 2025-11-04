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

import java.util.Optional;

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

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            session.setAttribute("usuarioLogado", usuario);

            if ("master".equals(usuario.getTipoUsuario())) {
                session.setAttribute("tipo", "master");
                return "admin/paginaAdmin";
            } else {
                session.setAttribute("tipo", "usuario");
                return "inicio";
            }
        }

        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByEmailAndSenha(email, senha);
        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            session.setAttribute("usuarioLogado", funcionario);
            session.setAttribute("tipo", "funcionario");
            return "flores";
        }

        ra.addFlashAttribute("erro", "E-mail ou senha inválidos!");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
