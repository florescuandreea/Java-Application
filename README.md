# Java-Application
Create a Java application that simulates a machine factory. The factory contains the number of machines it has in stock, the number of machines created and the machines. Note that the factory can store, at any time, 10 machines. The machines contain an id (which represents the machine's order number in the factory), color and price.

Implement the commands that the application can receive from the keyboard:
START:
The “start” entry will be expected. If the user enters any other entry, the message will be displayed: “Please enter start!” .When entering start, the structure of all other commands will be displayed in different lines.

EXIT:
The application will read commands infinitely until exit is entered. When exit is entered, the application will stop, displaying the message “Factory stopped!

“ADD <color> <price>”:
Add a machine of the appropriate type, displaying “added machine!”. If there is no room, the message “factory is full!” will be displayed. 
  
“DISPLAY”:
Displays all machines. If factory is empty, “Factory is empty!” will be displayed. 

“DETAILS id_machine>”:
Displays the searched machine information. If the machine does not exist, “searched machine does not exist!” will be displayed.

“DISPLAY <color>”:
Displays all machines with that color. If the factory does not contain any machine with that color, “there are no color machines in the factory!” will be displayed.

“SELL <id_car>”:
If the car exists, it will be taken out of stock and “machine “ car details ” sold!” will be displayed. If the car does not exist, a checked exception will be discarded and will be treated, finally displaying “car searched does not exist”
