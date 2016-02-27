package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory.TestExternalFactory;
import com.codebreeze.testing.tools.pogo.test.unit.features.inheritance.TrackingExternalFactory;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import com.codebreeze.testing.tools.pogo.test.unit.features.extensions.NonEJBClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.inheritance.CustomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes.XmlTypesExternalFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PogoFactorySteps
{

    public PogoFactory givenAStandardPogoFactory()
    {
        return new PogoFactoryImpl();
    }

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

    @SafeVarargs
    public final Set<Class<? extends Annotation>> givenASetOfExcludedAnnotationsToBeExcluded(
        Class<? extends Annotation>... excludedAnnotations )
    {
        Set<Class<? extends Annotation>> retValue = new HashSet<>();
        Collections.addAll( retValue, excludedAnnotations );
        return retValue;
    }

    public ClassInfo givenAClassInfoForPojoWithWithExcludedAnnotationsAndFields(
        Class<?> pojoClass, Set<Class<? extends Annotation>> excludeAnnotations, Set<String> excludeFields )
    {
        ClassAttributeApprover nullApprover = null;
        return PogoUtils.getClassInfo( pojoClass, excludeAnnotations, excludeFields, nullApprover );
    }

    public Set<String> givenASetOfExcludedFields( String...excludedFields )
    {
        Set<String> retValue = new HashSet<>();
        Collections.addAll( retValue, excludedFields );
        return retValue;
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

    public DataProviderStrategy givenARandomDataProviderStrategy()
    {
        return new RandomDataProviderStrategyImpl();
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
//        List<Annotation> annotations = Collections.emptyList();
        return new AttributeMetadata(
                   attributeName, realAttributeType, genericTypeArgs,
//                annotations,
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
//        List<Annotation> annotations = Collections.emptyList();
        return new AttributeMetadata(
                   attributeName, pojoClass, genericTypeArgs,
//                annotations,
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
        List<Annotation> annotations = Collections.emptyList();
        return new AttributeMetadata(
                   attributeName, pojoClass, typeParams,
//                annotations,
                   pojoClass );
    }

    public DataProviderStrategy givenADataProviderStrategyWithMemoizationSetToTrue()
    {
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl();
        strategy.setMemoization( true );
        return strategy;
    }
}
