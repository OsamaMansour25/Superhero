public class Superhero {
    // Vi vil lave et superhelte program, vi angiver alle variabler til vores superhelt.
    private String navn;
    private String superNavn;
    private boolean erMenneske;
    private int oprindelseÅr;
    private String superKraft;
    private double strength;
// Vi laver herefter en constructor til vores superhelt. "this". angiver at variablerne nedenfor svarer til dem ovenover
public Superhero(String navn, String superNavn, boolean erMenneske, int oprindelseÅr, double strength, String superKraft) {
this.navn = navn;
this.superNavn = superNavn;
this.erMenneske = erMenneske;
this.oprindelseÅr = oprindelseÅr;
this.strength = strength;
this.superKraft = superKraft;
}
// Vi laver get metoden for at kunne benytte variablerne da de er private.
public String getNavn() {
    return navn;
}
public String getsuperNavn() {
    return superNavn;
}
public boolean erMenneske() {
    return erMenneske;
}
public int getoprindelseÅr() {
    return oprindelseÅr;
}
public double getStrength() {
    return strength;
}
public String getSuperKraft() {
    return superKraft;
}
}

