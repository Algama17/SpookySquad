package dev.ghostbuster.asturias.View;

import javax.swing.*;
import java.awt.*;
import dev.ghostbuster.asturias.controller.Controller;

public class GhostViewGUI extends JFrame {
    private final Controller controller;

    public GhostViewGUI(Controller controller) {
        this.controller = controller;
        setTitle("Ghostbusters Asturias");
        setSize(1600, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel principal con imagen de fondo
        JPanel mainPanel = new JPanel() {
            private Image backgroundImage;

            {
                backgroundImage = new ImageIcon("resources/images/foto1.jpg").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botones principales
        JButton captureButton = new JButton("Capturar Fantasma");
        JButton listaCapturados = new JButton("Ver lista de fantasmas capturados");
        JButton salir = new JButton("Salir");

        // Tamaño uniforme para los botones
        Dimension buttonSize = new Dimension(200, 30);
        captureButton.setPreferredSize(buttonSize);
        listaCapturados.setPreferredSize(buttonSize);
        salir.setPreferredSize(buttonSize);

        // Acción del botón "Capturar Fantasma"
        captureButton.addActionListener(e -> new CaptureGhostView(controller));

        // Acción del botón "Ver lista de fantasmas capturados"
        listaCapturados.addActionListener(e -> new CapturedGhostsListView(controller));

        // Acción del botón "Salir"
        salir.addActionListener(e -> System.exit(0));

        // Organizar los botones verticalmente
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.add(captureButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(listaCapturados);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(salir);

        // Centrar los botones horizontalmente
        JPanel centeredButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredButtonPanel.setOpaque(false);
        centeredButtonPanel.add(buttonPanel);

        // Agregar componentes al panel principal
        mainPanel.add(centeredButtonPanel, BorderLayout.NORTH);
        add(mainPanel);
        setVisible(true);
    }
}