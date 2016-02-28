package com.codebreeze.testing.tools.pogo.test.unit.features.collections;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest extends AbstractPogoSteps
{

    private Condition<Map<?, ?>> atLeastOneNonEmptyElement = new Condition<Map<?, ?>>()
    {
        @Override
        public boolean matches( Map<?, ?> map )
        {
            return map.entrySet().stream().anyMatch( e -> e.getKey() != null && e.getValue() != null );
        }
    };
    private Condition<List> empty = new Condition<List>()
    {
        @Override
        public boolean matches( List list )
        {
            return list.size() <= 0;
        }
    };

    private Condition<Map> emptyMap = new Condition<Map>()
    {
        @Override
        public boolean matches( Map map )
        {
            return map.size() <= 0;
        }
    };
    private Condition<Map> nullElements = new Condition<Map>()
    {
        @Override
        public boolean matches( Map map )
        {
            return map.keySet().contains( null );
        }
    };

    private Condition<Set> noNullElements = new Condition<Set>()
    {
        @Override
        public boolean matches( Set set )
        {
            return set.stream().allMatch( e -> e != null );
        }
    };

    @Test
    public void should_handle_standard_collections() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        CollectionsPojo pojo = pogoFactory.manufacturePojo( CollectionsPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getStrList() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getArrayListStr() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getCopyOnWriteList() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getHashSetStr() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getStrCollection() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getStrSet() )
        .isNotNull()
        .isNotEmpty()
        .hasAtLeastOneElementOfType( String.class );
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .has( atLeastOneNonEmptyElement );
        assertThat( pojo.getHashMap() )
        .isNotNull()
        .isNotEmpty()
        .has( atLeastOneNonEmptyElement );
        assertThat( pojo.getConcurrentHashMap() )
        .isNotNull()
        .isNotEmpty()
        .has( atLeastOneNonEmptyElement );
        assertThat( pojo.getConcurrentHashMapImpl() )
        .isNotNull()
        .isNotEmpty()
        .has( atLeastOneNonEmptyElement );
        assertThat( pojo.getQueue() )
        .isNotNull()
        .isInstanceOf( LinkedList.class )
        .hasOnlyElementsOfType( SimplePojoToTestSetters.class );
        assertThat( pojo.getNonGenerifiedList() )
        .isNotNull()
        .isNot( empty );
        assertThat( pojo.getNonGenerifiedMap() )
        .isNotNull()
        .isNot( emptyMap ).doesNotHave( nullElements );
    }

    @Test
    public void should_handle_pojos_with_no_setters_and_collections_in_the_constructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        NoSetterWithCollectionInConstructorPojo pojo = pogoFactory.manufacturePojo(
                    NoSetterWithCollectionInConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getStrList() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
        assertThat( pojo.getIntField() ).isNotNull();
    }

    @Test
    public void should_handle_immutable_pojos_with_non_generic_collections() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableWithNonGenericCollectionsPojo pojo = pogoFactory.manufacturePojo(
                    ImmutableWithNonGenericCollectionsPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getNonGenerifiedCollection() )
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .isNotEmpty()
        .isNotNull();
        assertThat( pojo.getNonGenerifiedSet() )
        .isNotEmpty()
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .has( noNullElements )
        .isNotNull();
        assertThat( pojo.getNonGenerifiedMap() )
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .isNotEmpty()
        .doesNotContainKey( null )
        .doesNotContainValue( null )
        .has( atLeastOneNonEmptyElement )
        .isNotNull();
    }

    @Test
    public void should_handle_immutable_pojo_with_generified_collections_in_constructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableWithGenericCollectionsPojo pojo = pogoFactory.manufacturePojo( ImmutableWithGenericCollectionsPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getGenerifiedCollection() )
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .isNotNull().isNotEmpty();
        assertThat( pojo.getGenerifiedMap() )
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .isNotEmpty()
        .has( atLeastOneNonEmptyElement );
        assertThat( pojo.getGenerifiedSet() )
        .hasSize( ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( ImmutableWithNonGenericCollectionsPojo.class );
    }


    @Test
    public void test_sorted_map_creation()
    {
        testMap( TreeMap.class );
    }

    @Test
    public void test_concurrent_map_Creation()
    {
        testMap( ConcurrentHashMap.class );
    }

    @Test
    public void test_hash_hap_creation()
    {
        testMap( HashMap.class );
    }


    @Test
    public void should_fill_in_pojos_with_attributes_containing_wildcards() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ReadOnlyWildcardFieldsPojo pojo	= pogoFactory.manufacturePojo( ReadOnlyWildcardFieldsPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getList() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( Object.class );
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .has( entriesWithKeyValueTypes( Object.class, Object.class ) );
    }

    private Condition<Map<?, ?>> entriesWithKeyValueTypes( Class<?> keyClass, Class<?> valueClass )
    {
        return new Condition<Map<?, ?>>()
        {
            @Override
            public boolean matches( Map<?, ?> map )
            {
                return map.entrySet().stream().allMatch( e -> e.getKey().getClass() == keyClass &&
                        e.getValue().getClass() == valueClass );
            }
        };
    }

    @Test
    public void should_be_able_to_fill_in_pojos_with_raw_type_collection_attributes_and_default_value_to_object() throws
        Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ReadOnlyRawFieldsPojo pojo = pogoFactory.manufacturePojo( ReadOnlyRawFieldsPojo.class );
        //assert
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getList() )
        .hasOnlyElementsOfType( Object.class )
        .isNotEmpty()
        .isNotNull();
        assertThat( pojo.getMap() )
        .isNotEmpty()
        .isNotNull()
        .has( entriesWithKeyValueTypes( Object.class, Object.class ) );
    }


    private void testMap( Class<? extends Map> mapType )
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        DataProviderStrategy strategy = pogoFactory.getStrategy();
        int mapSize = strategy.getNumberOfCollectionElements( PogoTestInterface.class );

        if ( mapType.isAssignableFrom( ConcurrentHashMap.class ) )
        {
            mapSize = 0;
        }

        //when
        Map<?, ?> pojo = pogoFactory.manufacturePojo( mapType, String.class, PogoTestInterface.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.keySet().size() ).isEqualTo( mapSize );
        assertThat( pojo.values().size() ).isEqualTo( mapSize );
    }
}
