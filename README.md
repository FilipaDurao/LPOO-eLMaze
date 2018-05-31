# LPOO eLMaze
LPOO Second Project using libGDX

## Project Infos
* **Date:** 2nd Year, 2nd Semester, 2017/2018
* **Course:** Laboratório de Programação Orientada a Objetos (LPOO) | Object Oriented Programming Laboratories
* **Course Link:** https://sigarra.up.pt/feup/pt/ucurr_geral.ficha_uc_view?pv_ocorrencia_id=399895
* **Project's Collaborators:** Rui Alves (<u>xRuiAlves</u>) and Filipa Durão (<u>FilipaDurao</u>)

## Intermediate Check-Point Delivery
All deliverables regarding the final project intermediate check-point delivery (UML diagrams, GUI mockups, Design choices and patterns, ...) can be found under the folder "<b>Intermediate Check-Point Deliverables</b>".</br>

## Final Delivery

### Setup/Installation Procedure
To run the **mobile project** (client program), the application must be installed through the *.apk* file. After doing so, simply run the application to join the server and play the game.</br>
To run the **desktop project** (server program), no installation is required. To start the game, simply run the *.jar* file on any operating system. 

### UML Diagrams
Both desktop and mobile project's UML diagrams can be found under the **UMLDiagrams** folder.

### Design Decisions and Functionalities
In order to allow the game to be played by using a phone (or other android mobile device) as a remote controller, a network communication was developed, using a desktop add (desktop project) as a server and connecting with the mobile devices as clients. A **communication protocol** was implemented to allow the communication, with messages sent in both communication directions (server->client and client->server). The communication final version is very robust, checking for all client connections and disconnections, running on a **multi-threaded architecture**.

### Architectural Patterns
Both mobile and desktop projects where developed using the architectural pattern **MVC - Model View Controller**, in order to keep the game's view, model and logics independent from each other, achieving a more modular design and separating concerns and responsiblities in different modules.

### Design Patterns
In the project there were implemented many design patterns in order to improve code quality, modularity, efficiency and readability. All the design patterns that were foreseen in the intermediate check-point were successfully implemented:</br></br>
**MVC - Model View Controller:** To keep the game's view, model and logics independent from each other, achieving a more modular design and separating concerns and responsiblities in different modules.</br>
**Singleton:** To ensure that a given set of classes have one and only one instance (GameController, GameModel, NetworkManager, ...) and can be accessed by other classes in a simple and clean way.</br>
**Observer:** In the controller package, the CollisionListener class will be responsible to process all the game's physical world's collisions, thus acting as a collision observer (The collisions are implemented by the LibGDX library)</br>
**Factory:** To keep the responsibility of creating objects to a specific class, by hiding all the object creation complexity from the direct object instantiation, thus making the code cleaner and simpler (MenuFactory, ImageFactory, ButtonFactory, ViewFactory, ...)</br>
**FactoryMethod:** Used to make the object instantiation defer from each of a classe's subclasses, in order to achieve a better class structure (Used in EntityView class, in the Desktop Project).</br>
**FlyWeight:** To maintain an object cache for future re-usage, in order to make the game lighter and more responsive (Used in the ViewFactory class, in the Desktop Project).</br>
**State:** Both mobile and desktop applications contain their own state, which may change uppon certain events (these state and state transitions may depend on each other through the networking communication).</br>

### Difficulties found along the way
There weren't found any major difficulties in the project's development. The most challenging part was the network commmunication between the server (computer) and the clients (mobile), allthough it was implemented with success. There were also some minor difficulties in adapting to the MVC design pattern and to the overall LigGDX functioning, that were also overcomed quickly.

### Work distribution and overall development time
The project was developed, overall, equally by both members. Both members worked in all parts of the project (Desktop, Mobile, Networking, Design, Documentation, ...) and most of the code was developed in "pair programming" sessions. There were also meetings that took place in order to plan the project's structure and overall functionalities.</br>
The amount of time spent in the project's development was equivalent by both members. The amount of working time dedicated to the project was around X hours (Sum of the number of working hours of both members). 

### User Manual
The full user manual can be found under the folder **UserManual**.
