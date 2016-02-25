package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.test.utils.TypesUtils;
import org.junit.Assert;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PogoValidationSteps
{

    public boolean theObjectShouldNotBeNull( Object pojo )
    {
        return pojo == null;
    }

    public boolean thePojoShouldContainSomeData( Object pojo )
    {
        return pojo.getClass().getDeclaredFields()[0] != null;
    }

    public void thePojoShouldBeNull( Object pojo )
    {
        Assert.assertNull( "The pojo should be null", pojo );
    }

    public void theInnerPojoInstanceShouldNotBeNull( Object pojo )
    {
        Assert.assertNotNull( "The inner pojo instance variable should not be null", pojo );
    }

    public void theIntFieldShouldNotBeZero( int intField )
    {
        Assert.assertFalse( "The integer field should not be zero", intField == 0 );
    }

    public void theChildPojoShouldNotBeNull( Object child )
    {
        Assert.assertNotNull( "The child pojo should not be null", child );
    }

    public void eachListElementShouldNotBeNull( List<?> list )
    {
        for ( Object aList : list )
        {
            Assert.assertNotNull( aList );
        }
    }

    public void eachMapElementShouldNotBeNull( Map<?, ?> map )
    {
        for ( Object mapValue : map.values() )
        {
            Assert.assertNotNull( "The pojo's map element cannot be null!",
                                  mapValue );
        }
    }

    public void theCalendarFieldShouldNotBeNull( Calendar dateCreated )
    {
        Assert.assertNotNull( "The calendar object should not be null", dateCreated );
    }

    public void theDateObjectShouldNotBeNull( Date time )
    {
        Assert.assertNotNull( "The Date object should not be null", time );
    }

    public void theLongArrayShouldNotBeNullOrEmpty( long[] array )
    {
        Assert.assertNotNull( "The given long[] array cannot be null", array );
        Assert.assertTrue( "The given long[] array should not be null or empty", array.length > 0 );
    }

    public void theLongValueShouldNotBeZero( long value )
    {
        Assert.assertTrue( "The long value cannot be zero", value > 0 );
    }

    public void anyFieldWithPogoExcludeAnnotationShouldBeNull( Object someObject )
    {
        Assert.assertNull( "The field should be null", someObject );
    }

    public void theIntFieldShouldBeGreaterOrEqualToZero( int intField )
    {
        Assert.assertTrue( "The integer field should be greater or equal to zero", intField >= 0 );
    }

    public void theIntFieldShouldHaveValueNotGreaterThan( int intField, int maxValue )
    {
        Assert.assertTrue( "The int field should have a value <= " + maxValue, intField <= maxValue );
    }

    public void theIntFieldShouldHaveValueBetween( int minValue, int maxValue, int intField )
    {
        Assert.assertTrue( "The integer field value " + intField +
                           " should be between " + minValue + " and " + maxValue,
                           intField >= minValue && intField <= maxValue );
    }

    public void theIntegerObjectFieldShouldNotBeNull( Integer integerObjectField )
    {
        Assert.assertNotNull( "The integer object field should not be null", integerObjectField );
    }

    public void theIntFieldShouldHaveThePreciseValueOf( int intFieldWithPreciseValue, int preciseValue )
    {
        Assert.assertTrue( "The int field hasn't got a precise value", intFieldWithPreciseValue == preciseValue );
    }

    public void theLongFieldShouldBeGreaterOrEqualToZero( long longFieldValue )
    {
        Assert.assertTrue( "The long field should be >= 0", longFieldValue >= 0 );
    }

    public void theLongFieldShouldHaveValueNotGreaterThan( long longValue, int maxValue )
    {
        Assert.assertTrue( "The long value " + longValue + " should be <= " + maxValue, longValue <= maxValue );
    }

    public void theLongFieldShouldHaveValueBetween( int minValue, int maxValue, long longValue )
    {
        Assert.assertTrue( "The long value should have a value between " +
                           minValue + " and " + maxValue,
                           longValue >= minValue && longValue <= maxValue );
    }

    public void theLongObjectFieldShouldNotBeNull( Long longObjectValue )
    {
        Assert.assertNotNull( "The long object value should not be null", longObjectValue );
    }

    public void theLongFieldShouldHaveThePreciseValueOf( long longValueWithPreciseValue, long preciseValue )
    {
        Assert.assertTrue( "The value " + longValueWithPreciseValue + " should be exactly " + preciseValue,
                           longValueWithPreciseValue == preciseValue );
    }

    public void theIntFieldShouldHaveValueLessThen( int intField, int maxValue )
    {
        Assert.assertTrue( "The int value " + intField + " should be <= " + maxValue, intField <= maxValue );
    }

    public void theCalendarFieldShouldBeValid( Calendar calendarField )
    {
        TypesUtils.checkCalendarIsValid( calendarField );
    }

    public void theStringFieldCannotBeNullOrEmpty( String strField )
    {
        Assert.assertTrue( strField != null && strField.trim().length() > 0 );
    }

    public void theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( List<?> list )
    {
        Assert.assertNotNull( "The List<String> should not be null!", list );
        Assert.assertFalse( "The List<String> cannot be empty!", list.isEmpty() );
        Object element = list.get( 0 );
        Assert.assertNotNull(
            "The List<String> must have a non-null String element", element );
    }

    public void theSetShouldContainAtleastOneNonEmptyElement( Set<?> set )
    {
        Assert.assertNotNull( "The Set<?> should not be null!", set );
        Assert.assertFalse( "The Set<?> cannot be empty!", set.isEmpty() );
        Object element = set.iterator().next();
        Assert.assertNotNull(
            "The Set<?> must have a non-null String element", element );
    }

    public void theMapShouldContainAtLeastOneNonEmptyElement( Map<?, ?> map )
    {
        Assert.assertTrue( "The map attribute must be of type HashMap",
                           map instanceof HashMap );
        Assert.assertNotNull( "The map object in the POJO cannot be null", map );
        Set<?> keySet = map.keySet();
        Assert.assertNotNull( "The Map must have at least one element", keySet );
        Object o = map.get( keySet
                            .iterator().next() );
        Assert.assertNotNull( "The map element must not be null!",
                              o );
    }

    public void theQueueCannotBeNull( Queue<?> queue )
    {
        Assert.assertNotNull( "The Queue cannot be null", queue );
    }

    public void theQueueMustBeAnInstanceOf( Queue<?> queue, Class<LinkedList> linkedListClass )
    {
        Assert.assertTrue( queue.getClass().isAssignableFrom( linkedListClass ) );
    }

    public void theConcurrentHashMapOfStringsObjectsShouldContainAtLeastOneNonEmptyElement( ConcurrentMap<String, ?> map )
    {
        Assert.assertTrue( "The map attribute must be of type HashMap",
                           map instanceof ConcurrentHashMap );
        Assert.assertNotNull( "The map object in the POJO cannot be null", map );
        Set<String> keySet = map.keySet();
        Assert.assertNotNull( "The Map must have at least one element", keySet );
        Object o = map.get( keySet
                            .iterator().next() );
        Assert.assertNotNull( "The map element must not be null!",
                              o );
    }

    public void theNonGenerifiedListShouldNotBeNullOrEmpty( List nonGenerifiedList )
    {
        Assert.assertNotNull( nonGenerifiedList );
        Assert.assertTrue( "The non generified list should at least have one element", nonGenerifiedList.size() > 0 );
    }

    public void theNonGenerifiedMapShouldNotBeNullOrEmpty( Map<?, ?> nonGenerifiedMap )
    {
        Assert.assertNotNull( nonGenerifiedMap );
        Assert.assertTrue( "The non generified Map should at least have one element", nonGenerifiedMap.size() > 0 );
    }

    public void theByteValueShouldBeGreaterOrEqualThan( byte byteValue, int minValue )
    {
        Assert.assertTrue( "The byte value should be >= " + minValue, byteValue >= minValue );
    }

    public void theByteValueShouldBeLowerOrEqualThan( byte byteValue, int maxValue )
    {
        Assert.assertTrue( "The byte value " + byteValue + " should be <= " + maxValue, byteValue <= maxValue );
    }

    public void theByteValueShouldBeBetween( byte byteValue, int minValue, int maxValue )
    {
        Assert.assertTrue( "The byte value should be between " + minValue + " and " + maxValue,
                           byteValue >= minValue && byteValue <= maxValue );
    }

    public void theByteValueShouldHavePreciselyValueOf( byte byteValue, byte preciseValue )
    {
        Assert.assertTrue( "The byte value " + byteValue + " should have a precise value of " + preciseValue,
                           byteValue == preciseValue );
    }

    public void theShortValueShouldBeGreaterOrEqualThan( short shortValue, int minValue )
    {
        Assert.assertTrue( "The value " + shortValue + " should be >= " + minValue, shortValue >= minValue );
    }

    public void theShortValueShouldBeLowerOrEqualThan( short shortValue, int maxValue )
    {
        Assert.assertTrue( "The short value " + shortValue + "should be <= " + maxValue,
                           shortValue <= maxValue );
    }

    public void theShortValueShouldBeBetween( short shortValue, int minValue, int maxValue )
    {
        Assert.assertTrue( "The short value " + shortValue + " should be between " + minValue + " and " + maxValue,
                           shortValue >= minValue && shortValue <= maxValue );
    }

    public void theShortPreciseValueShouldBe( short shortFieldWithPreciseValue, short preciseValue )
    {
        Assert.assertTrue( "The short value " + shortFieldWithPreciseValue + " should be precisely " + preciseValue,
                           shortFieldWithPreciseValue == preciseValue );
    }

    public void theCharValueShouldBeGreaterOrEqualThan( char charValue, char minValue )
    {
        Assert.assertTrue( "The char value " + charValue + " should be >= " + minValue,
                           charValue >= minValue );
    }

    public void theCharValueShouldBeLowerOrEqualThan( char charValue, int maxValue )
    {
        Assert.assertTrue( "The char value " + charValue + " should be <= " + maxValue,
                           charValue <= maxValue );
    }

    public void theCharValueShouldBeBetween( char charValue, int minValue, int maxValue )
    {
        Assert.assertTrue( "The char value should be between " + minValue + " and " + maxValue,
                           charValue >= minValue && charValue <= maxValue );
    }

    public void theCharValueShouldBeExactly( char charValue, char preciseValue )
    {
        Assert.assertTrue( "The char value should be exactly " + preciseValue,
                           charValue == preciseValue );
    }

    public void theBooleanValueIsTrue( boolean boolValue )
    {
        Assert.assertTrue( "The boolean value should be true", boolValue );
    }

    public void theBooleanValueShouldBeFalse( boolean boolValue )
    {
        Assert.assertFalse( "The boolean value should be false", boolValue );
    }

    public void theFloatValueShouldBeGreaterOrEqualThan( float floatValue, float minValue )
    {
        Assert.assertTrue( "The Float value should be <= " + minValue,
                           floatValue <= minValue );
    }

    public void theFloatValueShouldBeLowerOrEqualThan( float floatValue, float maxValue )
    {
        Assert.assertTrue( "The float value should be >= " + maxValue,
                           floatValue <= maxValue );
    }

    public void theFloatValueShouldBeBetween( float floatValue, float minValue, float maxValue )
    {
        Assert.assertTrue( "The float value should be between " + minValue + " and " + maxValue,
                           floatValue >= minValue && floatValue <= maxValue );
    }

    public void theFloatValueShouldBePrecisely( float floatValue, float preciseValue )
    {
        Assert.assertTrue( "The float value should be precisely " + preciseValue,
                           floatValue == preciseValue );
    }

    public void theDoubleValueShouldBeGreaterOrEqualThan( double doubleValue, double minValue )
    {
        Assert.assertTrue( "The double value should be >= " + minValue,
                           doubleValue >= minValue );
    }

    public void theDoubleValueShouldBeLowerOrEqualThan( double doubleValue, double maxValue )
    {
        Assert.assertTrue( "The double value should be <= " + maxValue,
                           doubleValue <= maxValue );
    }

    public void theDoubleValueShouldBeBetween( double doubleValue, double minValue, double maxValue )
    {
        Assert.assertTrue( "The double value should be between " + minValue + " and " + maxValue,
                           doubleValue >= minValue && doubleValue <= maxValue );
    }

    public void theDoubleValueShouldBeExactly( double doubleValue, double preciseValue )
    {
        Assert.assertTrue( "The double value should be exactly " + doubleValue,
                           doubleValue == preciseValue );
    }

    public void theStringValueShouldHaveTheExactLengthOf( String stringValue, int stringLength )
    {
        Assert.assertTrue( "The length of the string should be " + stringLength,
                           stringValue.length() == stringLength );
    }

    public void theStringValueShouldBeExactly( String stringValue, String annotationPreciseValue )
    {
        Assert.assertEquals( stringValue, annotationPreciseValue );
    }

    public void theListShouldHaveExactlyTheExpectedNumberOfElements( List<?> strList, int nbrElements )
    {
        Assert.assertTrue( "The List doesn't have the correct number of elements",
                           strList.size() == nbrElements );
    }

    public void theArrayOfStringsShouldNotBeNullOrEmpty( String[] strArray )
    {
        Assert.assertNotNull( strArray );
        Assert.assertNotNull( strArray[0] );
    }

    public void theMapShouldHaveExactlyTheExpectedNumberOfElements( Map<?, ?> map, int nbrElements )
    {
        Assert.assertTrue( "The map should have exactly " + nbrElements + " elements",
                           map.size() == nbrElements );
    }

    public void theCollectionShouldNotBeNullOrEmpty( Collection<?> collection )
    {
        Assert.assertNotNull( "The collection should not be null", collection );
        Assert.assertFalse( "The collection should not be empty", collection.isEmpty() );
    }

    public void theCollectionShouldHaveExactlyTheExpectedNumberOfElements( Collection<?> collection, int nbrElements )
    {
        Assert.assertTrue( "The collection should have exactly " + nbrElements + " elements",
                           collection.size() == nbrElements );
    }

    public void theArrayOfBytesShouldNotBeNullOrEmpty( byte[] byteData )
    {
        Assert.assertNotNull( "The array of bytes should not be null", byteData );
        Assert.assertTrue( "The array of bytes should contain at least one element", byteData.length > 0 );
    }

    public void theArrayOfBytesShouldBeExactlyOfLength( byte[] byteData, int length )
    {
        Assert.assertTrue( "The array should have length " + length, byteData.length == length );
    }

    public void theTwoCalendarObjectsShouldHaveTheSameTime( Calendar expectedValue, Calendar actualValue )
    {
        Assert.assertTrue( expectedValue.getTime().getTime() == actualValue.getTime().getTime() );
    }

    public void theArrayOfCalendarsShouldNotBeNullOrEmpty( Calendar[] calendarArray )
    {
        Assert.assertNotNull( "The calendar array should not be null", calendarArray );
        Assert.assertTrue( "The calendar array should have at least one element",
                           calendarArray.length > 0 );
    }

    public void theArrayOfObjectsShouldNotBeNullOrEmpty( Object[] objectArray )
    {
        Assert.assertNotNull( "The array of objects should not be null", objectArray );
        Assert.assertTrue( "The array of objects should contain at least one element",
                           objectArray.length > 0 );
    }

    public void theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType( Object[] array,
            Class<?> elementType )
    {
        Assert.assertNotNull( "Array should not be null", array );
        Assert.assertTrue( "Array should not be empty", array.length > 0 );

        for ( Object element : array )
        {
            Assert.assertEquals( "Wrong element type", elementType, element.getClass() );
        }
    }

    public void theValueShouldBeNull( Object value )
    {
        Assert.assertNull( "The value is not null", value );
    }

    public void theTwoObjectsShouldBeEqual( Object expectedObject, Object actualObject )
    {
        Assert.assertEquals( "The two objects are not equal", expectedObject, actualObject );
    }

    public void theObjectShouldBeNull( Object pojo )
    {
        Assert.assertNull( "The object should be null", pojo );
    }

    public void theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( Collection<?> collection, Class<?> clazz )
    {
        Assert.assertNotNull( "The collection should not be null", collection );
        Assert.assertFalse( "The collection should not be empty", collection.isEmpty() );

        for ( Object e : collection )
        {
            Assert.assertTrue( "The element is not of type " + clazz, e.getClass().isAssignableFrom( clazz ) );
        }
    }

    public void theMapShouldNotBeNullOrEmptyAndContainElementsOfType( Map<?, ?> map, Class<?> keyType, Class<?> valueType )
    {
        Assert.assertNotNull( "Map should not be null", map );
        Assert.assertFalse( "Map should not be empty", map.isEmpty() );

        for ( Map.Entry<?, ?> element : map.entrySet() )
        {
            Assert.assertEquals( "Wrong key type", keyType, element.getKey().getClass() );
            Assert.assertEquals( "Wrong value type", valueType, element.getValue().getClass() );
        }
    }

    public void theMapShouldBeEmtpy( Map<?, ?> map )
    {
        Assert.assertTrue( "The Map should be empty", map.isEmpty() );
    }

    public void theCollectionShouldBeEmpty( Collection<?> collection )
    {
        Assert.assertTrue( "The Map should be empty", collection.isEmpty() );
    }

    public void theTwoObjectsShouldBeStrictlyEqual( Object pojo1, Object pojo2 )
    {
        Assert.assertTrue( "The two objects are not strictly equal", pojo1 == pojo2 );
    }

    public void theTwoObjectsShouldBeDifferent( Object pojo1, Object pojo2 )
    {
        Assert.assertTrue( "The two objects should be different", pojo1 != pojo2 );
    }

    public void theCollectionShouldContainAtLeastOneElementOfType( Collection<?> accessed, Class<?> type )
    {
        Assert.assertTrue( "The collection doesn't contain an element of type " + type, accessed.contains( type ) );
    }

    public void theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
        Object[] array, int size )
    {
        Assert.assertNotNull( "The array should not be null", array );
        Assert.assertTrue( "The array should have exactly " + size + " elements.", array.length == size );
    }

    public void theMapShouldNotBeNullOrEmpty( Map<?, ?> map )
    {
        Assert.assertNotNull( "The map should not be null", map );
        Assert.assertFalse( "The map should not be empty", map.isEmpty() );
    }
}
