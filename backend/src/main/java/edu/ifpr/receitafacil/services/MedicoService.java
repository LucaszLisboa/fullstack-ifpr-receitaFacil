package edu.ifpr.receitafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.receitafacil.model.Medico;
import edu.ifpr.receitafacil.repository.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    MedicoRepository medicoRepository;

    public void cadastrarMedico(Medico medico) {
        // Colocar validações aqui caso necessário
        if(medico.getNome() == null || medico.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do médico não pode ser vazio");
        }
        medicoRepository.save(medico);
    }

    public void atualizarMedico(Medico medico) {
        if(medico.getId() == null|| medico.getId().equals(0)) {
            cadastrarMedico(medico);
        }
        medicoRepository.save(medico);
    }

    public void excluirMedico(int idMedico) {
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));
        medicoRepository.delete(medico);
    }

    public List<Medico> findAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico findById(int idMedico) {
        return medicoRepository.findById(idMedico).orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));
    }

    public Medico findByCrm(String crm) {
        return medicoRepository.findByCrm(crm);
    }


}
