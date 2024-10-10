package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
  
}
