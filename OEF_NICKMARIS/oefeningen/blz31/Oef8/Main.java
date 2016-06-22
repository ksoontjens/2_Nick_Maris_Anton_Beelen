public class Main
{
	public static void main(String[] args) 
	{
		Werknemer nick = new Werknemer("nick", "maris", 1, 2000);
		Werknemer erik = new Werknemer("erik", "wijnen", 2, 50);
		Werknemer jorgos = new Werknemer("jorgos", "gilis", 3, 2000000);
		Werknemer tom = new Werknemer("tom", "niemand", 4, 9000000);

		PartTimeWerknemer paul = new PartTimeWerknemer("paul", "verhoeven", 5, 1, 15);
		PartTimeWerknemer joske = new PartTimeWerknemer("Joske", "Vermeulen", 6, 20, 18);

		StudentWerknemer jef = new StudentWerknemer("Jef", "baris", 7, 15, 40);


		nick.salarisVerhogen(10);
		erik.salarisVerhogen(10);

		System.out.println(nick.voornaam + ": " + nick.getSalaris());
		System.out.println(erik.voornaam + ": " + erik.getSalaris());
		System.out.println(jorgos.voornaam + ": " + jorgos.getSalaris());
		System.out.println(tom.voornaam + ": " + tom.getSalaris());

		paul.salarisVerhogen(10);

		System.out.println(paul.voornaam + ": " + paul.getWeekloon());
		System.out.println(joske.voornaam + ": " + joske.getWeekloon());

		System.out.println(erik.voornaam + "'s RSZ percentage: " + erik.getRSZ());
		erik.setRSZ(25);
		System.out.println(erik.voornaam + "'s RSZ percentage: " + erik.getRSZ());

		System.out.println(joske.voornaam + "'s RSZ percentage: " + joske.getRSZ());
		joske.setRSZ(10);
		System.out.println(joske.voornaam + "'s RSZ percentage: " + joske.getRSZ());

		
		System.out.println(jef.voornaam + "'s RSZ percentage: " + jef.getRSZ());


	}
}