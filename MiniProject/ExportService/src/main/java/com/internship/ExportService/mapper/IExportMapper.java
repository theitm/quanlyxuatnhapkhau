package com.internship.ExportService.mapper;


import com.internship.ExportService.DTO.ExportDTO;
import com.mini_project.CoreModule.entity.Import_ExportEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ExportMapper {
    ExportDTO toExportDTO(Import_ExportEntity importExportEntity);
}
