# EMS Application


#Steps to run application

1.Execute script DDL.sql (\src\main\resources\DDL.sql)

2.Change jdbc.properties file according to DB (\src\main\webapp\WEB-INF\jdbc.properties)

3.To run selenium tests, change base url in each selenium test according to your application url
	(for selenium tests use firefox version 30\31\32)

Note:This application is deployed to the path http://172.27.59.96:8080/EMS_Hibernate1
	 To change this path provide url in tomcat plugin in pom.xml