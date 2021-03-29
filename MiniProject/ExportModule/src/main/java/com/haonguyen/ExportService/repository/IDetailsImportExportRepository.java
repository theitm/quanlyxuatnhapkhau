package com.haonguyen.ExportService.repository;

import com.haonguyen.ExportService.dto.QuantityUsingInImport;
import com.haonguyen.ExportService.dto.SourceExportDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDetailsImportExportRepository extends JpaRepository<DetailsImportExportEntity, UUID> {

    @Query(value = "select e from DetailsImportExportEntity e " +
            " where e.idCommodity = :idCommodity ")
    List<DetailsImportExportEntity> checkIdCommodity(@Param("idCommodity") UUID idCommodity);

    List<DetailsImportExportEntity> findByIdImportExport(UUID idImportExport);

    @Query(value = "select de " +
            " from DetailsImportExportEntity de" +
            " inner join ImportExportEntity ie on ie.id = de.idImportExport " +
            " where ie.type = 1 and" +
            " de.idCommodity = :idCommodity")
    List<DetailsImportExportEntity> findImportByIdCommodity(UUID idCommodity);

    @Query(value = "select new com.haonguyen.ExportService.dto.QuantityUsingInImport(" +
            " de.refIdExport,de.idCommodity,de.idImportExport,sum(de.quantity) ) " +
            " from DetailsImportExportEntity de" +
            " where de.refIdExport = :idRefExport")
    QuantityUsingInImport getQuantityUsingInImport(@Param("idRefExport") UUID idRefExport);

    @Query(value = "select die.refIdExport from DetailsImportExportEntity die" +
            " where idImportExport = :idExport")
    List<UUID> findRefIdByIdExport(@Param("idExport") UUID idExport);

    @Query(value = "select new com.haonguyen.ExportService.dto.SourceExportDTO( " +
            " ie.id , die.idCommodity , die.quantity, " +
            " cou.countryName , wa.warehouseName)" +
            " from ImportExportEntity as ie" +
            " inner join CountryEntity cou" +
            " on cou.id = ie.idCountry" +
            " inner join WarehouseEntity as wa" +
            " on wa.id = ie.idWarehouse" +
            " inner join DetailsImportExportEntity die" +
            " on die.idImportExport = ie.id" +
            " where ie.type = 1 and die.id = :refId")
    SourceExportDTO sourceExport(@Param("refId") UUID uuid);
}
