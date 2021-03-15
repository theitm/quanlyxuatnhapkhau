package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface ReceiptService {

      ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO);

}
