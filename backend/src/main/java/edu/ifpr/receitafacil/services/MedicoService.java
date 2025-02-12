package edu.ifpr.receitafacil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.receitafacil.model.Medico;
import edu.ifpr.receitafacil.repository.MedicoRepository;
import edu.ifpr.receitafacil.repository.ReceitaRepository;

@Service
public class MedicoService {
    
    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    ReceitaRepository receitaRepository;

    public void cadastrarMedico(Medico medico) {
        if( 
            medico.getNome() == null || medico.getNome().isEmpty() || 
            medico.getCrm() == null || medico.getCrm().isEmpty()) {

            throw new IllegalArgumentException("Nome e CRM são obrigatórios");
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

    // public Receita criarReceita(Medico medico, Paciente paciente, List<Medicamento> medicamentos, String dataEnvio, String assinaturaDigital) {
    //     Receita receita = new Receita();
    //     receita.setMedico(medico);
    //     receita.setPaciente(paciente);
    //     receita.setMedicamentos(medicamentos);
    //     receita.setDataEnvio(dataEnvio);
    //     receita.setAssinaturaDigital(assinaturaDigital);
    //     return receita;
    // }


}
