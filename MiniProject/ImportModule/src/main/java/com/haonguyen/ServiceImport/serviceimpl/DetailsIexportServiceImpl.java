package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.entity.DetailsI_exportEntity;
import com.haonguyen.ServiceImport.repository.DetailsIexportRepository;
import com.haonguyen.ServiceImport.service.DetailsIexportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsIexportServiceImpl implements DetailsIexportService {

    @Autowired
    private DetailsIexportRepository detailsIexportRepository;

    public DetailsIexportServiceImpl() {
    }

    public DetailsI_exportEntity saveDetailsIexport(DetailsI_exportEntity detailsIExportEntity) {
        return detailsIexportRepository.saveAndFlush(detailsIExportEntity);
    }

    public List<DetailsI_exportEntity> getAllDetailsReceipt(){
        return detailsIexportRepository.findAll();
    }

    public List<String> findIdCommodityByIdI_Export(String idI_Export){
        return detailsIexportRepository.findIdCommodityByIdI_ExportQuery(idI_Export);
    }

    public List<DetailsI_exportEntity> findAllDetailsReceiptByIdI_Export(String idI_Export){
        return detailsIexportRepository.findAllByIdI_Export(idI_Export);
    }
}
