package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.dto.excel.ExcelDetailsExportDTO;
import com.haonguyen.ExportService.mapper.IDetailsExportMapper;
import com.haonguyen.ExportService.repository.IDetailsImportExportRepository;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DetailsImportExportService implements IDetailsImportExportService {

    private final IDetailsImportExportRepository iDetailsImportExportRepository;
    private final RestTemplate restTemplate;
    private final IDetailsExportMapper iDetailsExportMapper;

    public DetailsImportExportService(IDetailsImportExportRepository iDetailsImportExportRepository,
                                      RestTemplate restTemplate,
                                      IDetailsExportMapper iDetailsExportMapper) {
        this.iDetailsImportExportRepository = iDetailsImportExportRepository;
        this.restTemplate = restTemplate;
        this.iDetailsExportMapper = iDetailsExportMapper;
    }

    /**
     * Lấy thông tin liên quan đến hàng hóa thông qua API gọi đến service CommodityModule
     *
     * @param idCommodity
     * @return thông tin vừa lấy
     */
    private ApiInfoCommodity getApiAllCommodityInfo(UUID idCommodity) {
        return restTemplate
                .getForObject("http://localhost:9002/v1/api/commodity/getTypeTax/" + idCommodity
                        ,ApiInfoCommodity.class);
    }

    /**
     * Lưu thông tin chi tiết của phiếu nhập vào csdl
     *
     * @param detailsImportExportEntity
     * @return trả về thông tin vừa lưu
     */
    private DetailsExportDTO addDetailsExport(DetailsImportExportEntity detailsImportExportEntity) {
        return iDetailsExportMapper.toDetailsExportDTO(iDetailsImportExportRepository.save(detailsImportExportEntity));
    }

    /**
     * Tìm kiếm thông tin các hàng xuất khẩu được lấy từ những nguồn nhập khẩu nào
     *
     * @param idExport
     * @return Danh sách thông tin nguồn hàng
     */
    @Override
    public List<SourceExportDTO> sourceExport(UUID idExport) {
        List<UUID> uuids = iDetailsImportExportRepository.findRefIdByIdExport(idExport);
        SourceExportDTO sourceExportDTO;
        List<SourceExportDTO> sourceExportDTOS = new ArrayList<>();
        for (UUID uuid : uuids) {
            sourceExportDTO = iDetailsImportExportRepository.sourceExport(uuid);
            sourceExportDTOS.add(sourceExportDTO);
        }
        return sourceExportDTOS;
    }

    /**
     * Thêm thông tin hàng hóa vào phiếu xuất
     *
     * @param insertDataExportDTO
     * @return Danh sách hàng hóa vừa nhập vào
     */
    @Override
    public List<DetailsExportDTO> infoDetailsExport(InsertDataExportDTO insertDataExportDTO) {

        ApiInfoCommodity apiInfoCommodity;
        List<DetailsExportDTO> detailsExportDTOList = new ArrayList<>();

        for (DetailsExportDTO temp : insertDataExportDTO.getDetailsExportDTOList()) {

            apiInfoCommodity = getApiAllCommodityInfo(temp.getIdCommodity());

            double total = temp.getQuantity() * apiInfoCommodity.getCommodityPrice();
            total = total + total * (apiInfoCommodity.getCoefficient() % 100);

            // lấy tất cả các phiếu nhập chứa loại hàng hóa này
            List<DetailsExportDTO> detailsExportDTOList1 = findImportByIdCommodity(temp.getIdCommodity());

            // xem so luong da su dung cua tung phieu nhap
            for (DetailsExportDTO temp1 : detailsExportDTOList1) {
                QuantityUsingInImport quantityUsingInImport = getQuantityUsingInImport(temp1.getId());
                if (quantityUsingInImport.getIdImport() == null) {
                    if (temp1.getQuantity() > temp.getQuantity()) {
                        DetailsExportDTO detailsExportDTO = addDetailsExport(
                                DetailsImportExportEntity.builder()
                                        .idImportExport(insertDataExportDTO.getId())
                                        .idCommodity(temp.getIdCommodity())
                                        .quantity(temp.getQuantity())
                                        .total(total)
                                        .refIdExport(temp1.getId())
                                        .build());
                        detailsExportDTOList.add(detailsExportDTO);
                        break;
                    }
                } else {
                    if (temp1.getQuantity() - quantityUsingInImport.getQuantityTaken() > temp.getQuantity()) {
                        DetailsExportDTO detailsExportDTO = addDetailsExport(
                                DetailsImportExportEntity.builder()
                                        .idImportExport(insertDataExportDTO.getId())
                                        .idCommodity(temp.getIdCommodity())
                                        .quantity(temp.getQuantity())
                                        .total(total)
                                        .refIdExport(quantityUsingInImport.getIdRefExport())
                                        .build());
                        detailsExportDTOList.add(detailsExportDTO);
                        break;
                    }
                }
            }
        }
        return detailsExportDTOList;
    }

    @Override
    public Boolean checkIdCommodity(UUID idCommodity) {
        List<DetailsImportExportEntity> detailsImportExportEntities
                = iDetailsImportExportRepository.checkIdCommodity(idCommodity);
        if (detailsImportExportEntities.size() == 0)
            return true;
        return false;
    }

    @Override
    public List<ExcelDetailsExportDTO> findByIdImportExport(UUID idImportExport) {

        //Get tất cả danh sách theo Id Export
        List<DetailsImportExportEntity> detailsImportExportEntities
                = iDetailsImportExportRepository.findByIdImportExport(idImportExport);

        List<ExcelDetailsExportDTO> excelDetailsExportDTOS = new ArrayList<>();
        ApiInfoCommodity apiInfoCommodity;

        for (DetailsImportExportEntity temp : detailsImportExportEntities) {

            apiInfoCommodity = getApiAllCommodityInfo(temp.getIdCommodity());

            excelDetailsExportDTOS.add(ExcelDetailsExportDTO
                    .builder()
                    .idCommodity(temp.getIdCommodity())
                    .commodityName(apiInfoCommodity.getCommodityName())
                    .typeOfCommodityName(apiInfoCommodity.getTypeOfCommodityName())
                    .price(apiInfoCommodity.getCommodityPrice())
                    .total(temp.getTotal())
                    .quantity(temp.getQuantity())
                    .build());
        }
        return excelDetailsExportDTOS;
    }


    @Override
    public List<DetailsExportDTO> findImportByIdCommodity(UUID idCommodity) {
        List<DetailsImportExportEntity> list = iDetailsImportExportRepository.findImportByIdCommodity(idCommodity);
        return iDetailsExportMapper.toDetailsExportDTOs(list);
    }

    public QuantityUsingInImport getQuantityUsingInImport(UUID idRefExport) {
        return iDetailsImportExportRepository.getQuantityUsingInImport(idRefExport);
    }

}
