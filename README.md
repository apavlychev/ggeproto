# Прототип модульного монолита

## Мотивация
Первоначальная организация кодовой базы строится вокруг сущностей базы данных.
С ростом монолита возникает дихотомия между данными и сервисами: данные стремятся быть общими, в то время как сервисы должны соблюдать инкапсуляцию.
Правильным шагом является отделение данных от сервисов и построение модульного монолита.  
Например с использованием принципов DDD в домене должны быть выделены контексты и агрегаты, которые будут являться границами сервисов и модулей.

## Пример
Предположим требуется создать систему для демонстрации работы счетчика целых чисел и асинхронных операций, при этом пользователю требуется REST API и документация.
Также асинхронные операции должны выводить последнее значение счетчика.

## Технологии
- Фреймверки: Play2 2.8.15, Guice, Twirl
- ЯП: Scala
- Idea: IntelliJ
- Git

## Структура
- _domain_ - доменные модули
    - _async_ - модуль асинхронных операций
    - _counter_ - модуль счетчика целых чисел
    - _api_ - общие протоколы для межмодульного взаимодействия, автогенерация моделей рутов
- _models_ - общие модели данных
- _inf_ - инфраструктура
    - _common_ - модуль утилит и расширений
    - _uiCommon_ - модуль UI для компонентов, layouts Play2 шаблонов
- _apps_ - хосты для запуска модулей
    - _main_ - web-сервер для REST API
    - _admin_ - web-сервер для HTML-документации
- _scripts_ - sbt-скрипты запуска 



