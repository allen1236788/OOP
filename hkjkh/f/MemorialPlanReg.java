import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class MemorialPlanReg extends JFrame {

    
    private databaseManager dbManager = new databaseManager(); 
    
    private static final Color DARK_BLUE = new Color(28, 40, 51);
    private static final Color LIGHT_BLUE = new Color(52, 152, 219);
    private static final Color WHITE = new Color(236, 240, 241);
    private static final Color GRAY = new Color(189, 195, 199);

    private JTextField firstNameField, middleNameField, lastNameField, contactNumberField;
    private JButton registerButton;
    private JPanel mainPanel;
    private float opacity = 0f;
    private BufferedImage backgroundImage;

    public MemorialPlanReg() {
        loadBackgroundImage();
        setupFrame();
        createMainPanel();
        addDragListener();
        fadeIn();
        setupForm();
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(new File("resources/background.jpg"));
        } catch (Exception e) {
            System.err.println("Failed to load background image.");
        }
    }

    private void setupFrame() {
        setTitle("Memorial Plan Registration");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, screenSize.getWidth(), screenSize.getHeight(), 40, 40));
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new GridBagLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                if (backgroundImage != null) {
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                g2d.setColor(new Color(0, 0, 0, 180));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(new Color(255, 255, 255, 15));
                g2d.fillOval(-50, -50, 200, 200);
                g2d.fillOval(getWidth() - 100, getHeight() - 100, 150, 150);
                g2d.dispose();
            }
        };
        mainPanel.setOpaque(false);
        add(mainPanel);
    }

    private void setupForm() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 30, 15, 30);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Memorial Plan Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setForeground(WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        addField("First Name:", firstNameField = createField(), gbc, 1, formPanel);
        addField("Middle Name:", middleNameField = createField(), gbc, 2, formPanel);
        addField("Last Name:", lastNameField = createField(), gbc, 3, formPanel);
        addField("Contact Number:", contactNumberField = createField(), gbc, 4, formPanel);

        registerButton = createButton("Register");
        registerButton.setPreferredSize(new Dimension(250, 50));
        
        registerButton.addActionListener(e -> {
        if (validateFields()) {
            String fName = firstNameField.getText().toUpperCase().trim();
            String mName = middleNameField.getText().toUpperCase().trim();
            String lName = lastNameField.getText().toUpperCase().trim();
            String contact = contactNumberField.getText().trim();
            String Lot="".toUpperCase();
            double payment=0.0;
            double balance=0.0; 
            int generatedId = dbManager.registerUser(fName, mName, lName, contact, Lot,payment,balance);
            if (generatedId!=-1) {
                JOptionPane.showMessageDialog(this,
                    "Registration Successful!\nYour User ID: " + generatedId,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    new GUImain().setVisible(true);

                new Window1(generatedId).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Registration failed. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(registerButton, gbc);

        mainPanel.add(formPanel);

        JButton closeButton = createButton("×");
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        closeButton.setForeground(WHITE);
        closeButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(e -> System.exit(0));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(closeButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        addHover();
    }

    private JTextField createField() {
        JTextField field = new JTextField(20) {
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setColor(getBackground());
                    g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        field.setOpaque(false);
        field.setBackground(WHITE);
        field.setForeground(DARK_BLUE);
        field.setCaretColor(DARK_BLUE);
        field.setBorder(new RoundedCornerBorder());
        field.setFont(new Font("SansSerif", Font.PLAIN, 20));
        field.setPreferredSize(new Dimension(300, 45));
        return field;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(getModel().isPressed() ? LIGHT_BLUE.darker()
                        : getModel().isRollover() ? LIGHT_BLUE.brighter() : LIGHT_BLUE);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setForeground(WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void addField(String label, JTextField field, GridBagConstraints gbc, int row, JPanel panel) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel lbl = new JLabel(label);
        lbl.setForeground(WHITE);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
        panel.add(lbl, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void fadeIn() {
        setOpacity(0f);
        Timer timer = new Timer(20, e -> {
            opacity += 0.1f;
            if (opacity >= 1f) {
                opacity = 1f;
                ((Timer) e.getSource()).stop();
            }
            setOpacity(opacity);
        });
        timer.start();
    }

    private void addDragListener() {
        Point offset = new Point();
        mainPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                offset.setLocation(e.getPoint());
            }
        });
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - offset.x, p.y + e.getY() - offset.y);
            }
        });
    }

    private void addHover() {
        JTextField[] fields = { firstNameField, middleNameField, lastNameField, contactNumberField };
        for (JTextField field : fields) {
            field.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    field.setBackground(new Color(245, 245, 245));
                }

                public void focusLost(FocusEvent e) {
                    field.setBackground(WHITE);
                }
            });
        }
    }

    private boolean validateFields() {
        JTextField[] fields = { firstNameField, middleNameField, lastNameField, contactNumberField };
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!contactNumberField.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Contact Number must be numeric.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MemorialPlanReg().setVisible(true));
    }

    // Custom rounded border class
    private static class RoundedCornerBorder extends AbstractBorder {
        private static final int ARC_WIDTH = 15;
        private static final int ARC_HEIGHT = 15;

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.GRAY);
            g2d.setStroke(new BasicStroke(1));
            g2d.drawRoundRect(x, y, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT);
            g2d.dispose();
        }

        public Shape getBorderShape(int x, int y, int w, int h) {
            return new RoundRectangle2D.Float(x, y, w, h, ARC_WIDTH, ARC_HEIGHT);
        }
    }
}

