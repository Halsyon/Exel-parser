package org.converter.servise;

import lombok.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.converter.model.Deposit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс конвертирует данный из хранилица данных объектов POJO в EXEL файл по указанному адресу,
 * имя файла EXEL дата и время его создания
 */
@Data
public class ConvertToExel {

    private String filePath = null;

    private int colNum;

    private Map<Integer, String> stringHashMap = new HashMap<>();

    private Map<Integer, String> stringMap = new HashMap<>();

    private Map<Integer, Deposit> depositMap = new HashMap();

    public ConvertToExel(Map<Integer, Deposit> depositMap, String filePath) {
        this.depositMap = depositMap;
        this.filePath = filePath;
        initMap();
        initArrayType();
    }

    /**
     * Метод проводит парсинг данных в формат Exel
     */
    public void convertToEl() {
        XSSFWorkbook workbook = new XSSFWorkbook(); // создание книги
        XSSFSheet sheet = workbook.createSheet("Datatype in Java"); // создание страницы

        CellStyle style;
        DataFormat format = workbook.createDataFormat();

        int width = 15;
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

        Row row1 = sheet.createRow(rowNum++); // строка

        for (int i = 1; i < stringMap.size() + 1; i++) {
            Cell cell = row1.createCell(i - 1); // ячейка
            cell.setCellValue(stringMap.get(i));
            cell.setCellStyle(headerCellStyle);
        }

        var map2 = onOrderDate(depositMap);

        for (var datatype : map2.values()) {
            Row row = sheet.createRow(rowNum++); // строка
            colNum = 0;
            Cell cell = createCell(row, colNum, workbook, stringHashMap);
            cell.setCellValue(datatype.getId());
            Cell cell1 = createCell(row, colNum, workbook, stringHashMap);
            cell1.setCellValue(timeRevers(datatype.getDate(), datatype.getTime()));
            Cell cell2 = createCell(row, colNum, workbook, stringHashMap);
            cell2.setCellValue(datatype.getType());
            Cell cell3 = createCell(row, colNum, workbook, stringHashMap);
            cell3.setCellValue(datatype.getSender().getId());
            Cell cell4 = createCell(row, colNum, workbook, stringHashMap);
            cell4.setCellValue(datatype.getSender().getName());
            Cell cell5 = createCell(row, colNum, workbook, stringHashMap);
            cell5.setCellValue(datatype.getRecipient().getId());
            Cell cell6 = createCell(row, colNum, workbook, stringHashMap);
            cell6.setCellValue(datatype.getRecipient().getName());
            Cell cell7 = createCell(row, colNum, workbook, stringHashMap);
            cell7.setCellValue(datatype.getAmount());
            Cell cell8 = createCell(row, colNum, workbook, stringHashMap);
            cell8.setCellValue(datatype.getFee());
            Cell cell9 = createCell(row, colNum, workbook, stringHashMap);
            cell9.setCellValue(datatype.getCurrency().getLabel());
        }

        sizeSheet(sheet);

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

    /**
     * Метод производит создание ячейки(Cell cell) и задает тип согласно задания
     * @param row строка
     * @param colN номер ячеки
     * @param workbook Книга
     * @param stringMap Map values type cell
     * @return
     */
    private Cell createCell(Row row, int colN, Workbook workbook, Map<Integer, String> stringMap) {
        Cell cell = row.createCell(colNum++);
        CellStyle style0 = workbook.createCellStyle();
        CreationHelper createHelper0 = workbook.getCreationHelper();
        style0.setDataFormat(createHelper0.createDataFormat().getFormat(stringMap.get(colNum)));
        cell.setCellStyle(style0);
        return cell;
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

    private void initArrayType() {
        this.stringHashMap.put(1, "0");
        this.stringHashMap.put(2, "dd.MM.yy HH:mm:ss");
        this.stringHashMap.put(3, "General");
        this.stringHashMap.put(4, "0");
        this.stringHashMap.put(5, "General");
        this.stringHashMap.put(6, "0");
        this.stringHashMap.put(7, "General");
        this.stringHashMap.put(8, "0.00");
        this.stringHashMap.put(9, "0.00");
        this.stringHashMap.put(10, "General");
    }

    /**
     * метод конвертирует время
     * к формату yyyy-MM-dd__HH-mm - паттерн имени файла.
     *
     * @return
     */
    private String convertT() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String rsl = null;
        var t = localDateTime.toString().split("T");
        var y = t[1].split(":");
        rsl = t[0] + "__" + y[0] + "-" + y[1];
        return rsl;
    }

    /**
     * метод проводит изминение поряд отображения даты
     *
     * @param one дата/date
     * @param two время/time
     * @return datetime string
     */
    private String timeRevers(String one, String two) {
        String rsl = null;
        var t = one.split("-");
        var y = t[0].substring(2);
        rsl = t[2] + "-" + t[1] + "-" + y + "  " + two;
        return rsl;
    }

    /**
     * меттод задает размер форматирования для всех столбцов документа Exel
     * poi.apache.org - usermodel /  Sheet.html#autoSizeColumn-int-boolean-
     *
     * @param sheet
     */
    private void sizeSheet(XSSFSheet sheet) {
        for (int i = 0; i < stringMap.size(); i++) {
            sheet.autoSizeColumn(i, true);
        }
    }

    public List<String> port(List<String> datestring) {
        datestring.sort(new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd-MM-yy  hh:mm:ss");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o1).compareTo(f.parse(o2));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return datestring;
    }

    /**
     * метод осуществляет упорядочевание списка Объектов передаваемых в Exel по дате время
     *
     * @param map Объектов для парсинга в Exel file
     * @return Map<Integer, Deposit> onOrder dateTime
     */
    private Map<Integer, Deposit> onOrderDate(Map<Integer, Deposit> map) {

        Map<Integer, Deposit> rsl = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        for (Deposit depo : map.values()) {
            stringList.add(timeRevers(depo.getDate(), depo.getTime()));
        }
        stringList = port(stringList);
        System.out.println(stringList);

        for (int i = 0; i < stringList.size(); i++) {
            for (Deposit reto : map.values()) {
                if (stringList.get(i).equals(timeRevers(reto.getDate(), reto.getTime()))) {
                    rsl.put(i + 1, reto);
                }
            }
        }
        return rsl;
    }
}
