package za.ac.prog6112.q2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;

public class EstateAgentApp extends JFrame {
    private final JComboBox<String> locationBox =
            new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
    private final JTextField agentNameField = new JTextField(18);
    private final JTextField propertyPriceField = new JTextField(18);
    private final JTextField commissionField = new JTextField(18);
    private final JTextArea reportArea = new JTextArea(12, 42);
    private final EstateAgent calculator = new EstateAgent();
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));

    public EstateAgentApp() {
        super("Estate Agent Commission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel fields = new JPanel(new GridLayout(4, 2, 8, 8));
        fields.setBorder(BorderFactory.createTitledBorder("Estate agent details"));
        fields.add(new JLabel("Agent location:")); fields.add(locationBox);
        fields.add(new JLabel("Agent name:")); fields.add(agentNameField);
        fields.add(new JLabel("Property price (R):")); fields.add(propertyPriceField);
        fields.add(new JLabel("Commission percentage (%):")); fields.add(commissionField);
        add(fields, BorderLayout.NORTH);

        reportArea.setEditable(false);
        reportArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);
        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process Report");
        JMenuItem clear = new JMenuItem("Clear");
        JMenuItem save = new JMenuItem("Save Report");
        process.addActionListener(e -> processReport());
        clear.addActionListener(e -> clearForm());
        save.addActionListener(e -> saveReport());
        tools.add(process); tools.add(clear); tools.add(save);
        bar.add(file); bar.add(tools);
        setJMenuBar(bar);

        JPanel buttons = new JPanel();
        JButton processButton = new JButton("Process Report");
        JButton clearButton = new JButton("Clear");
        JButton saveButton = new JButton("Save Report");
        processButton.addActionListener(e -> processReport());
        clearButton.addActionListener(e -> clearForm());
        saveButton.addActionListener(e -> saveReport());
        buttons.add(processButton); buttons.add(clearButton); buttons.add(saveButton);
        add(buttons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void processReport() {
        String location = (String) locationBox.getSelectedItem();
        Data data = new Data(location, agentNameField.getText().trim(),
                propertyPriceField.getText().trim(), commissionField.getText().trim());
        if (!calculator.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Enter a location and agent name. Property price and commission percentage must be numeric and greater than zero.",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double price = Double.parseDouble(data.getPropertyPrice());
        double percentage = Double.parseDouble(data.getAgentCommission());
        double commission = calculator.CalculateCommission(data.getPropertyPrice(), data.getAgentCommission());
        String report = "ESTATE AGENT COMMISSION REPORT\n"
                + "-----------------------------------------------\n"
                + "Agent location:          " + location + "\n"
                + "Estate agent name:       " + data.getAgentName() + "\n"
                + "Property price:          " + currency.format(price) + "\n"
                + "Commission percentage:   " + String.format(Locale.ROOT, "%.2f%%", percentage) + "\n"
                + "Commission earned:       " + currency.format(commission) + "\n";
        reportArea.setText(report);
    }

    private void saveReport() {
        if (reportArea.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Process a report before saving it.",
                    "No report", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Files.writeString(Path.of("report.txt"), reportArea.getText());
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save report.txt: " + ex.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        locationBox.setSelectedIndex(0);
        agentNameField.setText("");
        propertyPriceField.setText("");
        commissionField.setText("");
        reportArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstateAgentApp().setVisible(true));
    }
}
