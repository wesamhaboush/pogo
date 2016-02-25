package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.typeManufacturers.*;

import java.util.HashMap;
import java.util.Map;

public class TypeProcessor
{
    private static final ByteTypeManufacturerImpl byteTypeManufacturerImpl = new ByteTypeManufacturerImpl();
    private static final BooleanTypeManufacturerImpl booleanTypeManufacturerImpl = new BooleanTypeManufacturerImpl();
    private static final CharTypeManufacturerImpl charTypeManufacturerImpl = new CharTypeManufacturerImpl();
    private static final ShortTypeManufacturerImpl shortTypeManufacturerImpl = new ShortTypeManufacturerImpl();
    private static final IntTypeManufacturerImpl intTypeManufacturerImpl = new IntTypeManufacturerImpl();
    private static final LongTypeManufacturerImpl longTypeManufacturerImpl = new LongTypeManufacturerImpl();
    private static final FloatTypeManufacturerImpl floatTypeManufacturerImpl = new FloatTypeManufacturerImpl();
    private static final DoubleTypeManufacturerImpl doubleTypeManufacturerImpl = new DoubleTypeManufacturerImpl();
    private static final StringTypeManufacturerImpl stringTypeManufacturerImpl = new StringTypeManufacturerImpl();
    private static final EnumTypeManufacturerImpl enumTypeManufacturerImpl = new EnumTypeManufacturerImpl();
    private static final GenericTypeManufacturerImpl genericTypeManufacturerImpl = new GenericTypeManufacturerImpl();

    private static final Map<String, TypeManufacturer> manufacturers = new HashMap<String, TypeManufacturer>()
    {
        {
            put( "byte", byteTypeManufacturerImpl );
            put( "java.lang.Byte", byteTypeManufacturerImpl );
            put( "boolean", booleanTypeManufacturerImpl );
            put( "java.lang.Boolean", booleanTypeManufacturerImpl );
            put( "char", charTypeManufacturerImpl );
            put( "java.lang.Character", charTypeManufacturerImpl );
            put( "short", shortTypeManufacturerImpl );
            put( "java.lang.Short", shortTypeManufacturerImpl );
            put( "int", intTypeManufacturerImpl );
            put( "java.lang.Integer", intTypeManufacturerImpl );
            put( "long", longTypeManufacturerImpl );
            put( "java.lang.Long", longTypeManufacturerImpl );
            put( "float", floatTypeManufacturerImpl );
            put( "java.lang.Float", floatTypeManufacturerImpl );
            put( "double", doubleTypeManufacturerImpl );
            put( "java.lang.Double", doubleTypeManufacturerImpl );
            put( "java.lang.String", stringTypeManufacturerImpl );
            put( "Enumeration", enumTypeManufacturerImpl );
            put( "GenericType", genericTypeManufacturerImpl );
        }
    };

    public Object process( TypeManufacturerParamsWrapper wrapper, String qualifier )
    {
        return manufacturers.get( qualifier ).getType( wrapper );
    }
}
