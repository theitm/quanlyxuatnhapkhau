package com.internship.ExportService.mapper;

import com.internship.ExportService.DTO.ExportDTO;
import com.mini_project.CoreModule.entity.Import_ExportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IExportMapper {
    ExportDTO toExportDTO(Import_ExportEntity importExportEntity);
}
