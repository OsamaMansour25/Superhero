public class Database {
    // Vi vil lave flere superhelte, derfor er en array mest oplagt her.
    Superhero[] databaseForSuperHero = new Superhero[5];
    // Vi laver vores index variabel
    int n = 0;
// Vi laver en funktion der tilføjer variablerne til vores superhelt. Do while funktionen gør at den kører gennem
    // alle index pladser som er n i dette tilfælde.
    public void tilføjSuperhelt(String navn, String superNavn, boolean erMenneske, int oprindelsesÅr, double strength, String superKraft) {
        do {
            Superhero superhelt = new Superhero(navn, superNavn, true, oprindelsesÅr, strength, superKraft);
            databaseForSuperHero[n] = superhelt;
            n++;
        } while (n < databaseForSuperHero.length);
    }
}


