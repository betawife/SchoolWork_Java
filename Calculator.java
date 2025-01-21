package SchoolWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();

    public Calculator() {
        setTitle("模拟计算器—江海大");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "←", "%", "√"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "C":
                    currentInput.setLength(0);
                    break;
                case "←":
                    if (currentInput.length() > 0) {
                        currentInput.deleteCharAt(currentInput.length() - 1);
                    }
                    break;
                case "=":
                    try {
                        double result = evaluateExpression(currentInput.toString());
                        currentInput.setLength(0);
                        currentInput.append(result);
                    } catch (Exception ex) {
                        currentInput.setLength(0);
                        currentInput.append("Error");
                    }
                    break;
                case "%":
                    try {
                        double value = Double.parseDouble(currentInput.toString());
                        currentInput.setLength(0);
                        currentInput.append(value / 100);
                    } catch (NumberFormatException ex) {
                        currentInput.setLength(0);
                        currentInput.append("Error");
                    }
                    break;
                case "√":
                    try {
                        double value = Double.parseDouble(currentInput.toString());
                        currentInput.setLength(0);
                        currentInput.append(Math.sqrt(value));
                    } catch (NumberFormatException ex) {
                        currentInput.setLength(0);
                        currentInput.append("Error");
                    }
                    break;
                default:
                    currentInput.append(command);
                    break;
            }
            display.setText(currentInput.toString());
        }
    }

    private double evaluateExpression(String expression) throws Exception {
        // This is a simple implementation and may not handle all edge cases or complex expressions correctly.
        // For a more robust solution, consider using a library like exp4j or writing a custom parser.
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}


