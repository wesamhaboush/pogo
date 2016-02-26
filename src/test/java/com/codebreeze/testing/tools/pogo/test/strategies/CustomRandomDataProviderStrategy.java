package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.api.AbstractRandomDataProviderStrategy;

public class CustomRandomDataProviderStrategy extends AbstractRandomDataProviderStrategy
{

    @Override
    public int getNumberOfCollectionElements( Class<?> type )
    {
        int number;

        if ( String[].class.isAssignableFrom( type ) )
        {
            number = 2;
        }
        else if ( Boolean.class.isAssignableFrom( type ) )
        {
            number = 3;
        }
        else if ( Long.class.isAssignableFrom( type ) )
        {
            number = 4;
        }
        else if ( Integer.class.isAssignableFrom( type ) )
        {
            number = 5;
        }
        else
        {
            number = super.getNumberOfCollectionElements( type );
        }

        return number;
    }
}
