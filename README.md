# App exel parser

[![Build Status](https://app.travis-ci.com/Halsyon/Exel-parser.svg?branch=main)](https://app.travis-ci.com/Halsyon/Exel-parser)
![GitHub top language](https://img.shields.io/github/languages/top/Halsyon/Exel-parser?logo=java&logoColor=red)
![GitHub last commit](https://img.shields.io/github/last-commit/Halsyon/Exel-parser?logo=github)

App excel parser

Used stack technologies:

- Java (Back-end)

- Libraries (java):

- Apache POI

- Jackson (parse JSON)

- Lombok

- Maven

Проект представляет собой конвертер из JSON в Exel file.

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


![Image of Arch](https://github.com/Halsyon/Exel-parser/blob/main/image/Screenshot_4.jpg)

 Присутствует возможность выбора директории:
  - где расположен файл Json
  - куда сохранять файл .xlsx Exel file

Итоговый вид файла после конвертации, отсортирован по дате и времени:

![Image of Arch](https://github.com/Halsyon/Exel-parser/blob/main/image/Screenshot_3.jpg)

Запуск осуществляется через главный класс:

package org.converter.Main;

_______
[![Forkers repo roster for @Halsyon/Exel-parser](https://reporoster.com/forks/Halsyon/Exel-parser)](https://github.com/Halsyon/Exel-parser/network/members)
[![Stargazers repo roster for @Halsyon/Exel-parser](https://reporoster.com/stars/Halsyon/Exel-parser)](https://github.com/Halsyon/Exel-parser/stargazers)
