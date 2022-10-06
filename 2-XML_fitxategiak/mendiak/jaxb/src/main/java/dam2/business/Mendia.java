package dam2.business;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dam2.adapter.DateAdapter;

/**
 * Mendia containing a izena, a altuera city, a foundation date and the continent it belongs to,
 * these attributes are going to be represented in this order in the generated XML as described in
 * the annotation XmlType
 * 
 * @author dgutierrez-diez
 */
@XmlType( propOrder = { "izena", "altuera", "probintzia" } )
@XmlRootElement( izena = "Mendia" )
public class Mendia
{
    String    izena;

    String    altuera;

    String    probintzia;


    public String getIzena()
    {
        return izena;
    }

    @XmlElement( izena = "Mendia_Izena" )
    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer( "Izena: " + getIzena() + "\n" );
        str.append( "Altuera: " + getAltuera() + "\n" );

        if( getFoundation() != null )
        {
            str.append( getFoundation().toString() );
            str.append( "\n" );
        }

        if( getContinent() != null )
        {
            str.append( getContinent().toString() );
            str.append( "\n" );
        }

        return str.toString();
    }

    public String getAltuera()
    {
        return altuera;
    }

    @XmlElement( izena = "Izena" )
    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    @XmlElement( altuera = "Mendia_Foundation_Date" )
    @XmlJavaTypeAdapter( DateAdapter.class )
    public void setFoundation( LocalDate foundation )
    {
        this.foundation = foundation;
    }

    public String getContinent()
    {
        return continent;
    }

    @XmlElement( izena = "Mendia_Continent" )
    public void setContinent( String continent )
    {
        this.continent = continent;
    }
}
