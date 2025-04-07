package dev.ghostbuster.asturias.View;

import dev.ghostbuster.asturias.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GhostViewGUITest {

    private Controller mockController;
    private GhostViewGUI ghostViewGUI;

    @BeforeEach
    void setUp() {
        mockController = mock(Controller.class);
        ghostViewGUI = new GhostViewGUI(mockController);
    }

    @Test
    void testWindowInitialization() {
        assertNotNull(ghostViewGUI);
        assertEquals("Ghostbusters Asturias", ghostViewGUI.getTitle());
        assertEquals(800, ghostViewGUI.getWidth());
        assertEquals(600, ghostViewGUI.getHeight());
        assertTrue(ghostViewGUI.isDisplayable());
    }

    @Test
    void testExitButtonAction() {
        JButton exitButton = findButtonByText(ghostViewGUI, "Salir");
        assertNotNull(exitButton);

        exitButton.doClick();
        assertFalse(ghostViewGUI.isDisplayable());
    }

    @Test
void testCaptureGhostButtonAction() {
    JButton captureButton = findButtonByText(ghostViewGUI, "Capturar Fantasma");
    assertNotNull(captureButton);


    captureButton.doClick();
    Window[] windows = Window.getWindows();
    boolean captureDialogFound = false;
    for (Window window : windows) {
        if (window instanceof JDialog && ((JDialog) window).getTitle().equals("Capturar Fantasma")) {
            captureDialogFound = true;
            break;
        }
    }
    assertTrue(captureDialogFound);
}

@Test
void testViewListButtonAction() {
    JButton viewListButton = findButtonByText(ghostViewGUI, "Ver Lista de Fantasmas Capturados");
    assertNotNull(viewListButton);

    viewListButton.doClick();

    Window[] windows = Window.getWindows();
    boolean listDialogFound = false;
    for (Window window : windows) {
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            if (dialog.getTitle().equals("Lista de Fantasmas Capturados")) {
                listDialogFound = true;
                break;
            }
        }
    }
    assertTrue(listDialogFound);
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