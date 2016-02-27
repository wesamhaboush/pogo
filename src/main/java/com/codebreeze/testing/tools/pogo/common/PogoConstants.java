package com.codebreeze.testing.tools.pogo.common;


import java.lang.reflect.Type;

public final class PogoConstants
{

    public static final int STR_DEFAULT_LENGTH = 10;

    public static final int DEFAULT_NBR_COLLECTION_ELEMENTS = 5;

    public static final Type[] NO_TYPES = new Type[0];

    public static final Object[] NO_ARGS = new Object[0];

    public static final String ENUMERATION_QUALIFIER = "Enumeration";

    public static final String GENERIC_TYPE_QUALIFIER = "GenericType";

    private PogoConstants()
    {
        throw new AssertionError( "Non instantiable" );
    }


}
