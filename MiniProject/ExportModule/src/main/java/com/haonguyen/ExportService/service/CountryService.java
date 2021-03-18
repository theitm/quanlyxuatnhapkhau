package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.repository.ICountryRepository;
import com.mini_project.CoreModule.entity.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final ICountryRepository iCountryRepository;

    public CountryService(ICountryRepository iCountryRepository) {
        this.iCountryRepository = iCountryRepository;
    }

    public List<CountryEntity> getCountries() {
        return iCountryRepository.findAll();
    }
}
