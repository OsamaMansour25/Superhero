public class Database {
    Superhero[] databaseForSuperHero = new Superhero[5];
    int n = 0;

    public void tilføjSuperhelt(String navn, String superNavn, boolean erMenneske, int oprindelsesÅr, double strength, String superKraft) {
        do {
            Superhero superhelt = new Superhero(navn, superNavn, true, oprindelsesÅr, strength, superKraft);
            databaseForSuperHero[n] = superhelt;
            n++;
        } while (n < databaseForSuperHero.length);
    }
}


