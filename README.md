# 🎬 Java Exception Handling & Cinema Seat Reservation System

---

## 📄 Description – Exercise Overview

This repository contains a Java-based practice project focused on learning how to manage **exceptions**, create **custom exception classes**, and apply **good OOP practices** in real-world inspired scenarios like a **cinema seat reservation system**.

The exercises are divided into 3 levels, each increasing in complexity and scope, from basic exception throwing and handling to implementing a full-featured interactive reservation system.

> ⚠️ Use **Eclipse** or **IntelliJ IDEA** for all exercises.  
> ✅ Follow best practices described in Sprint 0.  
> ✅ You can build with **Maven**, **Gradle**, or plain Java.  
> ✅ Code must be written in **English**.

---

## 🎯 Objectives

- Learn to handle **Java exceptions** to build robust and fault-tolerant code.

---

## 💻 Technologies Used

- Java 17+
- Eclipse / IntelliJ IDEA
- Git & GitHub

---

## 📋 Requirements

- JDK 17 or later
- Java IDE (Eclipse or IntelliJ)
- Git installed locally

---

## 🛠️ Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/luriguso/Task_S1_02_Exceptions.git
   cd Task_S1_02_Exceptions
   ```

2. Open the project in your IDE:
   - **Eclipse**: File → Open Projects from File System
   - **IntelliJ**: File → Open → Select the project folder

3. Run the main classes provided for each level to test functionality.

---

## ▶️ Execution

- Go to the `Main` class or relevant class in each level.
- Run the program.
- Follow the prompts in the console.

---

## 🧩 Exercise Levels Overview

### 🔹 Level 1 – Sales and Exception Basics

#### Exercise 1
- Create a `Product` class with name and price.
- Create a `Sale` class that contains a list of products and a method `calculateTotal()`.
- If the product list is empty, throw a custom exception `Empty_sale_exception` with the message:
  > “To make a sale, you must first add products.”

#### Bonus
- Demonstrate handling a built-in exception: `IndexOutOfBoundsException`.

---

### 🔹 Level 2 – Safe Console Input with Scanner

#### Exercise 1
- Create a utility class `Input` with static methods:
  - `readByte(String message)`
  - `readInt(String message)`
  - `readFloat(String message)`
  - `readDouble(String message)`
  - `readChar(String message)` — Custom Exception
  - `readString(String message)` — Custom Exception
  - `readYesORNot(String message)` — returns true if "Y", false if "N"

Each method must loop until valid input is provided and handle exceptions like `InputMismatchException` or your own.

---

### 🔹 Level 3 – Cinema Seat Reservation System

A complete OOP application to reserve and manage cinema seats.

#### Main Components:

- **Main Class**: Start the application by creating a `cinema` class object
- **Seat**:
  - Attributes: rows_number, seat_number, reservation_name
  - Methods: constructor, `equals`, `toString`, `getRow_number`, `getSeat_number`, `getReservation_name`
- **Cinema**:
  - Holds config (rows_number, seat_number_row) and delegates logic to managers
  - Handles initialization and user interaction
- **CinemaManagement**:
  - Manages operations like showing seats, reserving, canceling, etc.
  - Throws custom exceptions if inputs are invalid:
    - `Bad_Person`
    - `Bad_Row`
    - `Bad_Seat_Number`
- **SeatManagement**:
  - Manages internal seat list (ArrayList)
  - Methods to add, remove, and search seats
  - Throws exceptions like:
    - `Exception_Seat_Occupied`
    - `Exception_Free_Seat`

---

## ✨ Author

**Your Name / Team**  
🌐 [GitHub Profile](https://github.com/luriguso)
