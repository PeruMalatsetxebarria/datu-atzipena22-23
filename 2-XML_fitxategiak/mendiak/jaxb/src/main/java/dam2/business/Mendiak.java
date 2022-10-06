package dam2.business;

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

}
