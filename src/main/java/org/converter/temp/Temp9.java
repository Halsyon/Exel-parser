package org.converter.temp;

import io.github.millij.poi.ss.writer.SpreadsheetWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.converter.model.Depo;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Temp9 {

    private static final String FILE_NAME = "F:/ConvertExel/MySecondExcel.xlsx";

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Depo> depoMap = new HashMap();
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "id");
        stringMap.put(2, "date_time");
        stringMap.put(3, "type");
        stringMap.put(4, "sender_id");
        stringMap.put(5, "sender name");
        stringMap.put(6, "recipient_id");
        stringMap.put(7, "recipient name");
        stringMap.put(8, "amount");
        stringMap.put(9, "fee");
        stringMap.put(10, "currency_label");
        File file = new File("F:\\ConvertExel\\exampleTZ.json");
//        File file =  new File("F:\\ConvertExel\\tempJson.json");

        File fileX = new File("F:\\ConvertExel\\MySecondExcel.xlsx");
        String string = null;
        try (FileReader reader = new FileReader(file)) {
            // read the json file
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonObject = (JSONArray) jsonParser.parse(reader);
            var toJSONString = jsonObject.toJSONString();
            var arrJ = toJSONString.split("\\[");
            Arrays.stream(arrJ).forEach(System.out::println);
            System.out.println(arrJ.length);
            var arrH = arrJ[1].split("\\]");
            System.out.println(arrH[0]);

            String[] arrG = arrH[0].split("},\\{");
            System.out.println(arrG.length + " -> Length");
            Arrays.stream(arrG).forEach(System.out::println);

            ObjectMapper mapper = new ObjectMapper();
//            String jsonInString = "{'name' : 'mkyong'}";

//JSON from file to Object
//            Depo depo = mapper.readValue(new File("F:\\ConvertExel\\tempJson.json"), Depo.class);

//JSON from String to Object
            String string1 = null;
            for (int i = 0; i < arrG.length; i++) {
                if (i == 0) {
                    string1 = arrG[i] + "}";
                    System.out.println(string1 + " при нуле");

                }
                if (i == arrG.length - 1) {
                    string1 = "{" + arrG[i];
                    System.out.println(string1 + " в конце");
                }
                if (i != 0 && i != arrG.length - 1) {
                    string1 = "{" + arrG[i] + "}";
                    System.out.println(string1 + " середина");
                }
                Depo depo1 = mapper.readValue(string1, Depo.class);
                System.out.println(depo1);
                depoMap.put(depo1.getId(), depo1);
                System.out.println();
                string1 = null;
            }
            List<Depo> employees = new ArrayList<>();
            depoMap.values().stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* ---------*/
        XSSFWorkbook workbook = new XSSFWorkbook(); // создание книги
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java"); // создание страницы

        System.out.println(depoMap.size());
        System.out.println(stringMap.size());
        int rowNum = 0; //строка
        int colNum1 = 0;
        System.out.println("Creating excel");
        Row row1 = sheet.createRow(rowNum++); // строка
        for (int i = 1; i < stringMap.size() + 1; i++) {

            Cell cell = row1.createCell(i - 1); // ячейка
            cell.setCellValue((String) stringMap.get(i));

        }
        for (var datatype : depoMap.values()) {

            Row row = sheet.createRow(rowNum++); // строка
            int colNum = 0;

            Cell cell = row.createCell(colNum++); // ячейка
            cell.setCellValue((Integer) datatype.getId());
            Cell cell1 = row.createCell(colNum++); // ячейка
            cell1.setCellValue((String) datatype.getDate() + " " + datatype.getTime());
            Cell cellT = row.createCell(colNum++); // ячейка
            cellT.setCellValue((String) datatype.getType());
            Cell cell3 = row.createCell(colNum++); // ячейка
            cell3.setCellValue((Integer) datatype.getSender().getId());
            Cell cell4 = row.createCell(colNum++); // ячейка
            cell4.setCellValue((String) datatype.getSender().getName());
            Cell cell5 = row.createCell(colNum++); // ячейка
            cell5.setCellValue((Integer) datatype.getRecipient().getId());
            Cell cell6 = row.createCell(colNum++); // ячейка
            cell6.setCellValue((String) datatype.getRecipient().getName());
            Cell cell7 = row.createCell(colNum++); // ячейка
            cell7.setCellValue((Double) datatype.getAmount());
            Cell cell8 = row.createCell(colNum++); // ячейка
            cell8.setCellValue((Double) datatype.getFee());
            Cell cell9 = row.createCell(colNum++); // ячейка
            cell9.setCellValue((String) datatype.getCurrency().getLabel());


        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
