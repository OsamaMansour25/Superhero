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
// Vi laver en metode/funktion der søger efter en bestemt super helt
    // Funktionen kører igennem et loop hvor den kører gennem positionerne/indekserne hvor den scanner efter et navn i de indekser.
    // If metoden beskriver, at hvis databaseForSuperHero indekset indeholder et superNavn så svarer den til (String navn) i funktionen og i det tilfælde skal den returnere
    // hele indekset, altså alle detaljer for superhelten.
    // (String navn) er det som funktionen skal søge efter. Altså superNavn svarer til vores (String navn) som så svarer til Stringen søgHelt som er lavet i Main
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

