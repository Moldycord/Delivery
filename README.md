# Delivery
Delivery app for Fleet management


This is my test for platform science.

#Instructions to run
Just copy the repository and open it on Android Studio
Then make a sync, then run app. 
You should be able to run the app and you will see the list of drivers availables, if you make click on each of them
it will show you the best shipment option assigned to it.

# How i solved the problem of assignment

    #Assumptions
    Here is the list of assumptions that i made to find a solution
    
    * The information of shipments and drivers would be obtained from an API and it would be structured
    * Just take the first name of driver to calculate the SS
    * Use the entire street name of the shipment address, for example "Adolf Island" instead of just "Adolf"


   
  First i created a controller that calculates each SS with the given street name length and driver name length.
  Then on the same controller verifies if they had common factors, if they have multiply the current score per 1.5
  and returns a double value.
 
  On AssignmentDeliveryController i used the calculator controller and iterate over shipments and drivers,
     comparing the SS of each driver with the shipment, then i assign the highest value between them and store in a list
     of assigned shipments and assigned drivers, that i used to avoid assign 2 or more drivers to a single shipment and vice-versa

 
  Then on the activity i created a view model to handle the loading of data,also the activity observes when the drivers are loaded,}
    after that the drivers are shown on a recycler view, and setup a click listener that shows a dialog when a driver is selected.
    The dialog shows the current assigned shipment of that driver.


  
 
