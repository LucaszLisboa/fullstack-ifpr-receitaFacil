package edu.ifpr.receitafacil.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dispensacaoMedicamento_tb")
@Entity
public class DispensacaoMedicamento implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToOne
  private Receita receita;

  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private java.util.Date dataDispensacao;

  @Column
  private Integer quantidadeDispensada;

  @Column
  private String farmaceuticoResponsavel;
  
}
