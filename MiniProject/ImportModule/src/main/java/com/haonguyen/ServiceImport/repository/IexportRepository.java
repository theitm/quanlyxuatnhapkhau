package com.haonguyen.ServiceImport.repository;

import com.haonguyen.ServiceImport.dto.WarehouseDTO;
import com.haonguyen.ServiceImport.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IexportRepository extends JpaRepository<I_exportEntity, UUID> {

    @Query(value = "select distinct ie.id_iexport, ie.id_country, ie.id_warehouse, ie.date_receipt, ie.type\n" +
            " from tb_iexport as ie\n" +
            "inner join tb_details_iexport as de on ie.id_iexport = de.id_iexport\n" +
            "inner join tb_warehouse as wa on ie.id_warehouse = wa.id_warehouse\n" +
            "inner join tb_commodity as co on de.id_commodity = co.id_commodity\n" +
            "where concat(wa.warehouse_name, '', co.commodity_name)\n" +
            "like %?1%", nativeQuery = true)
    List<I_exportEntity> searchI_exportQuery(String key);

    @Query(value = "SELECT new com.haonguyen.ServiceImport.dto.WarehouseEntityDTO(w.idWarehouse, w.warehouseName, w.description, w.capacity) FROM WarehouseEntity w WHERE w.warehouseName = :name")
    WarehouseDTO findByWarehouseNameDTO(@Param("name") String name);


//    CountryEntityDTO findByCountryNameIgnoreCase(String name);
//
//    @Query(value = "SELECT tb from tb_warehouse_commodity as tb WHERE tb.id_warehouse = :idWarehouse AND tb.id_commodity = :idCommodity ", nativeQuery = true)
//    List<CommodityWarehouseDTO> findAllCommodityWarehouseEntitiesQuery(@Param("idWarehouse") String idWarehouse, @Param("idCommodity") String idCommodity);
//
//    CommodityEntity findByCommodityNameIgnoreCase(String name);
}
