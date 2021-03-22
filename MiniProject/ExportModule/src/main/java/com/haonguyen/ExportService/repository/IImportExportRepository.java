package com.haonguyen.ExportService.repository;


import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;
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

}
