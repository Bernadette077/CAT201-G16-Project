
<img align="center" alt="Coding" height= 300px src="https://img.freepik.com/premium-vector/laundry-service-illustration-flat-design_98292-22156.jpg?w=2000">

# Laundromat Booking System 



## 📜 Introduction 

The Laundromat Booking System project is designed to aid in the digitalization of laundromat booking.
We chose SDG 11 because it aligns with the core objective of our system: improving urban living through effective, sustainable solutions. 

By digitizing key processes like reservations, cancellations, and feedback, our app aims to make laundry services easier and better for both customers and laundromat owners. Ultimately, this system promotes the creation of resilient and sustainable urban communities.

## 🛠️ System Modules

#### 1. **Sign-In Page**

   The Sign-In Page is the gateway for users to access the Laundromat Booking System. 
   - Users need to provide valid credentials (username and password) to log in.
   - The system ensures security by verifying each user's identity.
   - In case of incorrect login details, users will see an error message:
"`Invalid username or password, please try again!`"

#### 2. **Booking Services**
   
   Customers can book laundry services by inputting the following details:
   - **`Name`**: Enter full name for record purposes
   - **`Phone No.`**: Enter phone number for contact purposes
   - **`Email`**: Enter email for record purposes
   - **`Service Type`**: Choose from the available services (e.g wash & fold, dry cleaning, both)
   - **`Scheduling Date`**: Customers must schedule the date for dropping off and picking up their laundry.

#### 3. **Cancel Booking Information**
   
    Customers have the option to cancel their booking through the system

#### 4. **Display Booking Information**

   This module enables customers to view detailed information about their bookings, ensuring a seamless   experience:
   - **`Viewing Booking Details:`**

     Customers can access a section where they can view booking information such as booking ID, customer name, service type, laundry drop-off date, email, and phone number.

   - **`Viewing Historical Booking Data`**
  
     Customers can check their past booking details and track their laundry service history. This feature allows users to review previous transactions and make informed decisions about future bookings.


#### 5. **Feedback Feature**

   Customers can share their experience and satisfaction level with the laundry services:

   - **`Submitting Review`**:
   
     Users can submit feedback on the services they received. The system provides a feedback form where users can express their thoughts and concerns about the booking system’s performance and usability.

   - **`Rating Collection`**:
    
     The system includes a slider that collects user ratings. The user moves the slider left or right to indicate their satisfaction, with the far-right side indicating high satisfaction and the left side representing dissatisfaction. This helps the laundromat measure customer satisfaction and improve its services.

## 💻 Technology Used

1. **`JavaFX`**:

   - Framework for building desktop application in java
   - Provides features like UI Controls (Button, labels, text fields, event handling, animation)
   - Aids in building modern and responsive design

2. **`FXML`**:

   - FXML is a markup language for separating design of user interface from logic of application
   - Define the layout structure of UI componenets in FXML file.
   - Will be loaded and manage by JavaFX controller
   - This approach supports clean MVC (Model-View-Controller) architecture
  
3. **`Scene Builder`**:

   - Visual tool that allows you to design the UI by dragging and dropping JavaFX componenet.
   - It generates FXML files that is linked with Java controllers
   - This tools simplifies the process of designing UI

4. **`Event Handlers`**:

   - JavaFX uses event listeners (like setOn Action, setOnMOuseClicked) to capture user interactions with UI
  
5. **`Data Management`**:

---

## 📊 Future Enhancements

- **`Payment Integration`**: Integrate payment gateway for online payments.
- **`Admin Panel`**: Add functionality for laundromat owners to manage and view customer bookings.
- **`Mobile Optimization`**: Make the system responsive for mobile devices for better accessibility.



