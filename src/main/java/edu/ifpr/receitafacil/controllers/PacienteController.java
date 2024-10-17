package edu.ifpr.receitafacil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.receitafacil.model.Paciente;
import edu.ifpr.receitafacil.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        super();
        this.pacienteService = pacienteService;
    }
    
    @GetMapping("/listar")
    public List<Paciente> findAll() {
        return pacienteService.findAllPacientes();
    }

    @PutMapping("/salvar")
    public String salvar() {
        return "paciente/salvar";
    }

    @DeleteMapping("/excluir")
    public String excluir() {
        return "paciente/excluir";
    }

}
