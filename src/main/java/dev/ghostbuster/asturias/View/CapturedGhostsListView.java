package dev.ghostbuster.asturias.View;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.Ghost;

public class CapturedGhostsListView extends JDialog {
    public CapturedGhostsListView(GhostController ghostController) {
        super((JFrame) null, "Lista de Fantasmas Capturados", true);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Área de texto para mostrar resultados
        JTextArea resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        resultArea.setOpaque(false);
        resultArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        // Obtener la lista de fantasmas capturados
        List<Ghost> ghosts = ghostController.getGhosts();
        StringBuilder allGhosts = new StringBuilder("Lista de Fantasmas Capturados:\n");
        for (Ghost ghost : ghosts) {
            allGhosts.append("ID: ").append(ghost.getId())
                     .append(", Nombre: ").append(ghost.getName())
                     .append(", Clase: ").append(ghost.getClassType().getDisplayName())
                     .append(", Nivel de Peligro: ").append(ghost.getDangerLevel().getDisplayName())
                     .append(", Habilidad especial: ").append(ghost.getSpecialAbility())
                     .append("\n");
        }
        resultArea.setText(allGhosts.toString());

        // Panel inferior con fondo semitransparente
        JPanel bottomPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bottomPanel.setOpaque(false);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        add(bottomPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}