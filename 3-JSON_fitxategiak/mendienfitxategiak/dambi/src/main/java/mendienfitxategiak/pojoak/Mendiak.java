package mendienfitxategiak.bojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * JaxB is not capable of marshal lists directly as root elements, so we need a container for the
 * list of mendiak. Getter and Setter are used by jaxb
 * 
 * @author dgutierrez-diez
 */
@XmlRootElement( izena = "Mendiak" )
public class Mendiak
{
    List<Mendia> mendiak;

    public List<Mendia> getMendiak()
    {
        return mendiak;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement( izena = "Mendia" )
    public void setMendiak( List<Mendia> mendiak )
    {
        this.mendiak = mendiak;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     * 
     * @param country
     */
    public void add( Mendia country )
    {
        if( this.mendiak == null )
        {
            this.mendiak = new ArrayList<Mendia>();
        }
        this.mendiak.add( country );

    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Mendia museum : this.mendiak )
        {
            str.append( museum.toString() );
        }
        return str.toString();
    }










    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("==============");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bisitatu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    met1();
                    break;
                case 2:
                    met2();
                    break;
                case 3:
                    met3();
                    break;
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void met1(){
    //readline erabili
    
}

public static void met2(){
    //qwerty
}

public static void met3(){
    System.out.println("Aukeratu zein probintziatako mendiak esportatu nahi dituzun: ");
    System.out.println("");
    System.out.println("1.- Arabako mendiak esportatu (Araba.csv)");
    System.out.println("2.- Bizkaiko mendiak esportatu (Bizkaia.csv)");
    System.out.println("3.- Gipuzkoako mendiak esportatu (Gipuzkoa.csv)");
    System.out.println("3.- Nafarroako mendiak esportatu (Nafarroa.csv)");
}

}
/*create arraybuilder
for (Mendia m : mendiak.getMendiak()) (hua beran modun da)
    create objectbuilder
*/