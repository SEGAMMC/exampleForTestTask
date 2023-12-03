**Тестовое задание**

Данный сервис (REST API) позволяет определить частоту встречи символов в заданной строке.

Результат будет отсортирован по убыванию количества вхождений символа в заданную строкую.

**Для запуска сервиса необходимо:** Java 8+, Spring boot 2+

Стартовым файлом для запуска является SpringtestApplication.class

В данном сервисе имеется 2 способа получения результата:

* Отправить запрос HTTP методом GET на адрес
  http://localhost:8080/check/{string}

  где {string} - строка с которой необходимо провести действия.
  Результатом запроса будет строка.

- Отправить запрос в формате JSON методом POST на адрес
  http://localhost:8080/check
  
  Пример тела запроса в формате JSON

  {

    "string": "Hello"
  
  }    
  Результатом запроса будет JSON-объект.
  
  {
  
  "resultString": "l: 2, H: 1, e: 1, o: 1"
    
  }