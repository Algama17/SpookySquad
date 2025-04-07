package dev.ghostbuster.asturias;

import dev.ghostbuster.asturias.controller.Controller;
import dev.ghostbuster.asturias.View.GhostViewGUI;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller("Jugador1");
        SwingUtilities.invokeLater(() -> new GhostViewGUI(controller));
    }
}