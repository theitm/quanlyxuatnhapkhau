package com.haonguyen.ExportService.mapper;

import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.DocumentDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDetailsExportMapper {

    DetailsExportDTO toDetailsExportDTO(DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsExportDTO> toDetailsExportDTOs(List<DetailsImportExportEntity> detailsImportExportEntities);
}
