package com.revitalize.admincontrol.services;

import com.revitalize.admincontrol.models.AdmRevitalizeModel;
import com.revitalize.admincontrol.repositories.AdmRevitalizeRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdmRevitalizeService {

  final AdmRevitalizeRepository admRevitalizeRepository;

  public AdmRevitalizeService(AdmRevitalizeRepository admRevitalizeRepository){
    this.admRevitalizeRepository = admRevitalizeRepository;
  }
@Transactional
  public AdmRevitalizeModel save(AdmRevitalizeModel admRevitalizeModel){
    return admRevitalizeRepository.save(admRevitalizeModel);
  }

  public boolean existsByCnpjCliente(String cnpjCliente) {
    return admRevitalizeRepository.existsByCnpjCliente(cnpjCliente);
  }

  public List<AdmRevitalizeModel> findALL() {
    return admRevitalizeRepository.findAll();
  }
  public Optional<AdmRevitalizeModel> findById(UUID id){
    return admRevitalizeRepository.findById(id);
  }
@Transactional
  public void delete(AdmRevitalizeModel admRevitalizeModel) {
    admRevitalizeRepository.delete(admRevitalizeModel);
  }
}
