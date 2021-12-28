package org.converter.temp;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
import org.converter.model.Depo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Преобразование объекта в JSON и обратно:
 */
public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file =  new File("F:\\ConvertExel\\exampleTZ.json");
//        File file =  new File("F:\\ConvertExel\\tempJson.json");

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
            ObjectMapper mapper = new ObjectMapper();
//            String jsonInString = "{'name' : 'mkyong'}";

//JSON from file to Object
//            Depo depo = mapper.readValue(new File("F:\\ConvertExel\\tempJson.json"), Depo.class);

//JSON from String to Object
            Depo depo1 = mapper.readValue(arrH[0], Depo.class);
            System.out.println(depo1);
            System.out.println();
            System.out.println();

            var arrT = toJSONString.split(",");
            System.out.println(jsonObject);
            System.out.println();

            System.out.println(toJSONString);
            Arrays.stream(arrT).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    public static Object readJsonSimpleDemo(String filename) throws Exception {
//
//        FileReader reader = new FileReader(filename);
//        JSONParser jsonParser = new JSONParser();
//        var t = jsonParser.parse(reader);
//        return t;
//    }
//
//    public static void main(String[] args) throws Exception {
//        String filePath = "F:/ConvertExel/exampleTZ.json";
//        JSONObject jsonObject = (JSONArray) readJsonSimpleDemo(filePath);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.get("City"));
//    }
}
