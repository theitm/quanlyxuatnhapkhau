package com.haonguyen.ServiceImport.repository;

import com.haonguyen.ServiceImport.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
    @Query(value = "select image_url from mini_project_db2.tb_document where id_iexport = :idI_Export", nativeQuery = true)
    List<String> findImageUrlByIdQuery(@Param("idI_Export") String idI_Export);
}
