package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer> {
   
}
