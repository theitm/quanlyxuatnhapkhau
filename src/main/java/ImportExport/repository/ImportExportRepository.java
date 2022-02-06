package ImportExport.repository;

import ImportExport.entity.CountryEntity;
import ImportExport.entity.ImportExportEntity;
import ImportExport.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImportExportRepository extends JpaRepository<ImportExportEntity, UUID> {
    @Query(value = "select c from CountryEntity c where c.id = :id")
    CountryEntity findByIdCountry(@Param("id") UUID id);
    @Query(value = "SELECT w FROM WarehouseEntity w WHERE w.id = :id")
    WarehouseEntity findByIdWarehouse(@Param("id") UUID id);
    @Query(value = "select w FROM WarehouseEntity w")
    List<WarehouseEntity> findAllWarehouse();

}
