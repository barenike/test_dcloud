# Тествое задание для dcloud

Ключевые заметки:

Spring Web

Postman API - https://go.postman.co/workspace/My-Workspace~90bdc7ac-424b-43cd-8acc-3a2d417fad02/collection/17929303-50392632-3b18-45e5-a2ce-c13d368b7c7a?action=share&creator=17929303

Метод POST ("/search") - передает серверу тело запроса в формате JSON: String text и String url.

Например:
{
"text" : "Варшава",
"engine" : "google.com"
}

В качестве engine можно использовать только три варианта: google.com, duckduckgo.com и yandex.ru (последний может работать некорректно ввиду CAPTCHA).

В ответ посылает список searchFirstPageResponseDetails с полями String title и String url.

Например:
{
"searchFirstPageResponseDetails": 
[
{

"title": "Варшава - Википедия https://ru.wikipedia.org › wiki › Варшава",

"url": "https://ru.wikipedia.org/wiki/%D0%92%D0%B0%D1%80%D1%88%D0%B0%D0%B2%D0%B0"

},

...

]
}
