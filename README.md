# Java Command-Line File Encryptor

A simple, robust command-line utility built in Java to perform file encryption and decryption using the AES algorithm. This tool can securely encrypt any type of file (text, images, PDFs, etc.) and is built and packaged using Apache Maven.



## Features
-   **Strong Encryption:** Uses AES-128, a symmetric-key algorithm that is an industry standard.
-   **File Agnostic:** Encrypts and decrypts any file type by handling data at the byte level.
-   **Command-Line Interface:** Easy to use and scriptable, with clear arguments for mode, key, and files.
-   **Standalone Application:** Packaged by Maven into a single, runnable JAR file.
-   **Robust Error Handling:** Includes custom exceptions to manage cryptographic and file I/O errors gracefully.

## Prerequisites
To build and run this project, you will need:
-   Java Development Kit (JDK) 8 or higher
-   Apache Maven

## How to Build
1.  Clone the repository:
    ```bash
    git clone [https://github.com/your-username/java-file-encryptor.git](https://github.com/your-username/java-file-encryptor.git)
    ```
2.  Navigate to the project directory:
    ```bash
    cd java-file-encryptor
    ```
3.  Build the project and package it into a runnable JAR:
    ```bash
    mvn clean package
    ```
    The JAR file will be created in the `target/` directory.

## How to Use
The application is run from the terminal with the following command structure:
```
java -jar target/file-encryptor-1.0-SNAPSHOT.jar <mode> <key> <inputFile> <outputFile>
```
-   **`<mode>`**: `encrypt` or `decrypt`.
-   **`<key>`**: A secret key that **must be exactly 16 characters long**.
-   **`<inputFile>`**: The path to the file you want to process.
-   **`<outputFile>`**: The path where the resulting file will be saved.

### Example Usage

#### 1. Encrypting a Text File
```bash
java -jar target/file-encryptor-1.0-SNAPSHOT.jar encrypt "ThisIsA16CharKey" message.txt secret.data
```
This will encrypt `message.txt` and save the result as `secret.data`.

#### 2. Decrypting a Text File
```bash
java -jar target/file-encryptor-1.0-SNAPSHOT.jar decrypt "ThisIsA16CharKey" secret.data revealed.txt
```
This will decrypt `secret.data` using the same key and save the result as `revealed.txt`.

#### 3. Encrypting an Image
```bash
java -jar target/file-encryptor-1.0-SNAPSHOT.jar encrypt "Another16CharKey" photo.jpg encrypted.img
```
This demonstrates that the tool works on binary files like images as well.

### 🛡️ Security Note
This project is for educational purposes to demonstrate Java's cryptographic capabilities and file handling. Passing a secret key directly as a command-line argument is insecure in a production environment, as it can be exposed in your shell history. In a real-world application, keys should be managed through more secure mechanisms.
