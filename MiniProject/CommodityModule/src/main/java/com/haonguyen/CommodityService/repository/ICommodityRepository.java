package com.haonguyen.CommodityService.repository;


import com.haonguyen.CommodityService.dto.CommodityInWarehouseDto;
import com.haonguyen.CommodityService.dto.CommoditySearchDto;
import com.haonguyen.CommodityService.dto.TypeAndTaxCommodityAPI;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ICommodityRepository extends JpaRepository<CommodityEntity,UUID> {
    @Query(value = "SELECT c FROM CommodityEntity c where c.idTypeOfCommodity=?1")
    List<CommodityEntity> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity);

//    tim kiem da dieu kien
    @Query(value ="SELECT new com.haonguyen.CommodityService.dto.CommoditySearchDto(c.commodityName,c.description,c.price,c.unit,c.idTypeOfCommodity) " +
            "FROM CommodityEntity c " +
            "inner join TypeOfCommodityEntity tc on c.idTypeOfCommodity=tc.id " +
            "where concat(c.commodityName,' ',tc.typeName,' ',c.price,' ') like trim('%',:key, '%') " )
    List<CommoditySearchDto> searchCommodity(String key);

    @Query(value ="SELECT new com.haonguyen.CommodityService.dto.CommoditySearchDto(c.commodityName,c.description,c.price,c.unit,c.idTypeOfCommodity) " +
            "from CommodityEntity c " )
    List<CommoditySearchDto> findAllSearchCommodity();
//

    @Query(value = "select new com.haonguyen.CommodityService.dto.CommodityInWarehouseDto(co.commodityName,wa.warehouseName,wc.inventoryNumber) " +
            "from WarehouseCommodityEntity wc " +
            "inner join CommodityEntity co on wc.idCommodity=co.id " +
            "inner join WarehouseEntity wa on wc.idWarehouse = wa.id " +
            "where wc.inventoryNumber > 0 " +
            "order by wa.warehouseName asc")
    List<CommodityInWarehouseDto> CommodityInWarehouse();

    @Query(value = "SELECT new com.haonguyen.CommodityService.dto.TypeAndTaxCommodityAPI(" +
            " ty.id,ty.typeName," +
            " co.id,co.commodityName,co.price,co.unit," +
            " tax.id,tax.taxBracketName,tax.coefficient) " +
            " FROM CommodityEntity co" +
            " inner join TypeOfCommodityEntity ty" +
            " on co.idTypeOfCommodity = ty.id" +
            " inner join TaxBracketEntity tax" +
            " on tax.id = ty.idTaxBracket" +
            " where co.id = :idCommodity" )
    TypeAndTaxCommodityAPI getTypeTaxCommodity(@Param(value = "idCommodity") UUID idCommodity);

    @Query(value = "SELECT w FROM WarehouseCommodityEntity w " +
            "Where w.idCommodity=?1")
    WarehouseCommodityEntity checkCommodityInWarehouseById(UUID id);

    @Query(value = "select e from CommodityEntity e " +
            " where e.id = :idCommodity ")
    CommodityEntity checkIdCommodity(@Param("idCommodity") UUID idCommodity);
}
