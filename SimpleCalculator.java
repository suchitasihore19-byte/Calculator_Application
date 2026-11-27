import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField display;
    JLabel status, expression;

    double num1 = 0;
    String operator = "";
    boolean startNew = true;

    Color bg = new Color(18, 20, 35);
    Color normal = new Color(38, 42, 62);
    Color purple = new Color(112, 85, 230);
    Color blue = new Color(45, 105, 160);

    SimpleCalculator() {

        setTitle("Smart Calculator");
        setSize(390, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main Panel
        JPanel main = new JPanel(new BorderLayout(0, 18));
        main.setBackground(bg);
        main.setBorder(new EmptyBorder(25, 22, 25, 22));

        // Heading
        JPanel heading = new JPanel();
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.setBackground(bg);

        JLabel title = new JLabel("SMART CALCULATOR");
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Simple | Fast | Accurate");
        subtitle.setForeground(new Color(40, 190, 210));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        heading.add(title);
        heading.add(Box.createVerticalStrut(7));
        heading.add(subtitle);

        // Display Panel
        JPanel displayPanel = new JPanel(new BorderLayout(5, 12));
        displayPanel.setBackground(new Color(27, 30, 49));
        displayPanel.setBorder(new EmptyBorder(15, 12, 15, 12));

        status = new JLabel("READY TO CALCULATE");
        status.setFont(new Font("Arial", Font.BOLD, 11));
        status.setForeground(new Color(40, 190, 210));

        expression = new JLabel(" ");
        expression.setFont(new Font("Arial", Font.PLAIN, 18));
        expression.setForeground(new Color(170, 175, 195));
        expression.setHorizontalAlignment(JLabel.RIGHT);

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 34));
        display.setForeground(Color.WHITE);
        display.setBackground(new Color(27, 30, 49));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBorder(null);

        JPanel displayInfo = new JPanel(new BorderLayout(5, 8));
        displayInfo.setBackground(new Color(27, 30, 49));

        displayInfo.add(status, BorderLayout.NORTH);
        displayInfo.add(expression, BorderLayout.CENTER);

        displayPanel.add(displayInfo, BorderLayout.NORTH);
        displayPanel.add(display, BorderLayout.CENTER);

        // Calculator Buttons
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        panel.setBackground(bg);

        String buttons[] = {
            "AC", "DEL", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };

        for (String value : buttons) {

            Color c = normal;

            if (value.equals("=")) {
                c = purple;
            }
            else if (value.equals("/") ||
                     value.equals("*") ||
                     value.equals("-") ||
                     value.equals("+")) {
                c = blue;
            }
            else if (value.equals("AC") ||
                     value.equals("DEL") ||
                     value.equals("%")) {
                c = new Color(75, 53, 110);
            }

            RoundedButton btn = new RoundedButton(value, c);
            btn.addActionListener(this);
            panel.add(btn);
        }

        // Center Panel
        JPanel center = new JPanel(new BorderLayout(0, 18));
        center.setBackground(bg);
        center.add(displayPanel, BorderLayout.NORTH);
        center.add(panel, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("JAVA SWING | OOP ACTIVITY");
        footer.setForeground(new Color(140, 145, 170));
        footer.setFont(new Font("Arial", Font.PLAIN, 10));
        footer.setHorizontalAlignment(JLabel.CENTER);

        main.add(heading, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(footer, BorderLayout.SOUTH);

        add(main);
        setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {

        String value = e.getActionCommand();

        try {

            // Number Buttons
            if (value.matches("[0-9]")) {

                if (startNew || display.getText().equals("0")) {
                    display.setText(value);
                }
                else {
                    display.setText(display.getText() + value);
                }

                startNew = false;

                if (!operator.isEmpty()) {
                    expression.setText(
                        formatNumber(num1) + " " +
                        operator + " " + display.getText()
                    );
                }

                status.setText("ENTERING NUMBER");
            }

            // Decimal Button
            else if (value.equals(".")) {

                if (startNew) {
                    display.setText("0.");
                    startNew = false;
                }
                else if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }

                if (!operator.isEmpty()) {
                    expression.setText(
                        formatNumber(num1) + " " +
                        operator + " " + display.getText()
                    );
                }
            }

            // Clear All
            else if (value.equals("AC")) {

                display.setText("0");
                expression.setText(" ");
                num1 = 0;
                operator = "";
                startNew = true;

                status.setText("READY TO CALCULATE");
            }

            // Delete Last Digit
            else if (value.equals("DEL")) {

                String s = display.getText();

                if (!startNew && s.length() > 1) {
                    display.setText(
                        s.substring(0, s.length() - 1)
                    );
                }
                else {
                    display.setText("0");
                    startNew = true;
                }

                if (!operator.isEmpty()) {
                    expression.setText(
                        formatNumber(num1) + " " +
                        operator + " " + display.getText()
                    );
                }

                status.setText("LAST DIGIT DELETED");
            }

            // Positive / Negative
            else if (value.equals("+/-")) {

                double n = Double.parseDouble(display.getText());

                display.setText(formatNumber(-n));
                startNew = false;

                if (!operator.isEmpty()) {
                    expression.setText(
                        formatNumber(num1) + " " +
                        operator + " " + display.getText()
                    );
                }

                status.setText("SIGN CHANGED");
            }

            // Percentage
            else if (value.equals("%")) {

                double n = Double.parseDouble(display.getText());

                display.setText(formatNumber(n / 100));
                startNew = true;

                if (!operator.isEmpty()) {
                    expression.setText(
                        formatNumber(num1) + " " +
                        operator + " " + display.getText()
                    );
                }
                else {
                    expression.setText(formatNumber(n) + "%");
                }

                status.setText("PERCENTAGE CALCULATED");
            }

            // Equal Button
            else if (value.equals("=")) {

                if (!operator.isEmpty() && !startNew) {

                    double num2 =
                        Double.parseDouble(display.getText());

                    String fullExpression =
                        formatNumber(num1) + " " +
                        operator + " " +
                        formatNumber(num2) + " =";

                    double answer =
                        calculate(num1, num2, operator);

                    display.setText(formatNumber(answer));
                    expression.setText(fullExpression);

                    status.setText("CALCULATION COMPLETE");

                    operator = "";
                    startNew = true;
                }
            }

            // Arithmetic Operators
            else {

                if (!operator.isEmpty() && !startNew) {

                    double num2 =
                        Double.parseDouble(display.getText());

                    num1 = calculate(num1, num2, operator);

                    display.setText(formatNumber(num1));

                }
                else if (operator.isEmpty()) {

                    num1 =
                        Double.parseDouble(display.getText());
                }

                operator = value;
                startNew = true;

                expression.setText(
                    formatNumber(num1) + " " + operator
                );

                status.setText("OPERATION: " + operator);
            }

        }
        catch (ArithmeticException ex) {

            display.setText("Cannot divide by zero");
            expression.setText(" ");
            operator = "";
            startNew = true;
            status.setText("ERROR");
        }
        catch (Exception ex) {

            display.setText("Error");
            expression.setText(" ");
            operator = "";
            startNew = true;
            status.setText("INVALID INPUT");
        }
    }

    // Calculation Method
    double calculate(double a, double b, String op) {

        switch (op) {

            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":

                if (b == 0) {
                    throw new ArithmeticException();
                }

                return a / b;
        }

        return 0;
    }

    // Format Result
    String formatNumber(double n) {

        if (Double.isNaN(n) || Double.isInfinite(n)) {
            return "Error";
        }

        if (n == (long)n) {
            return String.valueOf((long)n);
        }

        return String.format(Locale.US, "%.8f", n)
                .replaceAll("0+$", "")
                .replaceAll("\\.$", "");
    }

    // Custom Rounded Buttons
    class RoundedButton extends JButton {

        Color buttonColor;

        RoundedButton(String text, Color color) {

            super(text);
            buttonColor = color;

            setFont(new Font("Arial", Font.BOLD, 19));
            setForeground(Color.WHITE);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(buttonColor);

            g2.fillRoundRect(
                0, 0, getWidth(), getHeight(), 20, 20
            );

            g2.setColor(Color.WHITE);
            g2.setFont(getFont());

            FontMetrics fm = g2.getFontMetrics();

            int x = (getWidth() -
                fm.stringWidth(getText())) / 2;

            int y = (getHeight() -
                fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(getText(), x, y);

            g2.dispose();
        }
    }

    // Main Method
    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator();
        });
    }
}