package com.haonguyen.ServiceImport.repository;

import com.mini_project.Coremodule.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IexportRepository extends JpaRepository<I_exportEntity, UUID> {

    @Query( "select distinct ie\n" +
            " from I_exportEntity ie\n" +
            "inner join DetailsI_exportEntity de on ie.id = de.id_iexport\n" +
            "inner join WarehouseEntity wa on ie.id_warehouse = wa.id\n" +
            "inner join CommodityEntity co on de.id_commodity = co.id\n" +
            "inner join CountryEntity cou on ie.id_country = cou.id\n" +
            "where concat(wa.warehouse_name, '', co.commodity_name, '', cou.country_name)\n" +
            "like %?1%")
    List<I_exportEntity> searchI_exportQueryIgnoreCase(String key);

    @Query(value = "SELECT w FROM WarehouseEntity w WHERE w.id = :id")
    WarehouseEntity findByIdWarehouse(@Param("id") UUID id);

    @Query(value = "select c from CountryEntity c where c.id = :id")
    CountryEntity findByIdCountry(@Param("id") UUID id);

    @Query(value = "select co from CommodityEntity co where co.id = :id")
    CommodityEntity findByIdCommodity(@Param("id") UUID id);

    @Query(value = "select w FROM WarehouseEntity w")
    List<WarehouseEntity> findAllWarehouse();

}
