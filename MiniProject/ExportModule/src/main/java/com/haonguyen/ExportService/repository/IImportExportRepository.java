package com.haonguyen.ExportService.repository;


import com.mini_project.CoreModule.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IImportExportRepository extends JpaRepository<ImportExportEntity, UUID> {
    @Query(value = "Select e from ImportExportEntity e " +
            "where e.countryEntity.id = :idCountry")
    List<ImportExportEntity> getExportByCountry(@Param("idCountry") UUID idCountry);

    ImportExportEntity getById(UUID idExport);

    @Query(value = "select e from WarehouseCommodityEntity e " +
            " where e.idCommodity = :idCommodity and e.idWarehouse = :idWarehouse")
    WarehouseCommodityEntity checkInventory(@Param("idCommodity") UUID idCommodity
                                            ,@Param("idWarehouse") UUID idWarehouse);
    @Query(value = "select e from CountryEntity e where e.id = :idCountry")
    CountryEntity getCountryById(@Param("idCountry") UUID idCountry);

    @Query(value = "select e from WarehouseEntity e where e.id = :idWarehouse")
    WarehouseEntity getWarehouseByID(@Param("idWarehouse") UUID idWarehouse);

    @Query(value = "select e from ImportExportEntity e where" +
            " month(e.date) = :month" +
            " and year(e.date) = :year" +
            " and e.type = 1")
    List<ImportExportEntity> getByMonthAndYear(@Param("month") Integer month,
                                               @Param("year") Integer year);
}
