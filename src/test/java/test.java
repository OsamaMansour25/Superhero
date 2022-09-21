import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    Superhero s1;
    Superhero s2;
    Database db;
    UserInterface ui;

    @BeforeEach
    void setup() {
        db = new Database();
        ui = new UserInterface();
        s1 = new Superhero("Osama", "SuperOsama", true, 1999, 100, "Stærk");
        s2 = new Superhero("Matt Murdoch", "Daredevil", true, 1888, 100, "Blind");
        db.getDatabaseForSuperHero().add(s1);
        db.getDatabaseForSuperHero().add(s2);
    }
    @Test

    void testTilføjSuperhero() {
        int expectedSize = 3;
        db.tilføjSuperhelt("Superman", "Clark Kent", true, 1939, 100, "Stærk");
        assertEquals(expectedSize, db.getDatabaseForSuperHero().size());

    }
    @Test
    void testSøgSuperhelt() {
        String expectedNavn = "Osama";
        db.søgSuperHero("Osama");
        assertEquals(expectedNavn, s1.getNavn());

    }
    @Test
    void testfejlSøgSuperhelt() {
        String expectedNavn = "SuperOsama";
        db.søgSuperHero("Osama");
        assertEquals(expectedNavn, s1.getNavn());
    }
}

