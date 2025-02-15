package dev.ghostbuster.asturias.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;

public class CaptureGhostView extends JDialog {
    public CaptureGhostView(Controller ghostController) {
        super((JFrame) null, "Capturar Fantasma", true);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Panel con fondo personalizado
        JPanel dialogPanel = new JPanel() {
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
        dialogPanel.setLayout(new BorderLayout());
        dialogPanel.setOpaque(false);

        // Formulario para capturar fantasmas
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setOpaque(false);

        JTextField nameField = new JTextField();
        JComboBox<String> classDropdown = new JComboBox<>(GhostClassEnum.getDisplayNames());
        JComboBox<String> dangerDropdown = new JComboBox<>(GhostDangerLevelEnum.getDisplayNames());
        JTextField abilityField = new JTextField();

        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Clase:"));
        formPanel.add(classDropdown);
        formPanel.add(new JLabel("Nivel de Peligro:"));
        formPanel.add(dangerDropdown);
        formPanel.add(new JLabel("Habilidad Especial:"));
        formPanel.add(abilityField);

        // Botones de acción
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        JButton okButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String selectedClass = (String) classDropdown.getSelectedItem();
                GhostClassEnum classType = GhostClassEnum.valueOf(selectedClass.replace(" ", "_").toUpperCase());
                String selectedDanger = (String) dangerDropdown.getSelectedItem();
                GhostDangerLevelEnum dangerLevel = GhostDangerLevelEnum.valueOf(selectedDanger.replace(" ", "_").toUpperCase());
                String specialAbility = abilityField.getText().trim();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(CaptureGhostView.this, "El campo 'Nombre' es obligatorio.");
                    return;
                }
                if (specialAbility.isEmpty()) {
                    JOptionPane.showMessageDialog(CaptureGhostView.this, "El campo 'Habilidad Especial' es obligatorio.");
                    return;
                }

                ghostController.captureGhost(name, classType, dangerLevel, specialAbility);
                JOptionPane.showMessageDialog(CaptureGhostView.this, "Fantasma \"" + name + "\" capturado exitosamente.");
                dispose();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        // Agregar componentes al diálogo
        dialogPanel.add(formPanel, BorderLayout.CENTER);
        dialogPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(dialogPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}