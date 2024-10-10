package edu.ifpr.receitafacil.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "paciente_tb")
@Entity
public class Paciente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private String nome;

  @Column
  private java.util.Date dataNascimento;

  @Column
  private String cpf;

  @Column
  private String PlanoSaude;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
  private List<Receita> receitas;
}