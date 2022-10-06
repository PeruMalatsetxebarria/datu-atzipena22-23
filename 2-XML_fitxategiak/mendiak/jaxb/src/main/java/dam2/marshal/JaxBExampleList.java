package dam2.marshal;

import java.io.File;
import java.time.LocalDate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import dam2.business.Mendiak;
import dam2.business.Mendia;



/**
 * Simple example of usage of jaxb marshaling functionalities showing how to manage lists
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleList
{

    public static void main( String[] args )
    {
        try
        {

            /* init a list with a couple of mendiak to marshal */
            Mendia spain = new Mendia();
            spain.setIzena( "Spain" );
            spain.setAltuera( "Madrid" );
            spain.setContinent( "Europe" );

            spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );

            Mendia usa = new Mendia();
            usa.setIzena( "USA" );
            usa.setAltuera( "Washington" );
            usa.setContinent( "America" );


            usa.setFoundation( LocalDate.of( 1776, 7, 4 ) );

            Mendiak mendiak = new Mendiak();
            mendiak.add( spain );
            mendiak.add( usa );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( mendiak, new File( "list_mendiak.xml" ) );
            jaxbMarshaller.marshal( mendiak, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
