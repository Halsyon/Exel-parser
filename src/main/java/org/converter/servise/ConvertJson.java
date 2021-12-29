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

import java.util.*;

/**
 * Класс конвертирует JSON файл в локальное хранилище объектов POJO
 */
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

            var arrH = arrJ[1].split("\\]");

            String[] arrG = arrH[0].split("},\\{");

            ObjectMapper mapper = new ObjectMapper();

//JSON from String to Object
            String string1 = null;
            for (int i = 0; i < arrG.length; i++) {
                if (i == 0) {
                    string1 = arrG[i] + "}";
                }
                if (i == arrG.length - 1) {
                    string1 = "{" + arrG[i];
                }
                if (i != 0 && i != arrG.length - 1) {
                    string1 = "{" + arrG[i] + "}";
                }

                Depo depo1 = null;
                try {
                    depo1 = mapper.readValue(string1, Depo.class);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                depoMap.put(depo1.getId(), depo1);
                string1 = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
