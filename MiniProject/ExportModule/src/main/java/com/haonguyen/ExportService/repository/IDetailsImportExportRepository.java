package com.haonguyen.ExportService.repository;

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
            " where e.idCommodity = :idCommodity")
    DetailsImportExportEntity checkIdCommodity(@Param("idCommodity") UUID idCommodity);

    List<DetailsImportExportEntity> findByIdImportExport(UUID idImportExport);
}
