# Java Fundamentals Training Projects - January 2023

Welcome to the Java Fundamentals training projects repository for January 2023! These projects are a compilation of exercises completed during a comprehensive Java Fundamentals course that I attended in January 2023 at SoftUni. The repository is organized into different modules, each dedicated to specific aspects of Java programming.

It's important to note that these projects are educational in nature and were created as part of the coursework. While they may reinforce someone's fundamental concepts, they do not have practical applications and are not intended for use in real-world scenarios. You can find the different project modules inside the `src` directory, classified by the following subdirectories:

- Arrays
- AssociativeArrays
- BasicSyntax
- DataTypesAndVariables
- Lists
- Methods
- MidExam
- ObjectAndClasses
- RegularExpressions
- Tests
- TextProcessing

Each module consists of multiple `.java` exercises to reinforce your understanding of Java fundamentals.

## Table of Contents

- [Description](#description)
- [Technologies Used](#technologies-and-ide-used)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)

## Description

The repository encompasses both theoretical 'Lab' and practical 'Exercise' aspects of a comprehensive Java Fundamentals course. You'll find a variety of training exercises within each module to enhance your programming skills.

## Technologies and IDE Used

- IntelliJ IDEA Community
- JDK 18

## Prerequisites

Ensure you have the following installed on your machine:

- Java Development Kit (JDK) 18
- Any additional dependencies specified in the project's README or source code comments

## How to Run

While these projects are primarily designed for educational purposes and are not intended for end-use/production, you can still compile and run them to explore the code further. Follow the steps below:

### Steps

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Grrr1337/SoftUni-Java-Basics.git
   ```
2. Navigate to Project Directory:
    ```bash
    cd cd Java_Fund_Jan_2023/[project_folder]
    ```
3. Compile the code:
    ```bash
    # This command compiles the Java source code files and places the compiled bytecode in the bin directory.
    javac -d bin src/*.java
    ```
3. Create a JAR File:
    ```bash
    # Replace [project_filename] with the desired name for your JAR file and [MainClass] with the main class of your project.
    jar cfe [project_filename].jar [MainClass] -C bin .
4. Run the JAR File:
    ```bash 
    # Example command to run the project
    java -jar [project_filename].jar
    ```
