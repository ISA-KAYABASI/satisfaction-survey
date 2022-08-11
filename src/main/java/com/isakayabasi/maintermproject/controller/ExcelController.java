package com.isakayabasi.maintermproject.controller;

import com.isakayabasi.maintermproject.excel.ExcelExporter;
import com.isakayabasi.maintermproject.model.Result;
import com.isakayabasi.maintermproject.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private ResultRepo resultRepo;

    @GetMapping("download")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headervalue = "attachment; filename=Student_info.xlsx";

        response.setHeader(headerKey, headervalue);
        List<Result> listResult= resultRepo.findAll();
        ExcelExporter exp = new ExcelExporter(listResult);
        exp.export(response);

    }

}
