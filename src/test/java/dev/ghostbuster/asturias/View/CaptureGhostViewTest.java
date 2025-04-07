package dev.ghostbuster.asturias.View;

import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CaptureGhostViewTest {

    private Controller mockController;
    private CaptureGhostView captureGhostView;

    @BeforeEach
    void setUp() {
        mockController = Mockito.mock(Controller.class);
        captureGhostView = new CaptureGhostView(mockController);
    }

    @Test
    void testDialogInitialization() {
        assertNotNull(captureGhostView);
        assertEquals("Capturar Fantasma", captureGhostView.getTitle());
        assertTrue(captureGhostView.isModal());
        assertTrue(captureGhostView.isVisible());
    }

    @Test
void testCaptureGhostFormSubmission() {
    JTextField nameField = findTextFieldByLabel(captureGhostView, "Nombre:");
    JTextField abilityField = findTextFieldByLabel(captureGhostView, "Habilidad Especial:");
    JComboBox<String> classDropdown = findComboBoxByLabel(captureGhostView, "Clase:");
    JComboBox<String> dangerDropdown = findComboBoxByLabel(captureGhostView, "Nivel de Peligro:");

    assertNotNull(nameField);
    assertNotNull(abilityField);
    assertNotNull(classDropdown);
    assertNotNull(dangerDropdown);

    nameField.setText("Fantasma Test");
    abilityField.setText("Volar");
    classDropdown.setSelectedItem(GhostClassEnum.CLASE_I.getInfoClass());
    dangerDropdown.setSelectedItem(GhostDangerLevelEnum.BAJO.getLevelName());

    JButton okButton = findButtonByText(captureGhostView, "OK");
    assertNotNull(okButton);

    okButton.doClick();

    verify(mockController).captureGhost(
        eq("Fantasma Test"),
        eq(GhostClassEnum.CLASE_I),
        eq(GhostDangerLevelEnum.BAJO),
        eq("Volar"),
        eq("Afinidad")
    );

    assertFalse(captureGhostView.isVisible());
}

    @Test
    void testCancelButtonAction() {
        JButton cancelButton = findButtonByText(captureGhostView, "Cancelar");
        assertNotNull(cancelButton);

        cancelButton.doClick();

        assertFalse(captureGhostView.isVisible());
    }

    private JTextField findTextFieldByLabel(Container container, String labelText) {
        for (Component component : container.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                for (Component child : panel.getComponents()) {
                    if (child instanceof JLabel && ((JLabel) child).getText().equals(labelText)) {
                        Component nextSibling = panel.getComponent(panel.getComponentZOrder(child) + 1);
                        if (nextSibling instanceof JTextField) {
                            return (JTextField) nextSibling;
                        }
                    }
                }
            }
        }
        return null;
    }


    private JComboBox<String> findComboBoxByLabel(Container container, String labelText) {
    for (Component component : container.getComponents()) {
        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            for (Component child : panel.getComponents()) {
                if (child instanceof JLabel && ((JLabel) child).getText().equals(labelText)) {
                    Component nextSibling = panel.getComponent(panel.getComponentZOrder(child) + 1);
                    if (nextSibling instanceof JComboBox<?>) {
                        @SuppressWarnings("unchecked")
                        JComboBox<String> comboBox = (JComboBox<String>) nextSibling;
                        return comboBox;
                    }
                }
            }
        }
    }
    return null;
}

    private JButton findButtonByText(Container container, String text) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(text)) {
                    return button;
                }
            } else if (component instanceof Container) {
                JButton button = findButtonByText((Container) component, text);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
    @Test
    void testFormSubmissionWithEmptyFields() {
        JTextField nameField = findTextFieldByLabel(captureGhostView, "Nombre:");
        JTextField abilityField = findTextFieldByLabel(captureGhostView, "Habilidad Especial:");
        JComboBox<String> classDropdown = findComboBoxByLabel(captureGhostView, "Clase:");
        JComboBox<String> dangerDropdown = findComboBoxByLabel(captureGhostView, "Nivel de Peligro:");
    
        assertNotNull(nameField);
        assertNotNull(abilityField);
        assertNotNull(classDropdown);
        assertNotNull(dangerDropdown);
    
        nameField.setText(""); // Nombre vacío
        abilityField.setText("Volar");
        classDropdown.setSelectedItem(GhostClassEnum.CLASE_I.getInfoClass());
        dangerDropdown.setSelectedItem(GhostDangerLevelEnum.BAJO.getLevelName());
    
        JButton okButton = findButtonByText(captureGhostView, "OK");
        assertNotNull(okButton);
    
        okButton.doClick();
    
        verify(mockController, never()).captureGhost(anyString(), any(GhostClassEnum.class), any(GhostDangerLevelEnum.class), anyString(), anyString());
        assertTrue(captureGhostView.isVisible());
    }
}