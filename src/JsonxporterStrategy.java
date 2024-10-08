import java.util.GregorianCalendar;
import java.util.List;

class JSONExporter implements Exporter {
    @Override
    public void export(List<Artikel> artikelliste) {
        System.out.println("[");
        for (int i = 0; i < artikelliste.size(); i++) {
            Artikel artikel = artikelliste.get(i);
            System.out.printf("  {\"Nummer\": \"%s\", \"Bezeichnung\": \"%s\", \"Einkaufspreis\": %.2f, \"Ablaufdatum\": \"%02d.%02d.%04d\", \"Kategorienummer\": %d}",
                    artikel.getNummer(),
                    artikel.getBezeichnung(),
                    artikel.getEinkaufspreis(),
                    artikel.getAblaufdatum().get(GregorianCalendar.DAY_OF_MONTH),
                    artikel.getAblaufdatum().get(GregorianCalendar.MONTH) + 1,
                    artikel.getAblaufdatum().get(GregorianCalendar.YEAR),
                    artikel.getKategorienummer());
            if (i < artikelliste.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }
}