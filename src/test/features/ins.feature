# language: ru
Функционал: Почта mail.ru

  Сценарий: Чтение непрочитанных сообщений
    Когда входим в почту
      | Логин  | inj-andrey    |
      | Пароль | Yfhwbcc481996 |
    И выбираем на панели "Фильтр по письмам"
    И ставим фильтр: "Непрочитанные"
    И проверяем количество непрочитанных писем
    И отмечаем каждое письмо как прочитанное
    Тогда непрочитанных писем нет



