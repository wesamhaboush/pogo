/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.api.PogoUtils;
import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

public class EmailStrategy implements AttributeStrategy<String>
{
    public String getValue()
    {
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < 2; i++ )
        {
            for ( int j = 0; j < 2; j++ )
            {
                for ( int k = 0; k < 5; k++ )
                {
                    sb.append( PogoUtils.getNiceCharacter() );
                }

                if ( j == 0 )
                {
                    sb.append( "." );
                }
            }

            if ( i == 0 )
            {
                sb.append( "@" );
            }
        }

        return sb.toString();
    }
}
