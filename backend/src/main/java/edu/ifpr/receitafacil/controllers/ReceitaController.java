package edu.ifpr.receitafacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifpr.receitafacil.model.Receita;
import edu.ifpr.receitafacil.services.ReceitaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

  @Autowired
  ReceitaService receitaService;

  public ReceitaController(ReceitaService receitaService) {
    super();
    this.receitaService = receitaService;
  }

  @PostMapping
  public ResponseEntity<Object> cadastrar(@RequestBody Receita receita) {
    try {
      receitaService.cadastrarReceita(receita);
      return ResponseEntity.ok(receita);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
