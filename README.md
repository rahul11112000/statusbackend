# Status Update Project
## Live Project URL's
login : http://statusapplicationfrontend.s3-website.ap-south-1.amazonaws.com/
singup : http://statusapplicationfrontend.s3-website.ap-south-1.amazonaws.com/sign-up
## Repo
**frontend Repo ** https://github.com/rahul11112000/statusfrontend
## email and password
Application admin : email: appadmin@gmail.com      password : Rahul@1111

Component admin :   email: comadmin@gmail.com      password : Rahul@1111

status admin :      email: status@gmail.com      password : Rahul@1111

Viewer :            email: viewer@gmail.com      password : Rahul@1111

## Overview
The **Status Update Project** is a web application built using React.js for the frontend and Spring Boot for the backend. It allows users to post and view status updates in real-time. The app provides an intuitive user interface for users to share their thoughts, react to others' updates, and manage their status history.

## Features
- **User Authentication**: Secure login and signup functionality.
- **Post Status Updates**: Users can post short messages or updates.
- **Real-time Feed**: Status updates are displayed in real-time.
- **Edit & Delete**: Users can manage their posts with edit and delete options.
- **Responsive Design**: Mobile-friendly UI.

## Tech Stack
- **Frontend**: React.js, Redux (if state management is needed), Tailwind CSS / Material-UI
- **Backend**: Spring Boot, Spring Security, Spring Data JPA
- **Database**: MySQL / PostgreSQL
- **Authentication**: JWT Authentication / OAuth2
- **Deployment**: AWS (Backend)   AWS (Database)  AWS(React But react is not working properly because HTTP and HTTPS request so react is use local machine)


## Installation
### Prerequisites
Ensure you have the following installed:
- Node.js (>= 14.x)
- npm or yarn
- Java (>= 21)
- Maven
- MySQL / PostgreSQL (if using a relational database)

### Steps
#### Frontend Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/rahul11112000/statusfrontend.git
   cd status
   ```
2. Install dependencies:
   ```sh
   npm install  # or yarn install
   ```
3. Start the development server:
   ```sh
   npm start  # or yarn start
   ```
4. Open the browser and navigate to:
   ```sh
   http://localhost:3000
   ```

#### Backend Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/rahul11112000/statusbackend.git
   ```
2. Configure the database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/status_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```
4. The backend server will start at:
   ```sh
   http://localhost:8080
   ```

## Project Structure
```
status-update-app/
│── frontend/
│   ├── src/
│   ├── public/
│   ├── package.json
│── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/statusupdate/
│   │   │   ├── resources/
│   ├── pom.xml
│── README.md
```

## Environment Variables
Create a `.env` file in the frontend root directory and add the following variables:
```
REACT_APP_API_URL=http://localhost:8080/api
```
For backend, configure environment variables in `application.properties` as needed.

## Deployment
### Deploy to AWS 
Frontend : amplify ,
Backend : elastic Benstalk,
DataBase : RDS (AWS).



## Contributing
1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.

## License
This project is licensed under the **MIT License**.

## Contact
For any queries or contributions, reach out at rahuljadhav11112000@gmail.com.


