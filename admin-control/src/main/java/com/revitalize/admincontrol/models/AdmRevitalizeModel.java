package com.revitalize.admincontrol.models;
//DEPENDENCIAS
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//CRIANDO UMA IDENTIDADE OBJETO DE BANCO DE DADOS
@Table(name="CADASTRO_EMPRESA")
public class AdmRevitalizeModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, length = 120)
  private String nomeCliente;
  @Column(nullable = false, unique = true, length = 13)
  private String cnpjCliente;
  @Column(nullable = false, length = 70)
  private String tipoAtividade;
  @Column(nullable = false, length = 120)
  private String contatoResponsavel;
  @Column(nullable = false, length = 100)
  private String emailAtual;
  @Column(nullable = false, length = 1)
  private String statusCadastro;
  @Column(nullable = false)
  private LocalDateTime dtCadastro;
  @Column(nullable = false)
  private LocalDateTime dtAlteracao;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeClinete) {
    this.nomeCliente = nomeClinete;
  }

  public String getCnpjCliente() {
    return cnpjCliente;
  }

  public void setCnpjCliente(String cnpjCliente) {
    this.cnpjCliente = cnpjCliente;
  }

  public String getTipoAtividade() {
    return tipoAtividade;
  }

  public void setTipoAtividade(String tipoAtividade) {
    this.tipoAtividade = tipoAtividade;
  }

  public String getContatoResponsavel() {
    return contatoResponsavel;
  }

  public void setContatoResponsavel(String contatoResponsavel) {
    this.contatoResponsavel = contatoResponsavel;
  }

  public String getEmailAtual() {
    return emailAtual;
  }

  public void setEmailAtual(String emailAtual) {
    this.emailAtual = emailAtual;
  }

  public String getStatusCadastro() {
    return statusCadastro;
  }

  public void setStatusCadastro(String statusCadastro) {
    this.statusCadastro = statusCadastro;
  }

  public LocalDateTime getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(LocalDateTime dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

  public LocalDateTime getDtAlteracao() {
    return dtAlteracao;
  }

  public void setDtAlteracao(LocalDateTime dtAlteracao) {
    this.dtAlteracao = dtAlteracao;
  }
}