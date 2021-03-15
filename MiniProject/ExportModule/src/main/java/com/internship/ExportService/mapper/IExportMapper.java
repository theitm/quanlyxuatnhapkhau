package com.internship.ExportService.mapper;

import com.internship.ExportService.DTO.ExportDTO;
import com.mini_project.CoreModule.entity.Import_ExportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IExportMapper {
    @Mapping(source = "id",target = "id")

    ExportDTO mapToExportDTO(Import_ExportEntity importExportEntity);
}
