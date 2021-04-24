# Демо-проект автоматизации тестирования веб-сайта
https://room-park.ru/

# Используемые технологии
![Java](readme_files/Icons/Java.png)
![Gradle](readme_files/Icons/Gradle.png)
![JUnit5](readme_files/Icons/JUnit5.png)
![Selenide](readme_files/Icons/Selenide.png)
![Allure_Report](readme_files/Icons/Allure_Report.png)
![Jenkins](readme_files/Icons/Jenkins.png)
![Selenoid](readme_files/Icons/Selenoid.png)
![Telegram](readme_files/Icons/Telegram.png)
- Java
- Gradle
- Junit5
- Selenide
- Allure Report
- Jenkins
- Selenoid
- Telegram Bot

# Описание
Тестирование авторизационной формы с использованием указанных технологий.

- Тесты запущены из CI системы Jenkins
- Для контейнеризации selenide тестов использован Selenoid
- Сгенерирован отчет Allure reports (автоматически добавлены скриншоты и видео прохождения тестов)
- Отчет загружен в TMS - Allure TestOps
- Автоматически созданы тест-кейсы 
- Для примера в Allure TestOps добавлен ручной тест
- Уведомление с отчетом о прохождении тестов отправлено в Telegram

## Отчеты Allure reports
### Общий отчет о прохождении тест-сьюта
![Allure reports overview](./readme_files/allure-report.jpg)
### Детальный отчет о прохождении конкретного теста
![Allure reports test](./readme_files/allure-report-test-with-screenshot.jpg)
### Видео прохождения теста
![Video](./readme_files/testVideo.gif)

## Отчеты Allure TestOps
### Запуски
![TestOps launches](./readme_files/TestOpsLaunches.jpg)
- **id #2935** - Прохождение ручного тест-кейса
- **id #2933** - Прохождение автоматизированных тест-кейсов

### Тест-кейсы
![TestOps cases](./readme_files/TestOpsSuites.jpg)
- **id #2449** - Ручной тест-кейс

### Allure TestOps Dashboard
![TestOps cases](./readme_files/TestOpsDashboard.jpg)


## Уведомление в Telegram
![telegram](./readme_files/TelegramBot.jpg)

## Ссылки
### Jenkins
https://jenkins.autotests.cloud/job/C05-NastyaPru-HomeWork11
### Allure reports
https://jenkins.autotests.cloud/job/C05-NastyaPru-HomeWork11/6/allure/

