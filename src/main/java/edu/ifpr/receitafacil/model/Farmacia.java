package edu.ifpr.receitafacil.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "farmacia_tb")
@Entity
public class Farmacia  extends Usuario implements Serializable {

  @Column
  private String cnpj;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private Date dataAcesso;
}
