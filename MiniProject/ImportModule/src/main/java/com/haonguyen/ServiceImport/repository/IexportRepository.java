package com.haonguyen.ServiceImport.repository;

import com.mini_project.Coremodule.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IexportRepository extends JpaRepository<Import_ExportEntity, UUID> {

    @Query( "select distinct ie from I_exportEntity ie " +
            "inner join DetailsI_exportEntity de on ie.id = de.id_iexport " +
            "inner join WarehouseEntity wa on ie.id_warehouse = wa.id " +
            "inner join CommodityEntity co on de.id_commodity = co.id " +
            "inner join CountryEntity cou on ie.id_country = cou.id " +
            "where (wa.warehouse_name like trim(:key))" +
            "or (co.commodity_name like trim(:key))" +
            "or (cou.country_name like trim(:key))")
    List<Import_ExportEntity> searchI_exportQueryIgnoreCase(@Param("key") String key);

    @Query(value = "SELECT w FROM WarehouseEntity w WHERE w.id = :id")
    WarehouseEntity findByIdWarehouse(@Param("id") UUID id);

    @Query(value = "select c from CountryEntity c where c.id = :id")
    CountryEntity findByIdCountry(@Param("id") UUID id);

    @Query(value = "select co from CommodityEntity co where co.id = :id")
    CommodityEntity findByIdCommodity(@Param("id") UUID id);

    @Query(value = "select w FROM WarehouseEntity w")
    List<WarehouseEntity> findAllWarehouse();

    @Query(value = "select d from DocumentEntity d")
    List<DocumentEntity> findAllDocument();

}
