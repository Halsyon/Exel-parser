package org.converter.servise;

import org.codehaus.jackson.map.ObjectMapper;
import org.converter.model.Depo;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class ConvertJson {

    private Map<Integer, Depo> depoMap = new HashMap();

    public Map<Integer, Depo> getDepoMap() {
        return depoMap;
    }

    public void setDepoMap(Map<Integer, Depo> depoMap) {
        this.depoMap = depoMap;
    }

    public void convertJs(File filePath) {

        File file = filePath;
        String string = null;
        try (FileReader reader = new FileReader(file)) {
            // read the json file
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonObject = null;
            try {
                jsonObject = (JSONArray) jsonParser.parse(reader);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
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
                Depo depo1 = null;
                try {
                    depo1 = mapper.readValue(string1, Depo.class);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(depo1);
                depoMap.put(depo1.getId(), depo1);
                System.out.println();
                string1 = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConvertJson convertJson = new ConvertJson();
        File file = new File("F:\\ConvertExel\\exampleTZ.json");
        convertJson.convertJs(file);
        convertJson.getDepoMap().values().stream().forEach(System.out::println);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
//        var r = convertJson.convertT(localDateTime);
//        System.out.println(r);
    }

}
