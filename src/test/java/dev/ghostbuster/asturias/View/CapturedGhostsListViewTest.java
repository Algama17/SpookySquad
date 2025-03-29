package dev.ghostbuster.asturias.View;

import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.models.Ghost;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CapturedGhostsListViewTest {
    private Controller mockController;
    private CapturedGhostsListView capturedGhostsListView;

    @BeforeEach
    void setUp() {
        mockController = Mockito.mock(Controller.class);
        when(mockController.getAllGhosts()).thenReturn(Arrays.asList(
            new Ghost(1, "Fantasma 1", GhostClassEnum.CLASE_I, GhostDangerLevelEnum.BAJO, "2023-01-01", "Volar", "Afinidad"),
            new Ghost(2, "Fantasma 2", GhostClassEnum.CLASE_II, GhostDangerLevelEnum.ALTO, "2023-02-01", "Invisibilidad", "Afinidad")
        ));
        capturedGhostsListView = new CapturedGhostsListView(mockController);
    }

    @Test
    void testDialogInitialization() {
        assertNotNull(capturedGhostsListView);
        assertEquals("Lista de Fantasmas Capturados", capturedGhostsListView.getTitle());
        assertTrue(capturedGhostsListView.isModal());
        assertTrue(capturedGhostsListView.isVisible());
    }

    @Test
    void testGhostListDisplay() {
        JTextArea textArea = findTextArea(capturedGhostsListView);
        assertNotNull(textArea);

        String expectedText = "Lista de Fantasmas Capturados:\n" +
                "ID: 1, Nombre: Fantasma 1, Clase: Clase I, Nivel de Peligro: Bajo, Habilidad Especial: Volar\n" +
                "ID: 2, Nombre: Fantasma 2, Clase: Clase II, Nivel de Peligro: Alto, Habilidad Especial: Invisibilidad\n";
        assertEquals(expectedText, textArea.getText());
    }

    @Test
    void testCloseButtonAction() {
        JButton closeButton = findButtonByText(capturedGhostsListView, "Cerrar");
        assertNotNull(closeButton);

        closeButton.doClick();
        assertFalse(capturedGhostsListView.isVisible());
    }

    private JTextArea findTextArea(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                Component viewportView = scrollPane.getViewport().getView();
                if (viewportView instanceof JTextArea) {
                    return (JTextArea) viewportView;
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
}