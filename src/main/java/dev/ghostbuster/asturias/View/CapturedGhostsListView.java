package dev.ghostbuster.asturias.View;

import javax.swing.*;
import java.util.List;
import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.Ghost;
import java.awt.BorderLayout;

public class CapturedGhostsListView extends JDialog {
    public CapturedGhostsListView(Controller controller) {
        super((JFrame) null, "Lista de Fantasmas Capturados", true);
        setSize(600, 400);
        setLayout(new BorderLayout());


        JTextArea ghostListArea = new JTextArea();
        ghostListArea.setEditable(false);

        List<Ghost> ghosts = controller.getAllGhosts();
        StringBuilder allGhosts = new StringBuilder("Lista de Fantasmas Capturados:\n");
        if (ghosts.isEmpty()) {
            allGhosts.append("No hay fantasmas capturados aún.\n");
        } else {
            for (Ghost ghost : ghosts) {
                allGhosts.append("ID: ").append(ghost.getId())
                        .append(", Nombre: ").append(ghost.getGhostName())
                        .append(", Clase: ").append(ghost.getGhostClass().getInfoClass())
                        .append(", Nivel de Peligro: ").append(ghost.getDangerLevel().getLevelName())
                        .append(", Habilidad Especial: ").append(ghost.getSpecialAbility())
                        .append("\n");
            }
        }

        ghostListArea.setText(allGhosts.toString());

        JScrollPane scrollPane = new JScrollPane(ghostListArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}