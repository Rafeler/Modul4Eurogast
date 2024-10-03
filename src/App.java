import java.util.ArrayList;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args)
	{
		//zu verarbeitende Artikelliste kommt aus untenstehender Hilfsmethode:
		ArrayList<Artikel> al = artikellisteAusDBDummy();
		
		//Je nach Kommandozeilenparameter sollen verschiedene Exporte durchgeführt werden.
		//In Eclipse können diese Paramter gesetzt werden über (noch ist keiner gesetzt):
		//über Run->Run Configurations -> Arguments -> Programm Arguments
		if(args.length>0)
		{
			String parameter = args[0];
			switch(parameter)
			{
			case "CSV":
				//CSV-Export durchführen
				break;
			case "JSON":
				//JSON-Export durchführen
				break;
			default:
				//CSV-Export durchführen
				break;
			}
		} else //kein Parameter, dann CSV-Export (Standard)
		{
			//CSV-Export
		}
	}

	/**
	 * Diese Methode liefert eine Beispielliste mit Artikeln,
	 * wie sie von der Export-Applikation verarbeitet werden soll.
	 * Später wird diese Methode die Daten aus einer Datenbank holen.
	 * Das ist aber nicht Teil des aktuellen JAVA Export Prototpyen.
	 * @return Beispielliste, mit der gearbeitet werden soll.
	 */
	public static ArrayList<Artikel> artikellisteAusDBDummy() {
		ArrayList<Artikel> liste = new ArrayList<>();
		liste.add(new Artikel("1","Sekt",90.23,new GregorianCalendar(2019,3,4),24));
		liste.add(new Artikel("2","Fanta",9.90,new GregorianCalendar(2019,11,1),23));
		liste.add(new Artikel("3","Cola",9.90,new GregorianCalendar(2019,1,12),23));
		liste.add(new Artikel("4","Beinschinken",12.23,new GregorianCalendar(2019,11,12),45));
		liste.add(new Artikel("5","Speck",5.23,new GregorianCalendar(2018,2,3),45));
		return liste;
	}
}
