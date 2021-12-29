package org.converter.servise;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.converter.model.Deposit;

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

    private Map<Integer, Deposit> depoMap = new HashMap();

    public ConvertToExel(Map<Integer, Deposit> depositMap, String filePath) {
        this.depoMap = depositMap;
        this.filePath = filePath;
        initMap();
    }

    private void initMap() {
        this.stringMap.put(1, "ID");
        this.stringMap.put(2, "Date");
        this.stringMap.put(3, "Type");
        this.stringMap.put(4, "Sender ID");
        this.stringMap.put(5, "Sender Name");
        this.stringMap.put(6, "Recipient ID");
        this.stringMap.put(7, "Recipient Name");
        this.stringMap.put(8, "Amount");
        this.stringMap.put(9, "Fee");
        this.stringMap.put(10, "Currency");
    }

    /**
     * Метод проводит парсинг данных в формат Exel
     */
    public void convertToEl() {
        XSSFWorkbook workbook = new XSSFWorkbook(); // создание книги
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java"); // создание страницы

        CellStyle style;
        DataFormat format = workbook.createDataFormat();

        int width = 15; // Where width is number of caracters
        sheet.setDefaultColumnWidth(width);

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
        }

        for (var datatype : depoMap.values()) {
            Row row = sheet.createRow(rowNum++); // строка
            int colNum = 0;
            sheet.autoSizeColumn((short) 1);

            Cell cell = row.createCell(colNum++); // ячейка
            CellStyle style0 = workbook.createCellStyle();
            CreationHelper createHelper0 = workbook.getCreationHelper();
            style0.setDataFormat(createHelper0.createDataFormat().getFormat("0"));
            cell.setCellStyle(style0);
            cell.setCellValue(datatype.getId());

            Cell cell1 = row.createCell(colNum++); // ячейка
            style = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            style.setDataFormat(createHelper.createDataFormat().getFormat("dd.MM.yy HH:mm:ss"));
            cell1.setCellValue(timeRevers(datatype.getDate(), datatype.getTime()));
            cell1.setCellStyle(style);


            Cell cellT = row.createCell(colNum++); // ячейка
            CellStyle style1 = workbook.createCellStyle();
            CreationHelper createHelper1 = workbook.getCreationHelper();
            style1.setDataFormat(createHelper1.createDataFormat().getFormat("General"));
            cellT.setCellStyle(style1);
            cellT.setCellValue(datatype.getType());

            Cell cell3 = row.createCell(colNum++); // ячейка
            CellStyle style3 = workbook.createCellStyle();
            CreationHelper createHelper3 = workbook.getCreationHelper();
            style3.setDataFormat(createHelper0.createDataFormat().getFormat("0"));
            cell3.setCellStyle(style3);
            cell3.setCellValue(datatype.getSender().getId());

            Cell cell4 = row.createCell(colNum++); // ячейка
            CellStyle style4 = workbook.createCellStyle();
            CreationHelper createHelper4 = workbook.getCreationHelper();
            style4.setDataFormat(createHelper0.createDataFormat().getFormat("General"));
            cell4.setCellStyle(style4);
            cell4.setCellValue(datatype.getSender().getName());

            Cell cell5 = row.createCell(colNum++); // ячейка
            CellStyle style5 = workbook.createCellStyle();
            CreationHelper createHelper5 = workbook.getCreationHelper();
            style5.setDataFormat(createHelper1.createDataFormat().getFormat("0"));
            cell5.setCellStyle(style5);
            cell5.setCellValue(datatype.getRecipient().getId());

            Cell cell6 = row.createCell(colNum++); // ячейка
            CellStyle style6 = workbook.createCellStyle();
            CreationHelper createHelper6 = workbook.getCreationHelper();
            style6.setDataFormat(createHelper1.createDataFormat().getFormat("General"));
            cell6.setCellStyle(style6);
            cell6.setCellValue(datatype.getRecipient().getName());

            Cell cell7 = row.createCell(colNum++); // ячейка
            CellStyle style7 = workbook.createCellStyle();
            CreationHelper createHelper7 = workbook.getCreationHelper();
            style7.setDataFormat(createHelper7.createDataFormat().getFormat("0.00"));
            cell7.setCellStyle(style7);
            cell7.setCellValue(datatype.getAmount());

            Cell cell8 = row.createCell(colNum++); // ячейка
            CellStyle style8 = workbook.createCellStyle();
            CreationHelper createHelper8 = workbook.getCreationHelper();
            style8.setDataFormat(createHelper8.createDataFormat().getFormat("0.00"));
            cell8.setCellStyle(style8);
            cell8.setCellValue(datatype.getFee());

            Cell cell9 = row.createCell(colNum++); // ячейка
            CellStyle style9 = workbook.createCellStyle();
            CreationHelper createHelper9 = workbook.getCreationHelper();
            style9.setDataFormat(createHelper9.createDataFormat().getFormat("General"));
            cell9.setCellStyle(style9);
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
