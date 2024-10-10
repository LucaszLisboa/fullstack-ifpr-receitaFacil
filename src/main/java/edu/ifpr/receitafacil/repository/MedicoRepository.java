package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
  
}
