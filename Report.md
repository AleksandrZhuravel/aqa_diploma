### Дипломный проект профессии «Тестировщик»
#### Составление отчёта по итогам проведения автоматизированного тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
**Тестируемая функциональность:** сохранение приложением информации в собственной СУБД о том, каким способом был совершён платёж и успешно ли он был совершён (без сохранения 
данных банковских карт).
                                  

Позитивное и негативное функциональное тестирование

#### 1. Краткое описание
Комплексный сервис был протестирован в соответствии с планом автоматизации тестирования (файл "[Plan.md](https://github.com/AleksandrZhuravel/aqa_diploma/blob/master/Plan.md))". 
База данных работает корректно. Найденные деффекты относятся к категории Usability. 

#### 2. Количество тест-кейсов
Количество автоматизированных тестов - 18 шт

#### 3. Процентное соотношение успешных/не успешных тест-кейсов
1) Процентное соотношение автоматизированных тестов, прошедших успешно - 77,7%(14 шт)
2) Процентное соотношение автоматизированных тестов, прошедших неуспешно - 22,3%(4 шт)

#### 4. Общие рекомендации
1) Информационные надписи под полями ввода рекомендуется оформить в соответствии с произведенной ошибкой Пользователя. При оставлении поля незаполненным информационная надпись
должна содержать текст "Поле обязательно для заполнения", при попытке внести некорректные данные(см. пп."Примечания" п.1 "Перечень автоматизируемых сценариев", "План автоматизации
 тестирования") - текст "Неверный формат";
 
2) Информационная надпись при внесении номера месяца, более раннего чем текущий, в поле ввода "Месяц" и текущего номера года в поле ввода "Год", рекомендуется поменять с 
"Неверно указан срок действия карты" на "Истёк срок действия карты", что будет более информативным;

3) При попытке проведения операции с номером карты, отличном от "4444 4444 4444 4441" и "4444 4444 4444 4442", появляется всплывающее сообщение об ошибке, после закрытия которого
оказывается видимым сообщение об успешно проведенной операции. Рекомендуется устранить для того, чтобы не вводить Пользователя в заблуждение.  