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

        JButton capturarFantasma = new JButton("Capturar Fantasma");
        JButton listaFantasmas = new JButton("Ver Lista de Fantasmas Capturados");
        JButton liberarFantasma = new JButton("Liberar un Fantasma");
        JButton filtraClase = new JButton("Filtrar Fantasmas por Clase");
        JButton fantasmasMes = new JButton("Ver Fantasmas Capturados en un Mes");
        JButton salir = new JButton("Salir");

        capturarFantasma.addActionListener(e -> new CaptureGhostView(controller));
        listaFantasmas.addActionListener(e -> new CapturedGhostsListView(controller));
        salir.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(capturarFantasma);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(listaFantasmas);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(liberarFantasma);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(filtraClase);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(fantasmasMes);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(salir);

        JPanel centeredButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredButtonPanel.add(buttonPanel);

        mainPanel.add(centeredButtonPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }
}