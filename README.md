# Shamir's Secret Sharing Algorithm Assignment
This project implements a simplified version of Shamir's Secret Sharing algorithm in Java. The code takes input in JSON format, decodes values with different bases, and calculates the constant term 𝑐
c of the polynomial derived from given points using Lagrange interpolation.

## Requirements
Java Development Kit (JDK) 8 or higher
JSON-Simple Library (for JSON parsing)
Download json-simple-1.1.1.jar
Project Structure
plaintext
Copy code

src/
├── ShamirSecretSharing.java
├── testcase1.json
├── testcase2.json
└── json-simple-1.1.1.jar

## Files
ShamirSecretSharing.java: Main Java file that contains the Shamir's Secret Sharing algorithm implementation.
testcase1.json & testcase2.json: Sample JSON input files that contain the polynomial points.
json-simple-1.1.1.jar: External library for parsing JSON files.
Steps to Run the Project
Clone the Repository:

bash
Copy code
git clone <repository-url>
cd Catalog-Assignment/src
Add JSON-Simple Library:

Download json-simple-1.1.1.jar from here.
Place json-simple-1.1.1.jar in the src folder.
Compile the Code:

Open a terminal in the src directory and run:
bash
Copy code
javac -cp ".;json-simple-1.1.1.jar" ShamirSecretSharing.java
Run the Code:

Run the program with:
bash
Copy code
java -cp ".;json-simple-1.1.1.jar" ShamirSecretSharing
Expected Output:

After running, you should see output similar to:
plaintext
Copy code
Secret for test case 1: 3
Secret for test case 2: 79836264046274
Troubleshooting
If you encounter a FileNotFoundException, ensure testcase1.json and testcase2.json are in the same directory as ShamirSecretSharing.java.
Verify you have the correct permissions to read JSON files.
License
This project is licensed under the MIT License.
