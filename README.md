# LibraryApplication
SprirngBoot_Angular_bootstrap


A library application is created by spring boot, angular js + bootstrap
Maven was used and java 8 was used. 
Instead of Mongo db, mysql was used because I never used mongodb.

To test, you just need to add your mysql configuration into application.myl file:
 -> there is a line inside of the yml file: url: jdbc:mysql://localhost:3306/libraryproject
 -> you should create a db schema in your mysql db and then update the url and also passowrd and user name too.
Tables is created by automatically.  so you do not need to create. 

To test online you can use that link: http://localhost:8080/LibraryApplication/

with the library application;
you can add a new book to the system
you can see all the books 
you can remove any book 
you can edit any book


Note: There is no any modal dialog: I tried to use but could not because,
this is first time that I tried to use angularjs and also bootstrap.
Furthermore, I used freemarker temlates instead of html templates: because they are dynamic templates that can be nested at runtime,
builtin null, handling empty strings. And I saw many good recommendations but actually at the same time I used it first time :) 

I could not find to write more tests so I wrote for just crud tests. But restapi test also can be written.
