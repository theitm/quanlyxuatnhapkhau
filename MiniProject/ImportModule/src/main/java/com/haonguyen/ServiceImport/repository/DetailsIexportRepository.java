package com.haonguyen.ServiceImport.repository;

import com.haonguyen.ServiceImport.entity.DetailsI_exportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsIexportRepository extends JpaRepository<DetailsI_exportEntity, String> {

    @Query(value = "select id_commodity from mini_project_db2.tb_details_iexport where id_iexport = :idI_Export", nativeQuery = true)
    List<String> findIdCommodityByIdI_ExportQuery(@Param("idI_Export") String idI_Export);

    @Query(value = "select * from mini_project_db2.tb_details_iexport where id_iexport = :idI_Export", nativeQuery = true)
    List<DetailsI_exportEntity> findAllByIdI_Export(@Param("idI_Export") String idI_Export);
}
