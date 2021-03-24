package com.haonguyen.StatementService.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IExportExcelService {
    void export(HttpServletResponse response, String monthAndYear) throws IOException;
}
