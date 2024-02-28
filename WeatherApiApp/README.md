# Weather API Application

## Overview
Weather API App is a Java-based Spring Boot application designed to provide weather information. It interfaces with external weather APIs to fetch daily, weekly, and monthly weather forecasts based on user inputs like country and city.

## Features
- **Daily Weather**: Fetch daily weather information based on city and country.
- **Exception Handling**: Robust error management for seamless user experience.
- **External API Integration**: Interacts with external weather APIs for real-time data.
- **Caching Mechanism**: Optimized performance with caching of weather data.
- **RESTful API**: Provides a structured RESTful API for easy consumption.

## Limitations
- **Weekly and Monthly Forecasts**: Not available due to limitations of free access to external weather APIs.
- **Real-Time Data Variability**: Weather forecasts may vary due to the constraints of the used weather service provider.

## Structure
The application is organized into several key components:
- **Controllers**: Handle incoming HTTP requests and send responses.
- **Services**: Contain business logic and interact with external APIs.
- **DTOs (Data Transfer Objects)**: Define data structures for communication between layers.
- **Mappers**: Convert data between different representations (e.g., DTOs to domain models).
- **Exception Handling**: Provides centralized error handling throughout the application.

## Testing
The application includes a comprehensive suite of tests:
- **Unit Tests**: Validate individual components in isolation.
- **Integration Tests**: Verify interactions between various components.
- **MockMvc Tests for Controllers**: Ensure controllers behave as expected under different scenarios.

## Setup and Running
1. Clone the repository: `git clone <repository-url>`
2. Open the project in your preferred IDE.
3. Ensure Java 17 or above is installed.
4. Configure application properties as required (e.g., API keys, database settings). API keys should be stored as environment variables and referenced in the application properties file as `${ENV_VAR}`.
5. Run the application using your IDE or command line: `mvn spring-boot:run`

## Usage
The application exposes the following RESTful endpoints:
- Get Daily Weather: `/api/v1/weather/daily?country={country}&city={city}`
  Note: Weekly and monthly endpoints have a similar structure but are not functional due to API limitations.

## Contributing
Contributions to the Weather API App are welcome! Please follow these guidelines:
- Write clear, concise, and well-documented code.
- Ensure tests are written for new features and bug fixes.
- Adhere to the existing coding standards and conventions.
