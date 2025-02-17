package dev.ghostbuster.asturias.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;

public class CaptureGhostView extends JDialog {
    public CaptureGhostView(Controller controller) {
        super((JFrame) null, "Capturar Fantasma", true);
        setSize(400, 300);
        setLayout(new BorderLayout());


        JTextField nameField = new JTextField();
        JTextField abilityField = new JTextField();
        JComboBox<String> classDropdown = new JComboBox<>(GhostClassEnum.getDisplayNames());
        JComboBox<String> dangerDropdown = new JComboBox<>(GhostDangerLevelEnum.getDisplayNames());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Clase:"));
        formPanel.add(classDropdown);
        formPanel.add(new JLabel("Nivel de Peligro:"));
        formPanel.add(dangerDropdown);
        formPanel.add(new JLabel("Habilidad Especial:"));
        formPanel.add(abilityField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancelar");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText().trim();
                String ability = abilityField.getText().trim();
                String ghostClass = (String) classDropdown.getSelectedItem();
                String dangerLevel = (String) dangerDropdown.getSelectedItem();

                if (name.isEmpty() || ability.isEmpty() || ghostClass == null || dangerLevel == null) {
                    JOptionPane.showMessageDialog(
                        CaptureGhostView.this,
                        "Todos los campos son obligatorios.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                GhostClassEnum ghostClassEnum = GhostClassEnum.fromDisplayName(ghostClass);
                GhostDangerLevelEnum dangerLevelEnum = GhostDangerLevelEnum.fromDisplayName(dangerLevel);

                controller.captureGhost(name, ghostClassEnum, dangerLevelEnum, ability, "Afinidad");

                dispose();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}