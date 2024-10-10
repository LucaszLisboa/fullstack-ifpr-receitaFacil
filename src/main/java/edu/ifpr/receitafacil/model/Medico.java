package edu.ifpr.receitafacil.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medico_tb")
@Entity
public class Medico extends Usuario implements Serializable {

  @Column
  private String crm;
  @Column
  private String assinaturaDigital;
}
