# Artikelverwaltung_2_3

Ein Maven Projekt, dass ein WebApp baut, was eine primitive Web-Shop darstellt.

## How to

Dieses Projekt kann in jedem Entwicklungsumgebung geöffnet werden, das Maven untrestützt.
Bisher ist IntelliJ IDEA (Community or Ultimate), Eclipse und Netbeans.

Per default ist das Projekt mit einer Datenbankverbindung in Form eines Derby/JavaDB Servers
(siehe [`persistence.xml`](src/main/resources/META-INF/persistence.xml)), 
was vorher gestartet werden muss,

Danach kann das produzierte Webapp aus dem IDE gestartet werden 
(nur ein Servlet-Container ist nötig) oder direkt aus Maven indem das Goal
`tomcat:run-war` verfolgt wird. 

## Credit

The project is an enrichment of Artikelverwaltung_2_3 of the IUBH's IPWA02 Module, and is
helped by 
 [simple-jpa-app](https://github.com/IUBH-Webanwendungen/simple-jpa-app)
 and [jsf-webapp](https://github.com/IUBH-Webanwendungen/jsf-webapp), itself
 an enrichment of  [How to configure JSF in Tomcat](https://www.byteslounge.com/tutorials/how-to-configure-jsf-in-tomcat-example) by Gonçalo Marques by Paul Libbrecht and uses two version of [a](https://openclipart.org/detail/323008/are-you-lucky-typography) picture by j4p4n of OpenCliparts.
Thanks to suggestions by [Tim Irrgang](https://github.com/designexe/) and the other participants to the tutorial hours.
 
It is available under [Apache Public License](LICENSE.txt): Feel free to copy, change, and redistribute it!
 
Maintained by Paul Libbrecht.