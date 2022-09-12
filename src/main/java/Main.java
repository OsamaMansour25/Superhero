import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vi bringer vores database class ind i main (Instiansiere)
        Database superheroDataBase = new Database();


// Vi laver en masse bruger input for at modtage input og tilføjer scanner.
        System.out.println("Velkommen til superhelte databasen! Indtast oplysninger om din superhelt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast Super-helte navnet på din superhelt");
        String navn = sc.nextLine();
        System.out.println("Hvis din superhelt har et menneske navn så indtast det her, ellers skriv ingen");
        String superNavn = sc.nextLine();
        //System.out.println("");
        // boolean erMenneske = sc.nextLine(); TODO

        System.out.println("Hvilket år blev din superhelt opfundet?");
        int oprindelsesÅr = sc.nextInt();
        System.out.println("Hvor stærk er superhelten fra 1-100?");
        double strength = sc.nextDouble();
        System.out.println("Hvad er din superheltes superkraft?");
        String superKraft = sc.next(); //Udskriver kun første ord? TODO


// Vi kalder på vores funktion tilføjSuperhelt som blev lavet i Database classen.
        // Vi angiver de variabler vi vil have med i vores funktion. Disse variabler blev instaniseret længere oppe
        superheroDataBase.tilføjSuperhelt(navn, superNavn, true, oprindelsesÅr, strength, superKraft);
// Vi har tilføjet vores variabler til superheroDataBase og kombinerer det med vores array fra
// Database som hedder databaseForSuperhero. Jeg forstår ikke denne del. Spørg TODO
        for (int n = 0; n < superheroDataBase.databaseForSuperHero.length; n++) {
            System.out.println("\n-- Superheltens navn er\n--" + superheroDataBase.databaseForSuperHero[n].getsuperNavn());
            System.out.println("\n-- Superheltens menneske navn er\n--" + superheroDataBase.databaseForSuperHero[n].getNavn());
            System.out.println("\n-- Superhelten blev opfundet i år\n--" + superheroDataBase.databaseForSuperHero[n].getoprindelseÅr());
            System.out.println("\n-- Superhelten har styrke på\n--" + superheroDataBase.databaseForSuperHero[n].getStrength());
            System.out.println("\n-- Superheltens superkraft er\n--" + superheroDataBase.databaseForSuperHero[n].getSuperKraft());

        }

    }

}
