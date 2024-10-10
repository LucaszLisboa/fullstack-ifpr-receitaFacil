package edu.ifpr.receitafacil.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "receita_tb")
@Entity
public class Receita implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "receita")
  private Paciente paciente;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "receita")
  private Medico medico;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "receita")
  private List<Medicamento> medicamentos;

  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private Date dataEnvio;

  @Column
  private String assinaturaDigital;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "receita")
  private DispensacaoMedicamento dispensacaoMedicamento;
}
