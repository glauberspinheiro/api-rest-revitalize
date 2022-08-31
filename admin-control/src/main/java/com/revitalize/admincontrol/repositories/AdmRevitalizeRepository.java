package com.revitalize.admincontrol.repositories;

import com.revitalize.admincontrol.models.AdmRevitalizeModel;

import java.awt.print.Pageable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRevitalizeRepository extends JpaRepository<AdmRevitalizeModel, UUID> {

  boolean existsByCnpjCliente(String cnpjCliente);
}
