package org.converter.servise;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.converter.model.Depo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс конвертирует данный из хранилица данных объектов POJO в EXEL файл по указанному адресу,
 * имя файла EXEL дата и время его создания
 */
public class ConvertToExel {

    private String filePath = null;

    private Map<Integer, String> stringMap = new HashMap<>();

    private Map<Integer, Depo> depoMap = new HashMap();

    public ConvertToExel(Map<Integer, Depo> depoMap, String filePath) {
        this.depoMap = depoMap;
        this.filePath = filePath;
        initMap();
    }

    private void initMap() {
        this.stringMap.put(1, "id");
        this.stringMap.put(2, "date_time");
        this.stringMap.put(3, "type");
        this.stringMap.put(4, "sender_id");
        this.stringMap.put(5, "sender name");
        this.stringMap.put(6, "recipient_id");
        this.stringMap.put(7, "recipient name");
        this.stringMap.put(8, "amount");
        this.stringMap.put(9, "fee");
        this.stringMap.put(10, "currency_label");
    }

    public void convertToEl() {
        XSSFWorkbook workbook = new XSSFWorkbook(); // создание книги
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java"); // создание страницы

// Create header CellStyle
        Font headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.BLACK.index);
        headerFont.setBold(true);
        CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW1.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);

        // Style the cell with borders and border color

        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        int rowNum = 0; //строка
        int colNum1 = 0;

        Row row1 = sheet.createRow(rowNum++); // строка

        for (int i = 1; i < stringMap.size() + 1; i++) {
            Cell cell = row1.createCell(i - 1); // ячейка
            cell.setCellValue(stringMap.get(i));
            cell.setCellStyle(headerCellStyle);
            cell.setCellStyle(headerCellStyle);

        }
        for (var datatype : depoMap.values()) {
            Row row = sheet.createRow(rowNum++); // строка
            int colNum = 0;

            Cell cell = row.createCell(colNum++); // ячейка

            cell.setCellValue(datatype.getId());
            Cell cell1 = row.createCell(colNum++); // ячейка
            sheet.autoSizeColumn(1);

            cell1.setCellValue(timeRevers(datatype.getDate(), datatype.getTime()));
            Cell cellT = row.createCell(colNum++); // ячейка

            cellT.setCellValue(datatype.getType());
            Cell cell3 = row.createCell(colNum++); // ячейка

            cell3.setCellValue(datatype.getSender().getId());
            Cell cell4 = row.createCell(colNum++); // ячейка

            cell4.setCellValue(datatype.getSender().getName());
            Cell cell5 = row.createCell(colNum++); // ячейка

            cell5.setCellValue(datatype.getRecipient().getId());
            Cell cell6 = row.createCell(colNum++); // ячейка

            cell6.setCellValue(datatype.getRecipient().getName());
            Cell cell7 = row.createCell(colNum++); // ячейка

            cell7.setCellValue(datatype.getAmount());
            Cell cell8 = row.createCell(colNum++); // ячейка

            cell8.setCellValue(datatype.getFee());
            Cell cell9 = row.createCell(colNum++); // ячейка
            cell9.setCellValue(datatype.getCurrency().getLabel());
        }

        String path = filePath + convertT() + ".xlsx";

        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertT() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String rsl = null;
        var t = localDateTime.toString().split("T");
        var y = t[1].split(":");
        rsl = t[0] + "_" + y[0] + "-" + y[1];
        return rsl;
    }

    private String timeRevers(String one, String two) {
        String rsl = null;
        var t = one.split("-");
        var y = t[0].substring(2);
        rsl = t[2] + "-" + t[1] + "-" + y + " " + two;
        return rsl;
    }

}
