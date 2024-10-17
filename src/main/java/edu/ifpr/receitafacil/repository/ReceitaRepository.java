package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
  
    @Query("SELECT r FROM Receita r WHERE r.paciente.id = :idPaciente")
    public Receita findByPacienteId(Integer idPaciente);
}
