package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.extensions.NonEJBClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory.TestExternalFactory;
import com.codebreeze.testing.tools.pogo.test.unit.features.inheritance.CustomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.inheritance.TrackingExternalFactory;
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

    public PogoFactory givenAnExternalFactory()
    {
        return new TestExternalFactory();
    }

    public PogoFactory givenAdPogoFactoryWithExternalFactory( PogoFactory externalFactory )
    {
        return new PogoFactoryImpl( externalFactory );
    }

    public TrackingExternalFactory givenATrackingExternalFactory()
    {
        return new TrackingExternalFactory();
    }

    public CustomDataProviderStrategy givenACustomDataProviderStrategy()
    {
        return new CustomDataProviderStrategy();
    }

    public PogoFactory givenAPogoFactoryWithExternalFactoryAndCustomStrategy( PogoFactory externalFactory,
            DataProviderStrategy customDataProviderStrategy )
    {
        return new PogoFactoryImpl( externalFactory, customDataProviderStrategy );
    }

    public NonEJBClassInfoStrategy givenANonEJBClassInfoStrategy()
    {
        return new NonEJBClassInfoStrategy();
    }

    public PogoFactory givenAPogoFactoryWithCustomClassInfoStrategy( ClassInfoStrategy classInfoStrategy )
    {
        return new PogoFactoryImpl().setClassStrategy( classInfoStrategy );
    }

    public PogoFactory givenAPogoFactoryWithCustomDataProviderStrategy( DataProviderStrategy strategy )
    {
        return new PogoFactoryImpl( strategy );
    }

    public CustomRandomDataProviderStrategy givenACustomRandomDataProviderStrategy()
    {
        return new CustomRandomDataProviderStrategy();
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

    public DataProviderStrategy givenADataProviderStrategyWithMemoizationSetToTrue()
    {
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl();
        strategy.setMemoization( true );
        return strategy;
    }
}
