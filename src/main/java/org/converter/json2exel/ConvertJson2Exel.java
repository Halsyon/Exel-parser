package org.converter.json2exel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson2Exel {
    public static void main(String[] args) throws IOException {
        // Step 1: Read JSON File to List Objects
        String jsonStr = "[{\"id\":\"1\",\"name\":\"Jack Smith\",\"address\":\"Massachusetts\",\"age\":23},{\"id\":\"2\",\"name\":\"Adam Johnson\",\"address\":\"New York\",\"age\":27},{\"id\":\"3\",\"name\":\"Katherin Carter\",\"address\":\"Washington DC\",\"age\":26},{\"id\":\"4\",\"name\":\"Jack London\",\"address\":\"Nevada\",\"age\":33},{\"id\":\"5\",\"name\":\"Jason Bourne\",\"address\":\"California\",\"age\":36}]";

        List customers = convertJsonString2Objects(jsonStr);

        // Step 2: Convert Java List Objects to JSON File
        writeObjects2ExcelFile(customers, "customers.xlsx");
    }

    /**
     *
     * Convert JSON String to Java List Objects
     *
     * @param
     * @return
     */
    private static List convertJsonString2Objects(String jsonString){
        List customers = null;

        try {
            customers = new ObjectMapper().readValue(jsonString, new TypeReference(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    /**
     *
     * Write Java Object Lists to Excel File
     *
     * @param customers
     * @param filePath
     * @throws IOException
     */
    private static void writeObjects2ExcelFile(List customers, String filePath) throws IOException {
//        String[] COLUMNs = {"Id", "Name", "Address", "Age"};
//
//        Workbook workbook = new XSSFWorkbook();
//
//        CreationHelper createHelper = workbook.getCreationHelper();
//
//        Sheet sheet = workbook.createSheet("Customers");
//
//        Font headerFont = workbook.createFont();
//        headerFont.setBold(true);
//        headerFont.setColor(IndexedColors.BLUE.getIndex());
//
//        CellStyle headerCellStyle = workbook.createCellStyle();
//        headerCellStyle.setFont(headerFont);
//
//        // Row for Header
//        Row headerRow = sheet.createRow(0);
//
//        // Header
//        for (int col = 0; col < COLUMNs.length; col++) {
//            Cell cell = headerRow.createCell(col);
//            cell.setCellValue(COLUMNs[col]);
//            cell.setCellStyle(headerCellStyle);
//        }
//
//        // CellStyle for Age
//        CellStyle ageCellStyle = workbook.createCellStyle();
//        ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
//
//        int rowIdx = 1;
//        for (Customer customer : customers) {
//            Row row = sheet.createRow(rowIdx++);
//
//            row.createCell(0).setCellValue(customer.getId());
//            row.createCell(1).setCellValue(customer.getName());
//            row.createCell(2).setCellValue(customer.getAddress());
//
//            Cell ageCell = row.createCell(3);
//            ageCell.setCellValue(customer.getAge());
//            ageCell.setCellStyle(ageCellStyle);
//        }
//
//        FileOutputStream fileOut = new FileOutputStream(filePath);
//        workbook.write(fileOut);
//        fileOut.close();
//        workbook.close();
    }
}
