package edu.ifpr.receitafacil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifpr.receitafacil.model.Receita;
import edu.ifpr.receitafacil.repository.ReceitaRepository;

@Service
public class ReceitaService {

  @Autowired
  ReceitaRepository receitaRepository;

  public ReceitaService(ReceitaRepository receitaRepository) {
    super();
    this.receitaRepository = receitaRepository;
  }

  public void cadastrarReceita(Receita receita) {
    // Colocar validações aqui caso necessário
    // para criar receita no banco de dados, precisa ter um paciente, médico, uma lista de medicamentos, data de envio e assinatura digital
    
    receitaRepository.save(receita);
  }
}
