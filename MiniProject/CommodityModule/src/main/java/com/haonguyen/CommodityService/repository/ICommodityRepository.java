package com.haonguyen.CommodityService.repository;

import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ICommodityRepository extends JpaRepository<CommodityEntity,UUID> {
//    CommodityEntity findCommodityById(UUID id);

//    CommodityEntity findCommodityById(UUID id);

//    List<CommodityEntity> findCommodityById_Sectors(UUID id_Sectors);
}
