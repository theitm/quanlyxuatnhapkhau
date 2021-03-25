package com.haonguyen.ServiceImport.repository;

import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WarehouseCommodityRepository extends JpaRepository<WarehouseCommodityEntity, UUID> {

}
