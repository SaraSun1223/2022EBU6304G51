# _Software_group51_ -- A smart flight check-in kiosk
EBU6304-Software Engineering Project of Group 51  
## Environment
- Running Environment: openjdk-18
- Developing Environment: IntelliJ IDEA + Git
- Dependencies: fastjson-1.2.80.jar
## Path of Source code: 
- ./Software_group51/src/coursework
## Path of TDD Test:
- ./Software_group51/src/TDD
## Installation - How to Run the Software
### Method - Run JAR Package 
- Clone the repository to your PC, and make sure running environment is openjdk-18
- Open the terminal (for Mac) or cmd (for windows) and move to the project dictionary
- Run Group51_Project.jar `$ java -jar Software_group51.jar`.
- Make sure that `Software_group51.jar` and `/File` dictionary are in the same root dictionary (e.g. both under the dictionary `/Software_group51`)!
## Main Functions
### For Customer (Flight Check-in Kiosk)
- Three ways to log in - using booking number, surname and ID number, or scanning the ID document directly.
- See a list of booking information
- Choose the basic seat for free.
- Choose food and drinks from the basic menu for free. 
- Choose the upgraded seat with an extra payment.
- Choose the extra food and drinks from the extramenu.
- Cancel the options that they have chosen before payment.
- Pay for the extra options.
- Confirm the order and Print the boarding pass.
### For Airline Staff (Management System)
- Login with the staff ID and password.
- See a list of check-in status of passengers.
- See a list of baggage information of passengers.
- See a list of orders of meal from passengers.
- See the seat information chosen by the passengers.
- Filter and search in the 'check-in status' by the passenger information, including 'Flight Number', 'Passenger name', 'ID number', boolean value and 'Phone number'
- Filter and search in the 'Baggage Management' by the passenger information, including 'Flight Number', 'Passenger name', 'ID number', Number of pieces of baggage and the weight of the baggage.
- Filter and search in the 'Meal Management' by the passenger information, including 'Flight Number', 'Passenger name','Seat number', and the name of selected meals. 
- Filter and search in the 'Seat Management' by the passenger information, including 'Flight Number', 'Passenger name', 'ID number', ''Seat number' and 'Phone number'
### List of usable accounts for passengers to log in
| Booking Number | Surname | ID Number  |
|:--------------:|:-------:|:----------:|
|     000001     |   LI    | 2019213330 |
|     000002     |   SUN   | 2019213204 |
|     000003     |  XIAO   | 2019213338 |
|     000004     |  ZHANG  | 2019213335 |
|     000005     |   NIE   | 2019213334 |
|     000006     |  ZHANG  | 2019213307 |
### List of usable accounts for airline staff to log in

| Staff ID | Password |
|:--------:|:--------:|
|   1001   | 10011001 |
|   1002   | 10021002 |
|   1003   | 10031003 |
|   1004   | 10041004 |
|   1005   | 10051005 |

## Developers and their Contributions 
We are all from Beijing University of Posts and Telecommunications, and members of BUPT-QMUL Joint Programme. Group 51 of EBU6304 Software Engineering Project   
### Jiayi ZHANG
Group leader, allocating the tasks. Specifying the requirements of ordering process. Coding for the UI Classes of BasicMenuList and ExtraMenuList, coding for the function of payment.Finished the data of Menu, and completing the according controller classes. Being in charge of modifying and integrating the report. Being responsible for refactoring the code.Being responsible for the user manual part.Being responsible for recording the demonstration video.
### Shaohe XIAO
Participating in writing user stories and product backlog and modifying prototype design.Coding for the GUI design of management part, Payment and Confirmations pages, writing codes related to reservations including entity classes and controller functions, modifing data manager function to enable the new information display. Responsible for analysis and design part in the report. 
### Junyue LI
Building the MVC framework of the project. Coding for GUI of Check-in ways of passengers and realizing basic restrictions and error checking for the input data. Being responsible for reading and writing data. Realizing the function of passenger login authentication and modifying airline staff login authentication. Realizing the function of displaying passengers' information. Realizing the function of searching the passenger information by entering the keywords. Being responsible for the Project Management part of the report.
### Shiyang NIE
Make the main pages of the prototype, and participate in supplementing the story and requirements. Responsible for the JSON files of flight information and seat information. Coding for the UI Classes of Seat and ExtraSeat, and related control classes. Responsible for the TDD code and system testing for each version, page design and beautification, and packaging the JAR files of the program. Being Responsible for writing Test part of the report.
### Jinshuo SUN
Participating in writing user stories and product backlog. Be responsible for UI classes of StaffLogin and Login1, Login2Test, Login3.Add 'back'button in MyBooking.java and ManagementFrame.java.Supplementing JSON files. Draw UML diagrams; Add background picture in the login interface; Responsible for requirements and implementation part of the report.
### Yian ZHANG
Completed the prototype of employee login and the writing and reading of the employee information JSON file, and wrote the TDD file of version 4 together with Nie Shixiang, completed the restrictions on the bank card number and password after selecting the payment method, and some pop-up windows for confirmation, and completed the user story form and part of the demand analysis in the final report
