public class Main
{
	public static void main(String[] args) 
	{
                Werknemer Nick = new Werknemer("Nick", "Maris", 1, 2000);
		Werknemer erik = new Werknemer("erik", "wijnen", 2, 50);
		Werknemer jorgos = new Werknemer("jorgos", "gilis", 3, 2000000);
		Werknemer tom = new Werknemer("tom", "niemand", 4, 9000000);

		PartTimeWerknemer paul = new PartTimeWerknemer("paul", "verhoeven", 5, 1, 15);
		PartTimeWerknemer joske = new PartTimeWerknemer("Joske", "Vermeulen", 6, 10, 18);

		Nick.salarisVerhogen(10);
		erik.salarisVerhogen(10);

		System.out.println(Nick.voornaam + ": " + Nick.getSalaris());
		System.out.println(erik.voornaam + ": " + erik.getSalaris());
		System.out.println(jorgos.voornaam + ": " + jorgos.getSalaris());
		System.out.println(tom.voornaam + ": " + tom.getSalaris());




	}
}