package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.entity.DetailsI_exportEntity;
import com.haonguyen.ServiceImport.repository.DetailsIexportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DetailsIexportService {

    public DetailsI_exportEntity saveDetailsIexport(DetailsI_exportEntity detailsIExportEntity);

    public List<DetailsI_exportEntity> getAllDetailsReceipt();

    public List<String> findIdCommodityByIdI_Export(String idI_Export);

    public List<DetailsI_exportEntity> findAllDetailsReceiptByIdI_Export(String idI_Export);

}
