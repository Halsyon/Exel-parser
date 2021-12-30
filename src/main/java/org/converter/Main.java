package org.converter;

import org.converter.servise.ConvertJson;
import org.converter.servise.ConvertToExel;

import java.io.File;

/**
 * основной класс для конвертации
 * парсинг данных из Json file
 * парсинг данных в EXEL file
 *  String string = "F:/ConvertExel/"; - путь куда хотим сохранить новый файл
 *  File file = new File("F:\\ConvertExel\\exampleTZ.json");
 *  - путь где брать файл JSON, для конвертции
 */
public class Main {
    public static void main(String[] args) {
        String string = "F:/ConvertExel/";
        File file = new File("F:\\ConvertExel\\exampleTZ.json");
        ConvertJson convertJson = new ConvertJson();
        convertJson.convertJs(file);
        ConvertToExel convertToExel = new ConvertToExel(convertJson.getDepositMap(), string);
        convertToExel.convertToEl();
    }
}
