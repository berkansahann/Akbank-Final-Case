# <center>Weather Application

## Project Topic:

A weather application is desired to be developed. This application will provide weather
forecasts by using a RESTful web service. Users will have the opportunity to query weather
forecasts for a city. The forecasts will be provided in 3-hour intervals covering a period
of 5 days. The application will retrieve weather forecasts using the OpenWeatherMap API.

## Technologies Used

- Java(JDK 17+)
- Spring Boot
- RESTful Web Services
- OpenWeatherMap API
- PostgreSQL

## Project Installation

1. Download the project as a zip file.
2. Open the project on IDE.
3. Install the necessary dependencies from `pom.xml`.
4. Add a database connection and necessary dependencies in `pom.xml`.
    - If you want the create PostgreSQL on docker. There is a `docker-compose.yaml` for this.
5. Set up the OpenWeatherMap API key:
    1. Visit the OpenWeatherMap website: https://openweathermap.org/
    2. Sign up or log in to your account.
    3. Generate an API key.
    4. Open the application.yaml file.
    5. Set your API key in the api.key property.
5. Build the project.
6. Run the application.

## <Center>Endpoints

---

### Register

Handles the registration request and returns the login response.

- URL: `/api/v1/auth/register`
- Method: `POST`
- Request Body: RegisterRequest
    - `firstName`: The username of the user
    - `lastName`: The username of the user
    - `email`: The username of the user
    - `password`: The password of the user
- Returns: The response entity with the login response containing authentication details

---

### Login

Handles the login request and returns the login response.

- URL: `/api/v1/auth/login`
- Method: `POST`
- Request Body: LoginRequest
    - `email`: The email of the user
    - `password`: The password of the user
- Returns: The response entity with the login response containing authentication details

---

### Add Saved City to User

Adds a saved city to the user's list of saved cities.

- URL: `/api/v1/user/new-city`
- Method: `POST`
- Parameters:
    - `city`: The city name to add
    - `id`: The user ID
- Returns: The response entity with the updated list of saved cities

---

### Get Saved Cities Weather Data of User

Retrieves the weather data for the user's saved cities.

- URL: `/api/v1/user/weather-data/saved-cities`
- Method: `GET`
- Parameters:
    - `id`: The user ID
- Returns: The response entity with the map of city names to weather data

---

### Get Weather

Retrieves the weather data for the specified city.

- URL: `/api/v1/weather/{city}`
- Method: `GET`
- Path Variable:
    - `city`: The name of the city
- Returns: The weather data response
