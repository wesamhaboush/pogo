/**
 *
 */
package com.codebreeze.testing.tools.pogo.exceptions;

public class PodamMockeryException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public PodamMockeryException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public PodamMockeryException( String message )
    {
        super( message );
    }

}
