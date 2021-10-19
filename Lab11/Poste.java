package Lab11;

public class Poste {

	public static void main(String[] args) {
		// Create a mailbox
		MailBox boite = new MailBox(30);

		Letter lettre1 = new Letter(200, true, "5 Boulevard Descartes, 9400 Noisy Champs", "A3");
		Letter lettre2 = new Letter(800, false, "", "A4"); // invalid

		Publicity pub1 = new Publicity(1500, true, "20 Rue Bouquet, 77195 Lognes");
		Publicity pub2 = new Publicity(3000, false, ""); // invalid

		Packet colis1 = new Packet(5000, true, "3 Rue des Capucins, 7500 Paris", 30);
		Packet colis2 = new Packet(3000, true, "21 Rue Chemin des fleurs, 69123 Lyon", 70); // packet invalid !

		boite.addMail(lettre1);
		boite.addMail(lettre2);
		boite.addMail(pub1);
		boite.addMail(pub2);
		boite.addMail(colis1);
		boite.addMail(colis2);

		System.out.println("Total price is "+ boite.postage());
		boite.print();

		System.out.println("The mailbox has " + boite.invalidMail()	+ " invalid mail");
	}
}
