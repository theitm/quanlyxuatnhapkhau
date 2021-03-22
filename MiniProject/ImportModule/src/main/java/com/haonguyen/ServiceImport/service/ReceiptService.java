package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.http.ResponseEntity;


public interface ReceiptService {

    ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO);

    CommodityEntity getCommodityEntityFromCommodityDto(ItemReceiptDTO list);

}
