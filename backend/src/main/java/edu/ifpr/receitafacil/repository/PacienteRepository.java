package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p WHERE p.cpf = :cpf")
    public Paciente findByCpf(@Param("cpf") String cpf);
  
}
