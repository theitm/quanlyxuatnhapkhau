package com.internship.ExportService.repository;

import com.mini_project.CoreModule.entity.Import_ExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IExportRepository extends JpaRepository<Import_ExportEntity, UUID> {
}
