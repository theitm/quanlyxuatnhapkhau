package com.haonguyen.StatementService.service;

import com.haonguyen.StatementService.dto.InfoExportAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StatementService implements IStatementService{


    private final RestTemplate restTemplate;

    public StatementService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public InfoExportAPI[] getInfoExportAPI(String monthAndYear){
        return  restTemplate
                .getForObject("http://localhost:8112/v1/api/export/getExcel/"+ monthAndYear,
                InfoExportAPI[].class);
    }
    public List<InfoExportAPI> test(){
        InfoExportAPI[] infoExportAPI = getInfoExportAPI("12&20");
        return null;
    }
}
