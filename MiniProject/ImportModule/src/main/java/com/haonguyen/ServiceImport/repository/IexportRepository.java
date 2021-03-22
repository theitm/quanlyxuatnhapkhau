package com.haonguyen.ServiceImport.repository;

import com.mini_project.CoreModule.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface IexportRepository extends JpaRepository<ImportExportEntity, UUID> {

    @Query( "select distinct ie from ImportExportEntity ie " +
            "inner join DetailsImportExportEntity de on ie.id = de.idImportExport " +
            "inner join WarehouseEntity wa on ie.idWarehouse = wa.id " +
            "inner join CommodityEntity co on de.idCommodity = co.id " +
            "inner join CountryEntity cou on ie.idCountry = cou.id " +
            "where (wa.warehouseName like trim('%',:key,'%') and ie.date = :date)" +
            "or (co.commodityName like trim('%',:key,'%') and ie.date = :date)" +
            "or (cou.countryName like trim('%',:key,'%') and ie.date = : date)")
    List<ImportExportEntity> searchI_exportQueryIgnoreCase(@Param("key") String key, @Param("date") Date date);

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

    List<ImportExportEntity> findAllByDate(Date date);


    @Query(value = "select distinct waco from WarehouseCommodityEntity waco " +
            "inner join ImportExportEntity ie on waco.idWarehouse = ie.idWarehouse " +
            "inner join DetailsImportExportEntity de on waco.idCommodity = de.idCommodity " +
            "Where ie.idWarehouse = :idWarehouse and de.idCommodity = :idCommodity")
    List<WarehouseCommodityEntity> findWarehouseCommodityByIdImportExport(@Param("idWarehouse") UUID idWarehouse, @Param("idCommodity") UUID idCommodity);


}
