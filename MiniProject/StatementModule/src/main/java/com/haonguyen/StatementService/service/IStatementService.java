package com.haonguyen.StatementService.service;

import com.haonguyen.StatementService.dto.InfoExportAPI;

public interface IStatementService {
    InfoExportAPI[] getInfoExportAPI(String monthAndYear);
}
