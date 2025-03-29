package dev.ghostbuster.asturias;

import dev.ghostbuster.asturias.controller.Controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AppTest {


    @Test
    void testControllerInitialization() {
        Controller controller = new Controller("Jugador1");


        assertEquals("Jugador1", controller.getPlayerName());
    }
}