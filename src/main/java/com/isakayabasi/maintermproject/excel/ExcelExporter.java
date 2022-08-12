package com.isakayabasi.maintermproject.excel;

import com.isakayabasi.maintermproject.model.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Result> listResult;

    public ExcelExporter(List<Result> listResult){
        this.listResult=listResult;
        workbook = new XSSFWorkbook();

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell=row.createCell(columnCount);
        if (value instanceof Long){
            cell.setCellValue((Long)value);
        }else if (value instanceof Integer){
            cell.setCellValue((Integer)value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeHeaderLine(){
        sheet=workbook.createSheet("Result");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Result Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        font.setFontHeightInPoints((short) (10));

        row=sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row,0,"Result Id", style);
//        createCell(row,1,"Result totalCorrect", style);
        createCell(row,1,"Result Satisfaction", style);
        createCell(row,2,"      Result messageId     ", style);
        createCell(row,3,"Result username", style);
        createCell(row,4,"   Result email     ", style);
    }

    private void writeDataLines(){
        int rowCount=2;

        CellStyle style= workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Result res:listResult){
            Row row=sheet.createRow(rowCount++);
            int columnCount=0;
            createCell(row,columnCount++,res.getId(),style);
//            createCell(row,columnCount++,res.getTotalCorrect(),style);
            createCell(row,columnCount++,res.getSatisfaction(),style);
            createCell(row,columnCount++,res.getMessageId(),style);
            createCell(row,columnCount++,res.getUsername(),style);
            createCell(row,columnCount++,res.getEmail(),style);
        }
    }

    public void  export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
