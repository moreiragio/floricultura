package com.floricultura.service;

import com.floricultura.model.Funcionario;
import com.floricultura.repository.FuncionarioRepository;
import com.floricultura.repository.UsuarioRepository;
import com.floricultura.repository.MasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final MasterRepository masterRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository,
                              UsuarioRepository usuarioRepository,
                              MasterRepository masterRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.masterRepository = masterRepository;
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public boolean existeEmail(String email) {
        return funcionarioRepository.existsByEmail(email)
                || usuarioRepository.existsByEmail(email)
                || masterRepository.existsByEmail(email);
    }

    public boolean existeCpf(String cpf) {
        return funcionarioRepository.existsByCpf(cpf)
                || usuarioRepository.existsByCpf(cpf)
                || masterRepository.existsByCpf(cpf);
    }

    public boolean existeTelefone(String telefone) {
        return funcionarioRepository.existsByTelefone(telefone)
                || usuarioRepository.existsByTelefone(telefone)
                || masterRepository.existsByTelefone(telefone);
    }

    public void atualizar(Funcionario funcionario) {
        Funcionario existente = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        existente.setNome(funcionario.getNome());
        existente.setEmail(funcionario.getEmail());
        existente.setTelefone(funcionario.getTelefone());
        existente.setCep(funcionario.getCep());
        existente.setRua(funcionario.getRua());
        existente.setNumero(funcionario.getNumero());
        existente.setBairro(funcionario.getBairro());
        existente.setCidade(funcionario.getCidade());
        existente.setEstado(funcionario.getEstado());
        existente.setComplemento(funcionario.getComplemento());
        existente.setDataNascimento(funcionario.getDataNascimento());

        if (funcionario.getSenha() != null && !funcionario.getSenha().isBlank()) {
            existente.setSenha(funcionario.getSenha());
        }

        funcionarioRepository.save(existente);
    }

}
