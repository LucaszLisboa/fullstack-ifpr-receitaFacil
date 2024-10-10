package edu.ifpr.receitafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.receitafacil.model.ItemReceita;

@Repository
public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Integer> {
  
}
