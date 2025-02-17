package dev.ghostbuster.asturias.View;

import javax.swing.*;
import java.awt.*;
import dev.ghostbuster.asturias.controller.Controller;

public class GhostViewGUI extends JFrame {
    private final Controller controller;

    public GhostViewGUI(Controller controller) {
        this.controller = controller;

        setTitle("Ghostbusters Asturias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton captureButton = new JButton("Capturar Fantasma");
        JButton viewListButton = new JButton("Ver Lista de Fantasmas Capturados");
        JButton releaseGhostButton = new JButton("Liberar un Fantasma");
        JButton filterByClassButton = new JButton("Filtrar Fantasmas por Clase");
        JButton filterByMonthButton = new JButton("Ver Fantasmas Capturados en un Mes");
        JButton exitButton = new JButton("Salir");

        captureButton.addActionListener(e -> new CaptureGhostView(controller));
        viewListButton.addActionListener(e -> new CapturedGhostsListView(controller));
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(captureButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(viewListButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(releaseGhostButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(filterByClassButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(filterByMonthButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(exitButton);

        JPanel centeredButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredButtonPanel.add(buttonPanel);

        mainPanel.add(centeredButtonPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }
}