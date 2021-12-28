package org.converter.temp;

import io.github.millij.poi.ss.writer.SpreadsheetWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.converter.model.Depo;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test8 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Depo> depoMap = new HashMap();
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
                if(i == 0) {
                    string1 = arrG[i] + "}";
                    System.out.println(string1 + " при нуле");

                }
                if (i == arrG.length - 1) {
                    string1 = "{"  + arrG[i];
                    System.out.println(string1 + " в конце");
                } if (i != 0 && i != arrG.length-1) {
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

            depoMap.values().stream().forEach(employees::add);

            SpreadsheetWriter writer = new SpreadsheetWriter(fileX);
            writer.addSheet(Depo.class, employees);
            writer.write();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
