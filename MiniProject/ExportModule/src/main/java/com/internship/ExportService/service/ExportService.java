package com.internship.ExportService.service;


import com.internship.ExportService.DTO.ExportDTO;
import com.internship.ExportService.mapper.IExportMapper;
import com.internship.ExportService.repository.IExportRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExportService implements IExportService  {
    private final IExportMapper exportMapper;
    private final IExportRepository iExportRepository;
    public ExportService(IExportMapper exportMapper, IExportRepository iExportRepository) {
        this.exportMapper = exportMapper;
        this.iExportRepository = iExportRepository;
    }
    public ExportDTO getExport(UUID id){
        return exportMapper.mapToExportDTO(iExportRepository.getOne(id));
    }
}
