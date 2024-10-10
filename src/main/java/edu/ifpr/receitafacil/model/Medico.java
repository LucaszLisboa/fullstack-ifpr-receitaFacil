package edu.ifpr.receitafacil.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medico extends Usuario implements Serializable {

  @Column
  private String crm;
  @Column
  private String assinaturaDigital;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
  private List<Receita> receitas;
}
