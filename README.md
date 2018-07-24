# serachflightdemo

You need to Java 8 to run demo 
project uses spring boot and gradle build tools 
you can run "./gradlew bootrun" command to run project. it will start server with end point http://localhost:9090/searchFlights/{origin}/{destination}
if face error while running change port no, to different in "/src/main/resources/application.properties" file.

classes 
SearchFlightController - Spring RestController which expose one method for serving request.
FlightRepo - bean provide sorted resut from datasource classes.
DataFileReader - abstract class define method to read object from file.
Flight - model class for holding flight details.
Utils -define static method for datetime format and conversions.
DataProvider1,DataProvider1,DataProvider1 - classes parse data specific format.
provider1.txt,provider2.txt,provider3.txt - stored data different format.

This can be easily extended by adding more format.
