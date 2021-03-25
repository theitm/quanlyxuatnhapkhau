package com.haonguyen.ServiceImport.repository;

import com.mini_project.CoreModule.entity.CountryEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;
import com.mini_project.CoreModule.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ImportExportRepository extends JpaRepository<ImportExportEntity, UUID> {

    @Query("select distinct ie from ImportExportEntity ie " +
            "inner join DetailsImportExportEntity de on ie.id = de.idImportExport " +
            "inner join WarehouseEntity wa on ie.idWarehouse = wa.id " +
            "inner join CommodityEntity co on de.idCommodity = co.id " +
            "inner join CountryEntity cou on ie.idCountry = cou.id " +
            "where " +
            "(wa.warehouseName like trim('%',:key,'%') " +
            "or co.commodityName like trim('%',:key,'%') " +
            "or cou.countryName like trim('%',:key,'%')) " +
            "and (:date is null or ie.date = :date)")
    List<ImportExportEntity> searchImportExportQueryIgnoreCase(@Param("key") String key,
                                                               @Param("date") Date date);

    @Query(value = "SELECT w FROM WarehouseEntity w WHERE w.id = :id")
    WarehouseEntity findByIdWarehouse(@Param("id") UUID id);

    @Query(value = "select c from CountryEntity c where c.id = :id")
    CountryEntity findByIdCountry(@Param("id") UUID id);

    @Query(value = "select w FROM WarehouseEntity w")
    List<WarehouseEntity> findAllWarehouse();


    List<ImportExportEntity> findAllByDate(Date date);


    @Query(value = "select distinct waco from WarehouseCommodityEntity waco " +
            "inner join ImportExportEntity ie on waco.idWarehouse = ie.idWarehouse " +
            "inner join DetailsImportExportEntity de on waco.idCommodity = de.idCommodity " +
            "Where ie.idWarehouse = :idWarehouse and de.idCommodity = :idCommodity")
    List<WarehouseCommodityEntity> findWarehouseCommodityByIdWarehouseIdCommodity(@Param("idWarehouse") UUID idWarehouse,
                                                                                  @Param("idCommodity") UUID idCommodity);


}
