# Pet Adoption Center

A JavaFX desktop application for managing pet adoptions, built with MVC architecture and modern design principles.

## 📋 Project Description

The Pet Adoption Center is a comprehensive desktop application that streamlines the pet adoption process for both customers and shelter managers. The application features a dual-role system where customers can browse and adopt available animals, while managers have administrative capabilities to manage inventory and user accounts.

Built using JavaFX with FXML and CSS styling, the application demonstrates professional software development practices including proper separation of concerns, error handling, and user-friendly interface design.

## ✨ Features

### Customer Features
- **User Authentication** - Secure login system with username and email validation
- **Animal Browsing** - View all available animals with detailed information
- **Adoption System** - Adopt pets with built-in adoption limits (2 per animal type)
- **Personal Dashboard** - Track adopted animals and view adoption history
- **Real-time Updates** - Live filtering of available animals

### Manager Features
- **Administrative Dashboard** - Complete overview of all animals and their status
- **Animal Management** - Add new animals and remove unadopted ones
- **Advanced Filtering** - Filter animals by type (Cat, Dog, Rabbit) or view all
- **User Management** - View complete list of registered users
- **Adoption Tracking** - Monitor which animals are adopted and available

### Technical Features
- **MVC Architecture** - Clean separation of Model, View, and Controller components
- **Data Binding** - JavaFX properties for automatic UI updates
- **Custom Exception Handling** - Professional error management with user-friendly dialogs
- **Observer Pattern** - Real-time data synchronization across views
- **Professional UI Design** - Custom CSS styling with consistent branding


## 🚀 How to Run

### Prerequisites
- **Java 8 or higher** with JavaFX support
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/ZyadKamalHamed/pet-adoption-center.git
   cd pet-adoption-center
   ```

2. **Open in Your IDE**
   - Import the project into your preferred Java IDE
   - Ensure JavaFX libraries are properly configured

3. **Compile the Application**
   ```bash
   # Navigate to the src directory
   cd src
   
   # Compile all Java files
   javac -cp "." **/*.java
   ```

4. **Run the Application**
   ```bash
   # From the src directory
   java Prog2AdoptionCentreApp
   ```

### Login Credentials

**Test Customers:**
- Username: `1`, Email: `1`
- Username: `Dahyun Kim`, Email: `dahyun@twice.com`
- Username: `Zyzz`, Email: `Aziz@gains.net`

**Test Managers:**
- Manager ID: `12345` (David Dyer)
- Manager ID: `48954` (Rishik Sood)

## 🛠️ Technologies Used

### Core Technologies
- **Java 8** - Main programming language
- **JavaFX** - GUI framework for desktop applications
- **FXML** - XML markup for UI layout and structure
- **CSS** - Custom styling and visual design

### Design Patterns & Architecture
- **Model-View-Controller (MVC)** - Architectural pattern for separation of concerns
- **Observer Pattern** - For real-time data updates using JavaFX properties
- **Factory Pattern** - Animal creation in AddAnimalController
- **Lookup Pattern** - Efficient data retrieval in Animals class

### Development Tools
- **IntelliJ IDEA** - Integrated Development Environment
- **Git** - Version control system
- **GitHub** - Code repository and project hosting

## 📁 Project Structure

```
src/
├── controller/              # UI Controllers (MVC Controller layer)
│   ├── AddAnimalController.java
│   ├── CustomerDashboardController.java
│   ├── DetailsController.java
│   ├── ErrorController.java
│   ├── LoginController.java
│   ├── ManagerDashboardController.java
│   └── UserListController.java
├── model/                   # Business Logic & Data (MVC Model layer)
│   ├── Animals/            # Animal entities and collections
│   │   ├── Animal.java
│   │   ├── Animals.java
│   │   ├── Cat.java
│   │   ├── Dog.java
│   │   └── Rabbit.java
│   ├── Users/              # User entities and authentication
│   │   ├── User.java
│   │   ├── Users.java
│   │   ├── Customer.java
│   │   └── Manager.java
│   ├── Application/        # Main application logic
│   │   └── AdoptionCentre.java
│   └── Exceptions/         # Custom exception classes
│       ├── InvalidOperationException.java
│       └── UnauthorizedAccessException.java
├── view/                   # FXML files and CSS (MVC View layer)
│   ├── AddAnimalView.fxml
│   ├── CustomerDashboard.fxml
│   ├── DetailsView.fxml
│   ├── ErrorView.fxml
│   ├── LoginView.fxml
│   ├── ManagerDashboard.fxml
│   ├── UserListView.fxml
│   └── style.css
├── au/edu/uts/ap/javafx/   # Base controller framework
│   ├── Controller.java
│   └── ViewLoader.java
└── Prog2AdoptionCentreApp.java  # Main application entry point
```

## 🎯 Key Learning Outcomes

This project demonstrates proficiency in:
- **Object-Oriented Programming** - Inheritance, polymorphism, encapsulation
- **GUI Development** - Professional desktop application design
- **Design Patterns** - MVC, Observer, Factory patterns implementation
- **Data Management** - Observable collections and property binding
- **Error Handling** - Custom exceptions and user-friendly error dialogs
- **Software Architecture** - Clean code organization and separation of concerns

## 🤝 Contributing

This was an educational project created for Programming 2 class at UTS and for portfolio demonstration. While not actively seeking contributions, feedback and suggestions are always welcome!

## 👨‍💻 Author

**Zyad Kamal Hamed**
- GitHub: [@ZyadKamalHamed](https://github.com/ZyadKamalHamed)
- Email: [zyad2408@live.com.au]
- linkedin: [https://www.linkedin.com/in/zyadkamalhamed/]

## 🖼️ Screenshots

### Login Screen

![Screenshot 2025-06-20 141129](https://github.com/user-attachments/assets/dc7ed8e1-5cac-4f45-9636-2177bc83172e)
![Screenshot 2025-06-20 141137](https://github.com/user-attachments/assets/53a33b41-6ad8-43c5-9bb5-94a89db73665)

### Customer Dashboard
![Screenshot 2025-06-20 141158](https://github.com/user-attachments/assets/2396ca3c-42c8-44c3-bc01-7c2f826d4115)
![Screenshot 2025-06-20 141235](https://github.com/user-attachments/assets/0d5ac9eb-e5fa-411f-88fb-e1680369eaf0)

### Manager Dashboard
![Screenshot 2025-06-20 141311](https://github.com/user-attachments/assets/cac7bd7b-b4e4-4ae2-97ff-4226a3f14450)
![Screenshot 2025-06-20 141342](https://github.com/user-attachments/assets/9cf5c24d-3164-40cc-8f8a-4049dc74d028)
![Screenshot 2025-06-20 141408](https://github.com/user-attachments/assets/cfb0a9a0-8172-4226-9b58-5c21239177d6)
![Screenshot 2025-06-20 141446](https://github.com/user-attachments/assets/c3016a36-7254-49fe-bc59-8c20cb7c194e)

### Error Window
![Screenshot 2025-06-20 141454](https://github.com/user-attachments/assets/5c16455d-dd23-4a02-aebb-84e271e822d1)
---

*Built as part of Programming 2 coursework, demonstrating JavaFX application development, MVC architecture, and professional software development practices.*
