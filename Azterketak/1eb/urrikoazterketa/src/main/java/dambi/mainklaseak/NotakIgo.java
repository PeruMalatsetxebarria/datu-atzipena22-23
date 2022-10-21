package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class NotakIgo {
    public static void main(String[] args) {
        Notak notak = new Notak();
        Notak notahobetuak = new Notak();
        Csva csva = new Csva("data/Notak.csv");
        Xmla xmla = new Xmla("", "data/NotaHobetuak.xml");
        notak = csva.irakurri();


        if (notak != null) {
            for (Nota m : notak.getNotak()) {
                if (m.getNota()<=9) {
                    m.setNota(m.getNota()+1);
                    notahobetuak.add(m);
                } else {
                    m.setNota(m.getNota());
                    notahobetuak.add(m);
                }
                
            }

            System.out.println(xmla.idatzi(notahobetuak) + " mendi idatzi dira xml fitxategian.");
        }
    }
}
