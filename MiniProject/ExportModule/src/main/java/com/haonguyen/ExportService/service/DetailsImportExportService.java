package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.ApiAllCommodityInfo;
import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.FormInsertDataExport;
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

    public DetailsImportExportService(IDetailsImportExportRepository iDetailsImportExportRepository, RestTemplate restTemplate, IDetailsExportMapper iDetailsExportMapper) {
        this.iDetailsImportExportRepository = iDetailsImportExportRepository;
        this.restTemplate = restTemplate;
        this.iDetailsExportMapper = iDetailsExportMapper;
    }

    /**
     * Lấy thông tin liên quan đến hàng hóa thông qua API gọi đến service CommodityModule
     * @param idCommodity
     * @return
     */
    private ApiAllCommodityInfo getApiAllCommodityInfo(UUID idCommodity){
        return restTemplate
                .getForObject("http://localhost:9001/commodity/get-type-tax/" + idCommodity
                        ,ApiAllCommodityInfo.class);
    }

    /**
     * Lưu thông tin chi tiết của phiếu nhập vào csdl
     * @param detailsImportExportEntity
     * @return trả về thông tin vừa lưu
     */
    private DetailsExportDTO addDetailsExport(DetailsImportExportEntity detailsImportExportEntity){
        return iDetailsExportMapper.toDetailsExportDTO(iDetailsImportExportRepository.save(detailsImportExportEntity));
    }

    @Override
    public List<DetailsExportDTO> infoDetailsExport(FormInsertDataExport formInsertDataExport) {
        ApiAllCommodityInfo apiAllCommodityInfo;
        List<DetailsExportDTO> detailsExportDTOList = new ArrayList<>();
        double sumTotal = 0;

        for(DetailsExportDTO temp: formInsertDataExport.getDetailsExportDTOList()){

            apiAllCommodityInfo = getApiAllCommodityInfo(temp.getIdCommodity());

            // Gia  = (So luong * Gia)
            double total = temp.getQuantity() * apiAllCommodityInfo.getCommodityPrice();
            total = total + total * (apiAllCommodityInfo.getCoefficient()%100);

            detailsExportDTOList.add(addDetailsExport(
                   DetailsImportExportEntity
                    .builder()
                    .idImportExport(formInsertDataExport.getId())
                    .quantity(temp.getQuantity())
                    .total(total)
                    .idCommodity(temp.getIdCommodity())
                    .build()));
            sumTotal = sumTotal + total;

        }
        //Uoc tinh chi phi van chuyen


        //Tinh % thue nhap khau tai moi quoc gia ( tong tien + chi phi van chuyen)
       // sumTotal = sumTotal + sumTotal * (formInsertDataExport.get)

        return null;
    }
    @Override
    public Boolean checkIdCommodity(UUID idCommodity) {
        DetailsImportExportEntity detailsImportExportEntity = iDetailsImportExportRepository.checkIdCommodity(idCommodity);
        if(detailsImportExportEntity == null)
            return true;
        return false;
    }
}
