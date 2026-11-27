# Simple Calculator Using Java Swing

## Activity Details

-   **Activity:** CIE-2 Activity-6 -- OOP GUI Application
-   **Project Name:** Simple Calculator
-   **Programming Language:** Java
-   **GUI Technology:** Java Swing
-   **IDE/Editor:** EditPlus

## Project Description

The Simple Calculator is a graphical user interface (GUI) application
developed using Java Swing. It allows users to perform basic arithmetic
calculations through clickable buttons. The interface uses a dark theme,
a display area for the current number and expression, and rounded
calculator buttons.

## Objectives

-   Understand Java GUI programming using Swing.
-   Create a user-friendly calculator interface.
-   Implement event handling using `ActionListener`.
-   Use layout managers to arrange GUI components.
-   Perform basic arithmetic operations.

## Features

-   Addition, subtraction, multiplication, and division.
-   Percentage calculation.
-   Positive/negative sign change.
-   Decimal number input.
-   Clear all (`AC`) and delete last digit (`DEL`).
-   Expression display while calculating.
-   Error handling for division by zero.

## Technologies and Components Used

-   **JFrame:** Creates the main application window.
-   **JPanel:** Groups and organizes components.
-   **JLabel:** Displays status messages and the current expression.
-   **JTextField:** Displays the entered number and result.
-   **JButton:** Provides clickable calculator buttons.
-   **GridLayout:** Arranges calculator buttons in rows and columns.
-   **BorderLayout:** Organizes the main sections of the window.
-   **ActionListener:** Handles button-click events.

## Requirements

-   Java Development Kit (JDK) installed.
-   EditPlus or another Java editor.
-   Windows Command Prompt or terminal.

## How to Compile and Run

1.  Save the source code as `SimpleCalculator.java`.

2.  Open Command Prompt in the folder containing the file.

3.  Compile the program:

    ``` bash
    javac SimpleCalculator.java
    ```

4.  Run the application:

    ``` bash
    java SimpleCalculator
    ```

## Sample Test Cases

    No. Operation             Input                    Expected Result
  ----- --------------------- ---------------------- -----------------
      1 Addition              10 + 20                               30
      2 Subtraction           25 - 10                               15
      3 Multiplication        12 \* 10                             120
      4 Division              100 / 4                               25
      5 Decimal calculation   2.5 + 1.25                          3.75
      6 Percentage            50%                                  0.5
      7 Sign change           25 +/-                               -25
      8 Clear                 Enter 567, press AC                    0
      9 Delete                Enter 123, press DEL                  12

## Screenshots for Submission

1.  `01_Main_Calculator.png` -- Main GUI of Simple Calculator.
2.  `02_Addition.png` -- Output of Addition Operation.
3.  `03_Subtraction.png` -- Output of Subtraction Operation.
4.  `04_Multiplication.png` -- Output of Multiplication Operation.
5.  `05_Division.png` -- Output of Division Operation.

## Project Files

-   `SimpleCalculator.java` -- Java source code.
-   `README.md` -- Project description and instructions.
-   Screenshot files -- Application interface and operation outputs.

## Conclusion

The Simple Calculator demonstrates Java Swing GUI components, event
handling, and layout managers. It provides a simple interface for
performing basic arithmetic operations.

## References

-   Java Documentation: https://docs.oracle.com/javase/
-   Java Swing Tutorial:
    https://docs.oracle.com/javase/tutorial/uiswing/
