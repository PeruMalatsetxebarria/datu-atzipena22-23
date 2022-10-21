package dambi.batazbestekoak;

import java.util.Scanner;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class IkasleBatenBatazbestekoa {
    public static void main(String[] args) {
        /*Notak notak = new Notak();
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
        }*/
        Scanner in = new Scanner(System.in);

        String izena ="";

        System.out.println("Sartu ikasle baten izena:");
        izena=in.next();



        
            Notak notak = new Notak();
            Notak Nota2 = new Notak();
            Csva csva = new Csva("data/Notak.csv");
            Jsona jsona = new Jsona("","mendienfitxategiak/data/nota2.json");
            notak = csva.irakurri();


            
            

            /*if (notak != null) {
                int [] zenbakiak = {};
                int i = 0;
                
                for (Nota m : notak.getNotak()) {
                    if (m.getIkaslea().equals(izena)) {
                        //zenbakiak[]=m.getNota();
                        System.out.println(m.getNota());
                        //Integer.parseInt(m.getNota());
                        i++;

                        //String zenbakia = Integer.parseInt(m.getId())
                        //zenbakiak[i] = (m.getId());
                        //String zenbakia = (m.getId)
                    }
                    
                }
                System.out.println();
    
            }*/

            if (notak != null) {
                int [] zenbakiak = {};
                int i = 0;
                
                for (Nota m : notak.getNotak()) {
                    if (m.getIkaslea().equals(izena)) {
                        //zenbakiak[]=m.getNota();
                        System.out.println(m.getNota());
                        //Integer.parseInt(m.getNota());
                        nota2.add(m);

                        //String zenbakia = Integer.parseInt(m.getId())
                        //zenbakiak[i] = (m.getId());
                        //String zenbakia = (m.getId)
                    }
                    
                }
                System.out.println();
    
            }
        
    }
}
