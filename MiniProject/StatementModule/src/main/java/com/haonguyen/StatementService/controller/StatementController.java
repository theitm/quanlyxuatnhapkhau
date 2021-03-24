package com.haonguyen.StatementService.controller;

import com.haonguyen.StatementService.dto.InfoExportAPI;
import com.haonguyen.StatementService.service.IExportExcelService;
import com.haonguyen.StatementService.service.IStatementService;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("v1/api/statement")
public class StatementController {
    private final IExportExcelService iExportExcelService;
    private final IStatementService iStatementService;

    public StatementController(IExportExcelService iExportExcelService, IStatementService iStatementService) {
        this.iExportExcelService = iExportExcelService;
        this.iStatementService = iStatementService;
    }

    @RequestMapping(value = "/test/{monthAndYear}",method = RequestMethod.GET)
    public InfoExportAPI[] test(@PathVariable("monthAndYear") String monthAndYear){
        return iStatementService.getInfoExportAPI(monthAndYear);
    }

    @GetMapping("/details/excel")
    public void ExportDetailsImEx(HttpServletResponse response) throws IOException {
        iExportExcelService.export(response);
    }
}
