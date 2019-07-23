# SpringMvcJpa
Созданное веб-приложение позволяет: 
  •выполнять регистрацию пользоваталей
  •выполнять авторизацию пользователей
  •выполнять CRUD операции над объектами:
                               -Продукт(UUID;Имя;цена;Производитель)
                               -Производитель(UUID; Имя; Продукты )
                               -Роль(UUID; Имя)
                               -Пользователь(UUID; email; string пароль; firstName; lastName; Роли)

В базе данных хранятся данные о производителях (Производитель) и товарах (Продукт). 
Каждый товар имеет одного производителя, и каждый производитель имеет набор товаров.

Технологический стек: Java, SQL, Spring Boot,MVC, Spring Data, Spring Security, JSP, HTML/CSS, Maven, Tomcat, Git
