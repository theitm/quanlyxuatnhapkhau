package com.haonguyen.ExportService.repository;

import com.mini_project.CoreModule.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, UUID> {
}
