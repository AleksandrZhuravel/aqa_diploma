Статус проведенных тестов:
[![Build status](https://ci.appveyor.com/api/projects/status/1hoaj1pqi7wyit1r?svg=true)](https://ci.appveyor.com/project/AleksandrZhuravel/aqa-diploma)








### Дипломный проект профессии «Тестировщик»
#### Проведение автоматизации тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
**Тестируемая функциональность:** сохранение приложением информации в собственной СУБД о том, каким способом был совершён платёж и успешно ли он был совершён 
(без сохранения данных банковских карт).

Позитивное и негативное функциональное тестирование

**Количество автоматизированных тестов:** 18

#### Описание процедуры запуска авто-тестов:

##### 1. Общие действия для запуска приложения:

1) Запусть Docker Toolbox(или Docker Desktop);
2) Запустить IntelliJ IDEA;
3) Открыть терминал IntelliJ IDEA(в дальнейшем - Терминал);
4) Ввести в Терминал команду "docker image build -t node-app:1.0 .";
5) Ввести в Терминал команду "docker-compose up -d";


##### 2. Запуск авто-тестов с использованием СУБД MySQL:

1) Ввести в Терминал команду "java -jar aqa-shop.jar --spring.config.name=application-msql";
2) Ввести в Терминал команду "gradlew test -Dtest.db.url=jdbc:mysql://192.168.99.100:3306/app -Dtest.db.user=app -Dtest.db.password=pass allureReport";
3) Проверить отчёт о проведении авто-тестов в файле "index.html" по адресу "build/reports/allure-report/"(либо ввести в Терминал команду "gradlew allureServe").

##### 3. Запуск авто-тестов с использованием СУБД PostgreSQL:

1) Ввести в Терминал команду "java -jar aqa-shop.jar --spring.config.name=application-psql";
2) Ввести в Терминал команду "gradlew test -Dtest.db.url=jdbc:postgresql://192.168.99.100:5432/postgres -Dtest.db.user=postgres -Dtest.db.password=postgres allureReport";
4) Проверить отчёт о проведении авто-тестов в файле "index.html" по адресу "build/reports/allure-report/"(либо ввести в Терминал команду "gradlew allureServe").

##### Примечания:
1) Т.к. тестирование проводилось на ПК под управлением ОС Windows 10 Home, следует обратить внимание на написание сетевых адресов в файле "application.properties", где вместо 
"localhost:" прописано "192.168.99.100:", что является IP-адресом виртуальной машины, на которой работает Docker.

##### 4. Отчётные документы по результатам проведения тестирования:

1) Отчёт по итогам проведения автоматизированного тестирования - см. файл [Report.md](https://github.com/AleksandrZhuravel/aqa_diploma/blob/master/Report.md) .
2) Отчёт по итогам проведения автоматизации тестирования - см. файл [Summary.md](https://github.com/AleksandrZhuravel/aqa_diploma/blob/master/Summary.md) .