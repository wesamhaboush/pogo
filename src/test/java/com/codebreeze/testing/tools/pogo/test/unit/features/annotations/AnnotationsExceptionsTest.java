package com.codebreeze.testing.tools.pogo.test.unit.features.annotations;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.*;
import org.junit.Before;
import org.junit.Test;

public class AnnotationsExceptionsTest
{

    private PodamFactory podamFactory;

    @Before
    public void init()
    {
        podamFactory = new PodamFactoryImpl();
    }

    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamIntegerValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( IntegerValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamLongValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( LongValueWithErrorPojo.class );
    }


    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamByteValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( ByteValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamShortValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( ShortValueWithErrorPojo.class );
    }

    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamFloatValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( FloatValueWithErrorPojo.class );
    }



    @Test( expected = IllegalArgumentException.class )
    public void podamShouldThrowExceptionWhenPodamDoubleValueContainsInvalidCharacters() throws Exception
    {
        podamFactory.manufacturePojo( DoubleValueWithErrorPojo.class );
    }
}
