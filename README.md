# M223: Punchclock
Dies ist eine Beispielapplikation für das Modul M223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

PunchClock-Application

What is the Punchclock application?
The Punchclock application allows you to track youre time and manage the registerd Users. You can track and manage youre entries on the according page. You can either delete one or change an existing one or create a new one. The Application comes with three preregisterd Users wich are free to use if you dont want to register your own user(Example Username: Max, Password: 1234). That is Thanks to a Script which is called on in Init in the Constructor off the User Service. A JPQL Query is defined to find the user by its username. Every request is secured using JWT authentication. 

Client side:
For the frontend, you need to install Angular as shown here. After installing Clone the Projekt from the git Repo. Open youre preffered editor and run npm install. Npm should install all needed dependencies. Let the Process finish and the run "npm run start" in de Project root folder on your Command line. 

Server side: 
Copy the Repository from git. After its done open the Project in youre Preferred editor preferably intelij Ultimate edition. Navigate to  File -> Project Structure -> Project -> Project SDK tab and set the JDK to 11. If auto Import is Enabled gradle should automatically download all needed depedencies. If that isnt the case check the bottom right off youre screen for a pop up Message asking you to import all gradle dependencies. Click yes. After that your Project should be setupt this might take a while. After that it should be executable by youre editor. An recable trough the endpoint defined in the Controllers.
