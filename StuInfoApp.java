package SchoolWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StuInfoApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    private JFrame frame;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea resultArea;

    private Connection connection;

    public StuInfoApp() {
        initializeDB();
        initializeUI();
    }

    private void initializeDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS STUinfo (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT)");
            stmt.close();
        } catch (SQLException e) {
            showError("Database connection or table creation failed: " + e.getMessage());
        }
    }

    private void initializeUI() {
        frame = new JFrame("Student Information Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton queryButton = new JButton("Query");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(queryButton);

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);

        addButton.addActionListener(e -> addStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        updateButton.addActionListener(e -> updateStudent());
        queryButton.addActionListener(e -> queryStudent());

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addStudent() {
        try {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();

            String sql = "INSERT INTO STUinfo (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, name);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.executeUpdate();

            resultArea.setText("Student added successfully.");
        } catch (SQLException e) {
            showError("Failed to add student: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            String id = idField.getText();

            String sql = "DELETE FROM STUinfo WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();

            resultArea.setText("Student deleted successfully.");
        } catch (SQLException e) {
            showError("Failed to delete student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();

            String sql = "UPDATE STUinfo SET name = ?, age = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(age));
            pstmt.setInt(3, Integer.parseInt(id));
            pstmt.executeUpdate();

            resultArea.setText("Student updated successfully.");
        } catch (SQLException e) {
            showError("Failed to update student: " + e.getMessage());
        }
    }

    private void queryStudent() {
        try {
            String id = idField.getText();

            String sql = "SELECT * FROM STUinfo WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resultArea.setText("ID: " + rs.getInt("id") + "\n" +
                        "Name: " + rs.getString("name") + "\n" +
                        "Age: " + rs.getInt("age"));
            } else {
                resultArea.setText("Student not found.");
            }
        } catch (SQLException e) {
            showError("Failed to query student: " + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StuInfoApp::new);
    }
}


