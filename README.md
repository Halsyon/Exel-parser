# json_to_exel

Simple converter json to exel file

![GitHub top language](https://img.shields.io/github/languages/top/SlartiBartFast-art/json_to_exel?logo=java&logoColor=red)
![GitHub last commit](https://img.shields.io/github/last-commit/SlartiBartFast-art/json_to_exel?logo=github)

Used stack technologies:

- Java (Back-end)

- Libraries (java):

- Apache POI

- Jackson (parse JSON)

- Lombok

- Maven

Проект представляет собой простой конвертер из JSON в Exel file.

Описание задания для конвертирования содержится в файле task.xml
В корневом каталоге проекта приложен сам файл JSON exampleTZ.json,
а также file Exel 2021-12-30__16-55.xlsx

- Имя файла соответствует времени создания файла:
 yyyy-MM-dd__HH-mm.xlsx - паттерн названия файла.
  
 Важно: 
    - все ячейки должны иметь правильные форматы, это будет проверяться в MS office 2016,
      (важно для сортировки и фильтрации по колонкам в MS office)
    - заголовок таблицы должен иметь: Жёлтый фоновый цвет, обводку по контуру ячеек,
      текст заголовка должен быть **Жирным**.


![Image of Arch](https://github.com/SlartiBartFast-art/json_to_exel/blob/main/image/Screenshot_4.jpg)

 Присутствует возможность выбора директории:
  - где расположен файл Json
  - куда сохранять файл .xlsx Exel file

Итоговый вид файла после конвертации, отсортирован по дате и времени:

![Image of Arch](https://github.com/SlartiBartFast-art/json_to_exel/blob/main/image/Screenshot_3.jpg)

Запуск осуществляется через главный класс:

package org.converter.Main;

_______
[![Forkers repo roster for @SlartiBartFast-art/json_to_exel](https://reporoster.com/forks/SlartiBartFast-art/json_to_exel)](https://github.com/SlartiBartFast-art/json_to_exel/network/members)
[![Stargazers repo roster for @SlartiBartFast-art/json_to_exel](https://reporoster.com/stars/SlartiBartFast-art/json_to_exel)](https://github.com/SlartiBartFast-art/json_to_exel/stargazers)
