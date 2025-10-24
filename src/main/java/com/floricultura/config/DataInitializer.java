package com.floricultura.config;

import com.floricultura.model.Usuario;
import com.floricultura.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner criarUsuarioMaster(UsuarioRepository usuarioRepository) {
        return args -> {
            if (!usuarioRepository.existsByTipoUsuario("master")) {
                Usuario master = new Usuario();
                master.setNome("adm");
                master.setEmail("adm@floricultura.com");
                master.setSenha("adm123");
                master.setCpf("000.000.000-00");
                master.setTelefone("(00) 00000-0000");
                master.setRua("Rua ADM");
                master.setBairro("Centro");
                master.setCidade("São Paulo");
                master.setEstado("SP");
                master.setCep("00000-000");
                master.setNumero("0");
                master.setComplemento("Conta mestre do sistema");
                master.setTipoUsuario("master");

                usuarioRepository.save(master);
                System.out.println("✅ Usuário MASTER criado com sucesso!");
            }
        };
    }
}
