import java.util.ArrayList;

public class Database {
    // Vi vil lave flere superhelte, derfor er en array mest oplagt her.
    private ArrayList<Superhero> databaseForSuperHero = new ArrayList();

    // Vi laver en funktion der tilføjer variablerne til vores superhelt. Do while funktionen gør at den kører gennem
    // alle index pladser som er n i dette tilfælde.
    public void tilføjSuperhelt(String navn, String superNavn, boolean erMenneske, int oprindelsesÅr, double strength, String superKraft) {
        Superhero superhelt1 = new Superhero(navn, superNavn, erMenneske, oprindelsesÅr, strength, superKraft);
        databaseForSuperHero.add(superhelt1);

    }

    public ArrayList<Superhero> getDatabaseForSuperHero() {
        return databaseForSuperHero;
    }

    public Superhero søgSuperHero(String navn) {
        for (int n = 0; n < databaseForSuperHero.size(); n++) {

            if (databaseForSuperHero.get(n).getsuperNavn().equals(navn)) {
                return databaseForSuperHero.get(n);
                /* Kan også gøres sådan:
                for (Superhero forSuperHero : databaseForSuperHero) {

            if (forSuperHero.getsuperNavn().equals(navn)) {
                return forSuperHero;
                 */

            }
        }
        return null;
    }
}

