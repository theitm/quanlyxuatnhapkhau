package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.repository.ISectorsEntity;
import com.mini_project.CoreModule.entity.TypeOfCommodityEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorsService {
    private final ISectorsEntity iSectorsEntity;

    public SectorsService(ISectorsEntity iSectorsEntity) {
        this.iSectorsEntity = iSectorsEntity;
    }

    public List<TypeOfCommodityEntity> getSectors() {
        return iSectorsEntity.findAll();
    }
}
