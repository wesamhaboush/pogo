package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes.XmlTypesExternalFactory;

import java.lang.reflect.Type;
import java.util.List;

public class PogoFactorySteps
{
    public PogoFactory givenAPogoExternalFactorytoTestAttributeMetadata()
    {
        return new PogoFactoryImpl( new AbstractRandomDataProviderStrategy()
        {
            @Override
            public String getStringValue( AttributeMetadata attributeMetadata )
            {
                if ( attributeMetadata.getPojoClass() == PojoSpecific.class )
                {
                    return "specific";
                }
                else
                {
                    return "classic";
                }
            }
        } );
    }

    public ClassInfo givenAClassInfoForPojoWithNoAttributes( Class<?> pojoClass, List<ClassAttribute> attributes )
    {
        return new ClassInfo( pojoClass, attributes );
    }

    public PogoFactory givenAPogoFactoryWithXmlTypesExternalFactory()
    {
        PogoFactory externalFactory = new XmlTypesExternalFactory();
        return new PogoFactoryImpl( externalFactory );
    }

    public AttributeMetadata givenAnEmptyAttributeMetadata( Class<?> pojoClass )
    {
        if ( null == pojoClass )
        {
            throw new IllegalArgumentException( "pojoClass cannot be null" );
        }

        String attributeName = null;
        Class<?> realAttributeType = null;
        Type[] genericTypeArgs = new Type[0];
        return new AttributeMetadata(
                   attributeName, realAttributeType, genericTypeArgs,
                   pojoClass );
    }

    public AttributeMetadata givenAnAttributeMetadataForEnums( Class<?> pojoClass )
    {
        if ( null == pojoClass )
        {
            throw new IllegalArgumentException( "pojoClass cannot be null" );
        }

        String attributeName = null;
        Type[] genericTypeArgs = new Type[0];
        return new AttributeMetadata(
                   attributeName, pojoClass, genericTypeArgs,
                   pojoClass );
    }

    public AttributeMetadata givenAnAttributeMetadataForGenericTypes( Class<?> pojoClass )
    {
        if ( null == pojoClass )
        {
            throw new IllegalArgumentException( "pojoClass cannot be null" );
        }

        String attributeName = null;
        Type[] typeParams = pojoClass.getTypeParameters();
        return new AttributeMetadata(
                   attributeName, pojoClass, typeParams,
                   pojoClass );
    }
}
