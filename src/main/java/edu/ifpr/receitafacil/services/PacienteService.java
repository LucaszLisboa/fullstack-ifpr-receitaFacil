package edu.ifpr.receitafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.receitafacil.model.Paciente;
import edu.ifpr.receitafacil.repository.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public void cadastrarPaciente(Paciente paciente) {
        // Colocar validações aqui caso necessário
        if(paciente.getNome() == null || paciente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do paciente não pode ser vazio");
        }
        pacienteRepository.save(paciente);
    }

    public void atualizarPaciente(Paciente paciente) {
        if(paciente.getId() == null|| paciente.getId().equals(0)) {
            cadastrarPaciente(paciente);
        }
        pacienteRepository.save(paciente);
    }

    public void excluirPaciente(int idPaciente) {
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
        pacienteRepository.delete(paciente);
    }

    public Paciente findById(int idPaciente) {
        return pacienteRepository.findById(idPaciente).orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
    }

    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente findByCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }


}
