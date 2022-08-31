package com.revitalize.admincontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdmRevitalizeDto {

  @NotBlank
  private String nomeCliente;
  @NotBlank
  @Size(max = 13)
  private String cnpjCliente;
  @NotBlank
  private String tipoAtividade;
  @NotBlank
  private String contatoResponsavel;
  @NotBlank
  private String emailAtual;
  @NotBlank
  private String statusCadastro;

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
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
}
