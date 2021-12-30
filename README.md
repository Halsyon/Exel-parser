# json_to_exel
simple converter json to exel file

Проект представляет из себя простой конвертер из JSON в Exel file.
Описание задания для конвертирования содержится в файле task.xml
В корневом каталоге проекта приложен сам файл JSON exampleTZ.json
а также file Exel 2021-12-30__16-55.xlsx

- Имя файла соответствовeт времени создания файла:
 yyyy-MM-dd__HH-mm.xlsx - паттерн названия файла.
  
 Важно: 
 -  все ячейки должны иметь правельные форматы, это будет проверяться в MS office 2016.
  (важно для сортировки и фильтрации по колонкам в MS office)
 - заголовок таблицы должен иметь: Жёлтыйй фоновый цвет, обводку по контуру ячеек,
   текст заголовка должен быть **Жирным**.


![Image of Arch](https://github.com/SlartiBartFast-art/json_to_exel/blob/main/image/Screenshot_4.jpg)

 Присутствует возможность выбора директории:
  - где расположен файл Json
  - куда сохранять файл .xlsx Exel file

Итоговый вид файла после конвертации, отсортирован по дате и времени:

![Image of Arch](https://github.com/SlartiBartFast-art/json_to_exel/blob/develop/image/Screenshot_5.jpg)

Запуск осуществляется через главный класс package org.converter.Main;

Used stack technologies:

- Java (Back-end)

- Libraries (java):

- Apache POI

- Jackson (parse JSON)
  
- Lombok
  
- Maven
