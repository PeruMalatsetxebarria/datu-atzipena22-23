package dam2.xsd;

import java.io.File;
import java.time.LocalDate;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import dam2.business.Mendia;

/**
 * Example of usage of XSDs for marshaling with validation of the objects involved
 * @author dgutierrez-diez
 *
 */
public class JaxBExampleXSDValidation
{

    public static void main( String[] args ) throws Exception
    {
        /**
         * validation will fail because continent is mandatory
         */
        Mendia spain = new Mendia();
        spain.setIzena( "Spain" );
        spain.setAltuera( "Madrid" );
        spain.setProbintzia("Gipuzkoa");

        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "mendiak_validation.xsd" ) );

        JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        marshaller.setSchema( schema );
        //the schema uses a validation handler for validate the objects
        marshaller.setEventHandler( new MyValidationEventHandler() );
        try
        {
            marshaller.marshal( spain, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

        /**
         * continent is wrong and validation will fail
         */
        Mendia australia = new Mendia();
        australia.setIzena( "Australia" );
        australia.setAltuera( "Camberra" );
        australia.setFoundation( LocalDate.of( 1788, 01, 26 ) );
        australia.setContinent( "Australia" );

        try
        {
            marshaller.marshal( australia, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

        /**
         * finally everything ok
         */
        australia = new Mendia();
        australia.setIzena( "Australia" );
        australia.setAltuera( "Camberra" );
        australia.setFoundation( LocalDate.of( 1788, 01, 26 ) );
        australia.setContinent( "Oceania" );


        try
        {
            marshaller.marshal( australia, System.out );
        }
        catch( JAXBException ex )
        {
            ex.printStackTrace();
        }

    }

}
