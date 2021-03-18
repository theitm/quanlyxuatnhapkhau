package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.repository.ICommodityRepository;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {


    private final ICommodityRepository iCommodityRepository;

    public CommodityService(ICommodityRepository iCommodityRepository) {
        this.iCommodityRepository = iCommodityRepository;
    }

    public List<CommodityEntity> getCommodities() {
        return iCommodityRepository.findAll();
    }

}
