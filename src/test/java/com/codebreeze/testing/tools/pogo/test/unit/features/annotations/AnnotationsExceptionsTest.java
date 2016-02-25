package com.codebreeze.testing.tools.pogo.test.unit.features.annotations;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.*;
import org.junit.Before;
import org.junit.Test;

public class AnnotationsExceptionsTest
{

    private PogoFactory PogoFactory;

    @Before
    public void init()
    {
        PogoFactory = new PogoFactoryImpl();
    }

    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoIntegerValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( IntegerValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoLongValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( LongValueWithErrorPojo.class );
    }


    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoByteValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( ByteValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoShortValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( ShortValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoFloatValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( FloatValueWithErrorPojo.class );
    }



    @Test( expected = IllegalArgumentException.class )
    public void PogoShouldThrowExceptionWhenPogoDoubleValueContainsInvalidCharacters() throws Exception
    {
        PogoFactory.manufacturePojo( DoubleValueWithErrorPojo.class );
    }
}
