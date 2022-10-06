package dam2.xsd;

import java.io.File;
import java.time.LocalDate;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import dam2.business.Mendia;

/**
 * Example of XSD usage for validation using an error handler, no marshalling involved here
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleXSDErrorHandler
{

    public static void main( String[] args ) throws Exception
    {
        /**
         * error will be thrown because continent is mandatory
         */
        Mendia spain = new Mendia();
        spain.setIzena( "Spain" );
        spain.setAltuera( "Madrid" );
        spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );


        /**
         * ok
         */
        Mendia australia = new Mendia();
        australia.setIzena( "Australia" );
        australia.setAltuera( "Camberra" );
        australia.setFoundation( LocalDate.of( 1788, 01, 26 ) );
        australia.setContinent( "Oceania" );


        /**
         * schema is created
         */
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "mendiak_validation.xsd" ) );

        /**
         * context is created and used to create sources for each country
         */
        JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );
        JAXBSource sourceSpain = new JAXBSource( jaxbContext, spain );
        JAXBSource sourceAustralia = new JAXBSource( jaxbContext, australia );

        /**
         * validator is initialized
         */
        Validator validator = schema.newValidator();
        validator.setErrorHandler( new MyErrorHandler() );

        //validator is used
        try
        {
            validator.validate( sourceSpain );
            System.out.println( "spain has no problems" );
        }
        catch( SAXException ex )
        {
            ex.printStackTrace();
            System.out.println( "spain has problems" );
        }
        try
        {
            validator.validate( sourceAustralia );
            System.out.println( "australia has no problems" );
        }
        catch( SAXException ex )
        {
            ex.printStackTrace();
            System.out.println( "australia has problems" );
        }
    }
}
