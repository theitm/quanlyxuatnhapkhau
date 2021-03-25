package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.CustomErrorMessage.CommodityException;
import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.dto.KeySearchDTO;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ReceiptService {

    ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO) throws SaveException, CommodityException;

    CommodityEntity getCommodityEntityFromCommodityModule(ItemReceiptDTO list) throws Exception;

    List<ImportExportEntity> searchReceiptImportExport(KeySearchDTO keySearchDTO) throws Exception;

}
