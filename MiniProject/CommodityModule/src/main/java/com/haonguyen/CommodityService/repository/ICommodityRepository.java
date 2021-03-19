package com.haonguyen.CommodityService.repository;

<<<<<<< HEAD
import com.haonguyen.CommodityService.Entity.CheckWarehouseCommodity;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.WarehouseCommodityEntity;
=======
import com.mini_project.CoreModule.entity.CommodityEntity;
>>>>>>> origin/develop
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ICommodityRepository extends JpaRepository<CommodityEntity,UUID> {
    @Query(value = "SELECT c FROM CommodityEntity c where c.id_sectors=?1")
    List<CommodityEntity> findCommodityById_Sectors(UUID id_sectors);

    @Query(value ="SELECT c FROM CommodityEntity c where c.commodity_name like trim(:key) " )
    List<CommodityEntity> searchCommodity(String key);

    @Query(value = "select wa.warehouse_name,co.commodity_name,wc.inventoryNumber " +
            "from WarehouseCommodityEntity wc " +
            "inner join CommodityEntity co on wc.id_commodity=co.id " +
            "inner join WarehouseEntity wa on wc.id_warehouse = wa.id " +
            "where wc.inventoryNumber > 0 " +
            "order by wa.warehouseName asc")
    List<CheckWarehouseCommodity> CommodityInWarehouse();
}
