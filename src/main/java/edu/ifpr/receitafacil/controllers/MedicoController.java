package edu.ifpr.receitafacil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.receitafacil.model.Medico;
import edu.ifpr.receitafacil.services.MedicoService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        super();
        this.medicoService = medicoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable int id){
        try {
            Medico medico = medicoService.findById(id);
            return new ResponseEntity<Medico>(medico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Medico>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{crm}")
    public ResponseEntity<Medico> buscarPorCrm(@PathVariable String crm){
        try {
            Medico medico = medicoService.findByCrm(crm);
            return new ResponseEntity<Medico>(medico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Medico>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Medico>> listar(){
        try {
            List<Medico> medicos = medicoService.findAllMedicos();
            return ResponseEntity.ok(medicos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody Medico medico) {
        try {
            medicoService.cadastrarMedico(medico);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/salvar")
    public ResponseEntity<Medico> salvar(@RequestBody Medico medico) {
        try {
            medicoService.atualizarMedico(medico);
            return new ResponseEntity<Medico>(medico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Medico>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id) {
        try {
            medicoService.excluirMedico(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
