package com.internship.ExportService.service;

import com.internship.ExportService.DTO.ExportDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;



public interface IExportService {

    ExportDTO getExport(UUID id);
}
