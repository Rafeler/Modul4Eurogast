import java.util.GregorianCalendar;
import java.util.List;

class CSVExporter implements Exporter {
    @Override
    public void export(List<Artikel> artikelliste) {
        System.out.println("Nummer;Bezeichnung;Einkaufspreis;Ablaufdatum;Kategorienummer");
        for (Artikel artikel : artikelliste) {
            System.out.printf("%s;%s;%.2f;%02d.%02d.%04d;%d%n",
                    artikel.getNummer(),
                    artikel.getBezeichnung(),
                    artikel.getEinkaufspreis(),
                    artikel.getAblaufdatum().get(GregorianCalendar.DAY_OF_MONTH),
                    artikel.getAblaufdatum().get(GregorianCalendar.MONTH) + 1,
                    artikel.getAblaufdatum().get(GregorianCalendar.YEAR),
                    artikel.getKategorienummer());
        }
    }
}