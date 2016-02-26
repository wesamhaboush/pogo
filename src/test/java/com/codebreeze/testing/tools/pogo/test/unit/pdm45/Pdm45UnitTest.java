package com.codebreeze.testing.tools.pogo.test.unit.pdm45;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.api.RandomDataProviderStrategyImpl;
import com.codebreeze.testing.tools.pogo.test.dto.PogoParameterizedType;
import com.codebreeze.testing.tools.pogo.test.dto.pdm45.GenericPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm45.MultiDimensionalConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm45.MultiDimensionalTestPojo;
import org.junit.Before;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.pdm45.GenericAttributePojo;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Pdm45UnitTest
{

    private PogoFactory factory;

    @Before
    public void init()
    {
        factory = new PogoFactoryImpl( new RandomDataProviderStrategyImpl() );
    }

    @Test
    public void testPojoWithGenericFields()
    {
        final GenericAttributePojo pojo = factory.manufacturePojo( GenericAttributePojo.class );
        final GenericPojo<String, Long> genericPojo = pojo.getGenericPojo();
        assertNotNull( "The GenericPojo object cannot be null!", genericPojo );
        assertNotNull( "The generated object cannot be null!", genericPojo.getFirstValue() );
        assertEquals( "The generated object must be a String!", String.class, genericPojo.getFirstValue().getClass() );
        assertNotNull( "The generated object cannot be null!", genericPojo.getSecondValue() );
        assertEquals( "The generated object must be a Long!", Long.class, genericPojo.getSecondValue().getClass() );
        assertNotNull( "The generated list cannot be null!", genericPojo.getFirstList() );
        assertEquals( "The generated list type must be of String!", String.class,
                      genericPojo.getFirstList().get( 0 ).getClass() );
        assertNotNull( "The generated array cannot be null!", genericPojo.getSecondArray() );
        assertEquals( "The generated array type must be of Long!", Long.class, genericPojo.getSecondArray()[0].getClass() );
        assertNotNull( "The generated map cannot be null!", genericPojo.getFirstSecondMap() );
        assertEquals( "The generated map key type must be of String!", String.class,
                      genericPojo.getFirstSecondMap().entrySet().iterator().next().getKey().getClass() );
        assertEquals( "The generated map value type must be of Long!", Long.class,
                      genericPojo.getFirstSecondMap().entrySet().iterator().next().getValue().getClass() );
    }

    @Test
    public void testGenericPojoManufacture()
    {
        @SuppressWarnings( "unchecked" )
        final GenericPojo<Double, Boolean> pojo = factory.manufacturePojo( GenericPojo.class, Double.class, Boolean.class );
        assertNotNull( "The GenericPojo object cannot be null!", pojo );
        assertNotNull( "The generated object cannot be null!", pojo.getFirstValue() );
        assertEquals( "The generated object must be a Double!", Double.class, pojo.getFirstValue().getClass() );
        assertNotNull( "The generated object cannot be null!", pojo.getSecondValue() );
        assertEquals( "The generated object must be a Boolean!", Boolean.class, pojo.getSecondValue().getClass() );
        assertNotNull( "The generated list cannot be null!", pojo.getFirstList() );
        assertEquals( "The generated list type must be of Double!", Double.class, pojo.getFirstList().get( 0 ).getClass() );
        assertNotNull( "The generated array cannot be null!", pojo.getSecondArray() );
        assertEquals( "The generated array type must be of Boolean!", Boolean.class, pojo.getSecondArray()[0].getClass() );
        assertNotNull( "The generated map cannot be null!", pojo.getFirstSecondMap() );
        assertEquals( "The generated map key type must be of Double!", Double.class,
                      pojo.getFirstSecondMap().entrySet().iterator().next().getKey().getClass() );
        assertEquals( "The generated map value type must be of Boolean!", Boolean.class,
                      pojo.getFirstSecondMap().entrySet().iterator().next().getValue().getClass() );
    }

    @Test
    public void testMultiDimensionalTestPojo()
    {
        final MultiDimensionalTestPojo pojo = factory.manufacturePojo( MultiDimensionalTestPojo.class );
        checkMultiDimensionalPojo( pojo );
    }

    @Test
    public void testConstructorMultiDimensionalPojo()
    {
        final MultiDimensionalConstructorPojo pojo = factory.manufacturePojo( MultiDimensionalConstructorPojo.class );
        checkMultiDimensionalPojo( pojo );
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void testMultiDimensionalPojoManufacture()
    {
        ParameterizedType twoDimensionalStringListType =
            new PogoParameterizedType( List.class,
                                       new PogoParameterizedType( List.class,
                                               String.class ) );
        ParameterizedType longDoubleMapType =
            new PogoParameterizedType( Map.class, Long.class, Double.class );
        final GenericPojo<List<List<String>>, Map<Long, Double>> pojo =
            factory.manufacturePojo( GenericPojo.class, twoDimensionalStringListType, longDoubleMapType );
        assertNotNull( "The GenericPojo object cannot be null!", pojo );
        assertNotNull( "The generated object cannot be null!", pojo.getFirstValue() );
        assertEquals( "The generated object must be a String!", String.class,
                      pojo.getFirstValue().get( 0 ).get( 0 ).getClass() );
        assertNotNull( "The generated object cannot be null!", pojo.getSecondValue() );
        assertEquals( "The generated object must be a Long!", Long.class,
                      pojo.getSecondValue().keySet().iterator().next().getClass() );
        assertEquals( "The generated object must be a Double!", Double.class,
                      pojo.getSecondValue().values().iterator().next().getClass() );
        assertNotNull( "The generated list cannot be null!", pojo.getFirstList() );
        assertEquals( "The generated list type must be of String!", String.class,
                      pojo.getFirstList().get( 0 ).get( 0 ).get( 0 ).getClass() );
        assertNotNull( "The generated array cannot be null!", pojo.getSecondArray() );
        assertEquals( "The generated array type must be of Long!", Long.class,
                      pojo.getSecondArray()[0].keySet().iterator().next().getClass() );
        assertEquals( "The generated array type must be of Double!", Double.class,
                      pojo.getSecondArray()[0].values().iterator().next().getClass() );
        assertNotNull( "The generated map cannot be null!", pojo.getFirstSecondMap() );
        assertEquals( "The generated map key type must be of String!", String.class,
                      pojo.getFirstSecondMap().entrySet().iterator().next().getKey().get( 0 ).get( 0 ).getClass() );
        assertEquals( "The generated map value type must be of Long!", Long.class,
                      pojo.getFirstSecondMap().entrySet().iterator().next().getValue().keySet().iterator().next().getClass() );
        assertEquals( "The generated map value type must be of Double!", Double.class,
                      pojo.getFirstSecondMap().entrySet().iterator().next().getValue().values().iterator().next().getClass() );
    }

    private void checkMultiDimensionalPojo( final MultiDimensionalTestPojo pojo )
    {
        assertNotNull( "The GenericPojo object cannot be null!", pojo );
        checkMultiDimensionalCollection( pojo.getThreeDimensionalList(), String.class );
        checkMultiDimensionalCollection( pojo.getThreeDimensionalQueue(), Date.class );
        checkMultiDimensionalCollection( pojo.getThreeDimensionalSet(), Double.class );
        checkMultiDimensionalCollection( pojo.getThreeDimensionalCollection(), Long.class );
        assertEquals( "The generated Array must have size=2!", 5, pojo.getThreeDimensionalArray().length );
        assertEquals( "The generated Array must have size=2!", 5, pojo.getThreeDimensionalArray()[0].length );
        assertEquals( "The generated Array must have size=2!", 5, pojo.getThreeDimensionalArray()[0][0].length );
        assertEquals( "The generated Array must be of String!", String.class,
                      pojo.getThreeDimensionalArray()[0][0][0].getClass() );
        // Boolean key is always true, so just have one element
        assertEquals( "The generated Map must have size=1!", 1, pojo.getThreeDimensionalMap().size() );
        Entry<Boolean, Map<Float, Map<Integer, Calendar>>> entry =
            pojo.getThreeDimensionalMap().entrySet().iterator().next();
        assertEquals( "The generated Map entry key must be of Boolean!", Boolean.class, entry.getKey().getClass() );
        assertEquals( "The generated Map must have size=2!", 5, entry.getValue().size() );
        Entry<Float, Map<Integer, Calendar>> entry2 = entry.getValue().entrySet().iterator().next();
        assertEquals( "The generated Map entry key must be of Float!", Float.class, entry2.getKey().getClass() );
        assertEquals( "The generated Map must have size=2!", 5, entry2.getValue().size() );
        Entry<Integer, Calendar> entry3 = entry2.getValue().entrySet().iterator().next();
        assertEquals( "The generated Map entry key must be of Integer!", Integer.class, entry3.getKey().getClass() );
        assertEquals( "The generated Map entry key must be of Calendar!", GregorianCalendar.class,
                      entry3.getValue().getClass() );
    }

    @SuppressWarnings( "unchecked" )
    private <T> void checkMultiDimensionalCollection( final Collection<?> collection, Class<T> type )
    {
        assertEquals( "The generated List must have size=2!", 5, collection.size() );
        Collection<?> subcollection = ( Collection<?> )collection.iterator().next();
        assertEquals( "The generated List must have size=2!", 5, subcollection.size() );
        subcollection = ( Collection<?> )subcollection.iterator().next();
        assertEquals( "The generated List must have size=2!", 5, subcollection.size() );
        T element = ( T ) subcollection.iterator().next();
        assertEquals( "The generated List must be of " + type + "!", type, element.getClass() );
    }

}
