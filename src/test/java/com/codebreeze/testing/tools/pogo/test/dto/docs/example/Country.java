package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;
import com.codebreeze.testing.tools.pogo.common.PogoStringValue;

import java.io.Serializable;

public class Country implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final int countryId;

    private final String countryCode;

    private final String description;

    @PogoConstructor( comment = "Immutable-like POJOs must be annotated with @PogoConstructor" )
    public Country( int countryId,
                    @PogoStringValue( length = 2 ) String countryCode, String description )
    {
        super();
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.description = description;
    }

    public int getCountryId()
    {
        return countryId;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "Country ( " + "countryId = " + countryId +
                          TAB + "countryCode = " + countryCode +
                          TAB + "description = " + description +
                          TAB + " )";
        return retValue;
    }

}
