package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.dto.WarehouseCommodityDTO;
import com.haonguyen.ServiceImport.repository.WarehouseCommodityRepository;
import com.haonguyen.ServiceImport.service.ImportExportService;
import com.haonguyen.ServiceImport.service.WarehouseCommodityService;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseCommodityServiceImpl implements WarehouseCommodityService {

    private final WarehouseCommodityRepository warehouseCommodityRepository;
    private final ImportExportService importExportService;

    public WarehouseCommodityServiceImpl(WarehouseCommodityRepository warehouseCommodityRepository,
                                         ImportExportService importExportService) {
        this.warehouseCommodityRepository = warehouseCommodityRepository;
        this.importExportService = importExportService;
    }

    /**
     * Method save into WarehouseCommodityEntity if in database no data
     * update if there is data
     *
     * @param warehouseCommodityEntityList
     * @param importExportEntityNew
     * @return warehouseCommodityEntity
     */
    @Override
    public WarehouseCommodityEntity save(List<WarehouseCommodityEntity> warehouseCommodityEntityList, ImportExportEntity importExportEntityNew) throws SaveException {
        try {
            WarehouseCommodityEntity warehouseCommodityEntity = null;
            for (WarehouseCommodityEntity listWarehouseCommodity : warehouseCommodityEntityList) {
                List<WarehouseCommodityEntity> listWarehouseCommodityByIdImExport
                        = importExportService
                        .findWarehouseCommodityByIdWarehouseIdCommodity(listWarehouseCommodity.getIdWarehouse(), listWarehouseCommodity.getIdCommodity());
                if (listWarehouseCommodityByIdImExport.size() == 0) {
                    warehouseCommodityEntity = warehouseCommodityRepository.save(listWarehouseCommodity);
                }
                if (listWarehouseCommodityByIdImExport.size() > 0) {
                    Double ST = 0.0;
                    for (WarehouseCommodityEntity listWarehouseCommodityTwoId : listWarehouseCommodityByIdImExport) {
                        listWarehouseCommodity.setId(listWarehouseCommodityTwoId.getId());
                        ST = listWarehouseCommodityTwoId.getInventoryNumber() + listWarehouseCommodity.getInventoryNumber();
                    }
                    listWarehouseCommodity.setInventoryNumber(ST);
                    warehouseCommodityEntity = warehouseCommodityRepository.save(listWarehouseCommodity);
                }
            }
            return warehouseCommodityEntity;
        } catch (Exception exception) {
            throw new SaveException("Save Error At WarehouseCommodityEntity Please Try Again");
        }
    }

    /**
     * method create WarehouseCommodity from warehouseCommodityDTO
     *
     * @param warehouseCommodityDTO
     * @return warehouseCommodityEntityList
     */
    @Override
    public List<WarehouseCommodityEntity> getFromWarehouseCommodityDTO(WarehouseCommodityDTO warehouseCommodityDTO) {
        List<WarehouseCommodityEntity> warehouseCommodityEntityList = new ArrayList<>();

        List<ItemReceiptDTO> itemReceiptDTOList = warehouseCommodityDTO.getItemReceiptDTOS().stream().collect(Collectors.toList());

        List<DetailsImportExportEntity> commodityList = warehouseCommodityDTO.getCommodityEntities().stream().collect(Collectors.toList());

        for (ItemReceiptDTO listItem : itemReceiptDTOList) {
            for (DetailsImportExportEntity listCommodity : commodityList) {
                if (listItem.getIdCommodity().equals(listCommodity.getCommodityEntity().getId())) {
                    WarehouseCommodityEntity warehouseCommodityEntity = WarehouseCommodityEntity.builder()
                            .id(null)
                            .idCommodity(listCommodity.getIdCommodity())
                            .idWarehouse(warehouseCommodityDTO.getIdWarehouse().getId())
                            .commodityEntity(listCommodity.getCommodityEntity())
                            .warehouseEntity(warehouseCommodityDTO.getIdWarehouse())
                            .inventoryNumber(listCommodity.getQuantity())
                            .build();

                    warehouseCommodityEntityList.add(warehouseCommodityEntity);
                }
            }
        }

        return warehouseCommodityEntityList;
    }
}
