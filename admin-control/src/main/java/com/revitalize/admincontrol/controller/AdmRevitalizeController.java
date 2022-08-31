package com.revitalize.admincontrol.controller;

import com.revitalize.admincontrol.dtos.AdmRevitalizeDto;
import com.revitalize.admincontrol.models.AdmRevitalizeModel;
import com.revitalize.admincontrol.services.AdmRevitalizeService;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/adm-revitalize")
public class AdmRevitalizeController {
  final AdmRevitalizeService admRevitalizeService;

  public AdmRevitalizeController(AdmRevitalizeService admRevitalizeService) {
    this.admRevitalizeService = admRevitalizeService;
  }
  @PostMapping
  public ResponseEntity<Object> saveAdmRevitalize(@RequestBody @Valid AdmRevitalizeDto admRevitalizeDto){

    if(admRevitalizeService.existsByCnpjCliente(admRevitalizeDto.getCnpjCliente())){
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CNPJ já está em uso");
    }

    var admRevitalizeModel = new AdmRevitalizeModel();
    BeanUtils.copyProperties(admRevitalizeDto, admRevitalizeModel);
    admRevitalizeModel.setDtCadastro(LocalDateTime.now(ZoneId.of("UTC")));
    admRevitalizeModel.setDtAlteracao(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(admRevitalizeService.save(admRevitalizeModel));
  }

  @GetMapping
  public ResponseEntity<List<AdmRevitalizeModel>> getAllAdmRevitalize(){
    return ResponseEntity.status(HttpStatus.OK).body(admRevitalizeService.findALL());
  }
  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneAdmRevitalize(@PathVariable(value = "id") UUID id){
    Optional<AdmRevitalizeModel> admRevitalizeModelOptional = admRevitalizeService.findById(id);
    if(!admRevitalizeModelOptional.isPresent()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }
    return ResponseEntity.status(HttpStatus.OK).body(admRevitalizeModelOptional.get());
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteAdmRevitalize(@PathVariable(value = "id") UUID id){
    Optional<AdmRevitalizeModel> admRevitalizeModelOptional = admRevitalizeService.findById(id);
    if(!admRevitalizeModelOptional.isPresent()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }
    admRevitalizeService.delete(admRevitalizeModelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado com sucesso!");
  }
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateAdmRevitalize(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid AdmRevitalizeDto admRevitalizeDto){
    Optional<AdmRevitalizeModel> admRevitalizeModelOptional = admRevitalizeService.findById(id);
    if(!admRevitalizeModelOptional.isPresent()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }
    var admRevitalizeModel = admRevitalizeModelOptional.get();

    admRevitalizeModel.setTipoAtividade(admRevitalizeDto.getTipoAtividade());
    admRevitalizeModel.setCnpjCliente(admRevitalizeDto.getCnpjCliente());
    admRevitalizeModel.setContatoResponsavel(admRevitalizeDto.getContatoResponsavel());
    admRevitalizeModel.setEmailAtual(admRevitalizeDto.getEmailAtual());
    admRevitalizeModel.setNomeCliente(admRevitalizeDto.getNomeCliente());
    admRevitalizeModel.setStatusCadastro(admRevitalizeDto.getStatusCadastro());
    admRevitalizeModel.setDtAlteracao(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.OK).body(admRevitalizeService.save(admRevitalizeModel));
  }

}
