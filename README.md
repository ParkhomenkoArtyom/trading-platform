# trading-platform

## Инструментарий проектирования 
Java 17, Spring Data Jpa, Spring Security, Spring Boot 3.1.4. База данных PostgreSQL 15.

## Информация для тестирования функционала проекта.
Для тестирования функционала проекта необходимо пройти аутентификацию с помощью email (например, отправить body - "email" : "aaa@bbb") пользователя запросом /auth/login. Иначе остальные запросы будут блокироваться.
1) При запуске приложения происходит автогенерация таблиц, а также инициализация их начальными значениями из файла [**data.sql**](src/main/resources/data.sql).
2) Для удобного тестирования в репозиторий прикреплен файл [**trading-platform-collection-test.postman_collection.json**](trading-platform-collection-test.postman_collection.json) коллекции Postman.

## Инструкция по запуску проекта
1) Создать локальную копию данного удаленного репозитория при помощи команды git clone.
2) Далее для запуска через Docker, необходимо установить сам Docker и скачать Apache Maven (https://maven.apache.org/download.cgi) для сборки проекта. При работе с cli Windows рекомендуется
добавить maven и docker в системные переменные среды Windows.
3) Собрать проект в .jar при помощи команды **mvn package** в корневой папке проекта.
4) Далее запустить docker-compose файл командой docker-compose up.
