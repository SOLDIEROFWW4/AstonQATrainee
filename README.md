# Урок №2
## Структура проекта:
- docs/: содержит в себе документацию проекта.
- src/main/java/: Исходный код приложения.

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание всех 14 задач содержится в папке docs, файл TOR.md

## Пометка по выполнению программного кода:
Как только начнёте запуск класса Main.java содержащий в себе основной метод main, методы, которые относятся к задачам, будут запускаться последовательно. 

## Java файлы и их описание:
- Tasks: содержит в себе методы, характерные для 14 задач.
- Main: основной метод для запуска программного кода.
- Utility: дополнительный метод, который содержит в себе методы для вывода параметров.

# Урок #6

## Структура проекта:
- docs/: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson6: Исходный код приложения.

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 3 задач содержится в папке docs, папка lesson6, файл TOR.md

## Пометка по выполнению программного кода:
Как только начнёте запуск класса Main.java содержащий в себе основной метод main, методы, которые относятся к задачам, будут запускаться последовательно. 

## Java файлы и их описание:

- Employee: содержит в себе методы для выполнения 1 задачи;
- Main: основной метод для запуска программного кода;
- Park: содержит в себе методы для выполнения 3 задачи.

# Урок #7

## Структура проекта:
- docs/lesson7: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson7: Содержит в себе пакеты с исходным кодом приложения.
- src/main/java/ru.astondev/lesson7/task1: Содержит в себе файлы для решения задания №1.
- src/main/java/ru.astondev/lesson7/task2: Содержит в себе файлы для решения задания №2.

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 2 задач содержится в папке docs, папка lesson7, файл TOR.md

## Пометка по выполнению программного кода:
Как только начнёте запуск класса Main.java содержащий в себе основной метод main, методы, которые относятся к задачам, будут закомментированы.
В зависимости от запускаемого метода, раскомментируйте строки с его кодом.

## Java файлы и их описание:

- Main: основной метод для запуска программного кода;

### Задание №1
- Animal: абстрактный класс, задающий общую логику: свойства и методы для всех животных, такие как имя и методы для бега и плавания. Также ведет счетчик всех созданных животных;
- Cat: класс, наследующий Animal, реализующий логику для кота, включая ограничения на бег и отсутствие возможности плавания. Добавлено поле сытости и методы для кормления. Ведет счетчик созданных котов;
- Dog: класс, наследующий Animal, реализующий логику для собаки, включая ограничения на бег и плавание. Ведет счетчик созданных собак;
- Bowl: класс, представляющий миску с едой, позволяет уменьшать или добавлять количество еды и не допускает отрицательного количества.
### Задание №2
- Shape: интерфейс, задающий методы для расчета периметра и площади фигур, а также получения цветов;
- BaseShape: абстрактный класс, реализующий общие свойства и методы, такие как цвета заливки и границы;
- Circle: класс, реализующий логику для круга, включая расчет периметра и площади по радиусу;
- Rectangle: класс, реализующий логику для прямоугольника, включая расчет периметра и площади по ширине и высоте;
- Triangle: класс, реализующий логику для треугольника, включая расчет периметра и площади по формуле Герона.

# Урок #8

## Структура проекта:
- docs/lesson8: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson8: Содержит в себе файлы с исходным кодом приложения.

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 3 задач содержится в папке docs, папка lesson8, файл TOR.md

## Пометка по выполнению программного кода:
Как только начнёте запуск класса Main.java содержащий в себе основной метод main, методы, которые относятся к задачам, будут запускаться последовательно.

## Java файлы и их описание:

- Main: основной метод для запуска программного кода;
- MyArrayDataException: класс исключения, указывающий на неправильный размер массива. Используется для оповещения того, что массив не соответствует ожидаемому размеру 4x4;
- MyArraySizeException: класс исключения, указывающий на некорректные данные в массиве. Содержит информацию о позиции элемента, который не удалось преобразовать в тип int;
- ArrayHandler: абстрактный класс, задающий методы для проверки размера массива и обработки элементов. Обеспечивает базовую структуру для обработки массивов;
- ArrayProcessor: класс, реализующий логику проверки и обработки двумерного массива. Реализует методы из ArrayHandler для проверки размера и преобразования элементов в тип int. Содержит метод processArray для подсчёта общей суммы элементов массива.

# Урок #11

## Структура проекта:
- docs/lesson11: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson11: Содержит в себе пакеты с исходным кодом приложения.
- src/main/java/ru.astondev/lesson11/task1: Содержит в себе файлы для решения задания №1.
- src/main/java/ru.astondev/lesson11/task2: Содержит в себе файлы для решения задания №2.

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 3 задач содержится в папке docs, папка lesson11, файл TOR.md

## Пометка по выполнению программного кода:
Как только начнёте запуск класса Main.java содержащий в себе основной метод main, методы, которые относятся к задачам, будут закомментированы.
В зависимости от запускаемого метода, раскомментируйте строки с его кодом.

## Java файлы и их описание:

- Main: основной метод для запуска программного кода;
### Задание №1
- WordProcessor: класс для обработки массива слов. Предоставляет методы для получения уникальных слов и подсчёта частоты встречаемости каждого слова в массиве. Использует коллекции для эффективной обработки данных.
### Задание №2
- Contact: класс, представляющий контактную информацию. Содержит фамилию и список телефонных номеров. Предоставляет методы для добавления номера телефона и получения списка всех номеров;
- PhoneBook: класс для управления телефонным справочником. Использует карту, чтобы хранить списки телефонных номеров по фамилиям. Предоставляет методы для добавления номера по фамилии и получения всех номеров, связанных с данной фамилией.

# Урок #12

## Структура проекта:
- docs/lesson12: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson12: содержит в себе файлы для решения заданий №1 и №2 с исходным кодом приложения;
- src/test/java/lesson12_TestNG: содержит в себе файлы для запуска тестов по условию задания №1;
- src/test/java/lesson12_JUnit5: содержит в себе файлы для запуска тестов по условию задания №2;

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 3 задач содержится в папке docs, папка 2, файл TOR.md

## Пометка по выполнению программного кода:
* Запуск тестов производится из пакета lesson12_TestNG, либо из lesson12_JUnit5;
* Установленные библиотеки: jcommander (version 2.0), slf4j-api (version 2.0.16), testng (version 7.10.2), junit (version 4.13.2).

## Java файлы и их описание:

- Main: основной метод для запуска программного кода;
- Factorial: интерфейс, содержащий в себе метод для подсчёта факториала числа;
- RecursiveFactorialCalculator: класс, наследующий интерфейс Factorial и реализующий метод подсчёта факториала числа.

# Урок #15

## Структура проекта:
- docs/lesson15: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson15: содержит в себе вспомогательные файлы для решения задач;
- src/test/java/lesson15: содержит в себе файлы для запуска тестов по условию задач;

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 4-х задач содержится в папке docs, папка lesson15, файл TOR.md

## Пометка по выполнению программного кода:
* Запуск тестов производится из пакета lesson15, файл MtsByTests;
* Установленные библиотеки: junit (version 4.13.2), selenium (version 4.24.0).

## Java файлы и их описание:

- TestHelper: класс, предоставляющий вспомогательные методы для тестирования. Включает методы для проверки отображения текста элементов на странице. Если проверка проходит, выводится сообщение об успешном тесте. В противном случае выбрасывается AssertionError с описанием ошибки.

# Урок #16

## Структура проекта:
- docs/lesson15: содержит в себе документацию проекта.
- src/main/java/ru.astondev/lesson16: содержит в себе вспомогательные файлы для решения задач;
- src/test/java/lesson16: содержит в себе файлы для запуска тестов по условию задач;

## Где найти техническое задание, содержащие в себе условия задачи?
Условие, где хранится описание 4-х задач содержится в папке docs, папка lesson16, файл TOR.md

## Пометка по выполнению программного кода:
* Запуск тестов производится из пакета lesson16, файл MtsByTests;
* Установленные библиотеки: junit (version 4.13.2), selenium (version 4.24.0).

## Java файлы и их описание:

- TestHelper: класс, предоставляющий вспомогательные методы для тестирования. Включает методы для проверки отображения текста элементов на странице. Если проверка проходит, выводится сообщение об успешном тесте. В противном случае выбрасывается AssertionError с описанием ошибки.
- FormValidator: класс, представляющий вспомогательные методы для метода теста testPaymentServicesDropdownOptions. Включает в себя Map с элементами выпадающего списка.

