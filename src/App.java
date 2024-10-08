import java.util.ArrayList;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args) {
		// zu verarbeitende Artikelliste kommt aus der Hilfsmethode
		ArrayList<Artikel> al = artikellisteAusDBDummy();

		// Standardformat ist CSV
		String format = "JSON";
		if (args.length > 0 && args[0] != null) {
			format = args[0].toUpperCase(); // Kommandozeilenparameter (groß schreiben)
		}

		// Exporter basierend auf dem Format wählen
		Exporter exporter;
		switch (format) {
			case "JSON":
				exporter = new JSONExporter();
				break;
			case "CSV":
			default:
				exporter = new CSVExporter();
		}

		// Daten exportieren
		exporter.export(al);
	}

	/**
	 * Diese Methode liefert eine Beispielliste mit Artikeln, wie sie von der Export-Applikation verarbeitet werden soll.
	 * Später wird diese Methode die Daten aus einer Datenbank holen.
	 * Das ist aber nicht Teil des aktuellen JAVA Export Prototypen.
	 * @return Beispielliste, mit der gearbeitet werden soll.
	 */
	public static ArrayList<Artikel> artikellisteAusDBDummy() {
		ArrayList<Artikel> liste = new ArrayList<>();
		liste.add(new Artikel("1", "Sekt", 90.23, new GregorianCalendar(2019, 3, 4), 24));
		liste.add(new Artikel("2", "Fanta", 9.90, new GregorianCalendar(2019, 11, 1), 23));
		liste.add(new Artikel("3", "Cola", 9.90, new GregorianCalendar(2019, 1, 12), 23));
		liste.add(new Artikel("4", "Beinschinken", 12.23, new GregorianCalendar(2019, 11, 12), 45));
		liste.add(new Artikel("5", "Speck", 5.23, new GregorianCalendar(2018, 2, 3), 45));
		return liste;
	}
}