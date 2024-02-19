# Real Estate Management System

## Overview
The Real Estate Management System is a Java-based application designed to manage various types of properties such as houses, villas, and summer houses. It provides functionalities to calculate total prices, average sizes, and filter properties based on specific criteria like number of bedrooms and living rooms.

## Features
- Management of different types of properties: Houses, Villas, and Summer Houses.
- Calculation of total prices for each type of property.
- Calculation of average area for each type of property.
- Filtering properties based on the number of bedrooms and living rooms.

## Structure
The project is organized into several classes:
- `Property`: An abstract class representing a general property.
- `House`, `Villa`, `SummerHouse`: Classes that extend `Property` for specific types of properties.
- `PropertyManagement`: Class for managing lists of different properties.
- `PropertyService`: Class for performing calculations and filtering properties.

## How to Run
To run this application:
1. Make sure Java is installed on your system.
2. Download or clone this repository to your local machine.
3. Compile the Java files. You can use an IDE or compile them via command line using `javac`.
4. Run the `Main` class to start the application and see the output.

## Usage
After running the application, it will display calculated values such as total prices and average areas for the properties. It also shows the result of filtering properties based on specified criteria.

## Contributing
Contributions to the Real Estate Management System are welcome. Feel free to fork the repository, make changes, and submit pull requests.

