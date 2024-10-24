package edu.ifpr.receitafacil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Paciente>> listar() {
        try{
            List<Paciente> pacientes = pacienteService.findAllPacientes();
            return ResponseEntity.ok(pacientes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody Paciente paciente) {
        try {
            pacienteService.cadastrarPaciente(paciente);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/salvar")
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        try {
            pacienteService.atualizarPaciente(paciente);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestParam int idPaciente) {
        try {
            pacienteService.excluirPaciente(idPaciente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
