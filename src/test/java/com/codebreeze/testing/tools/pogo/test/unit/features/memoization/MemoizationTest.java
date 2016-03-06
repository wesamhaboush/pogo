package com.codebreeze.testing.tools.pogo.test.unit.features.memoization;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.api.RandomDataProviderStrategyImpl;
import com.codebreeze.testing.tools.pogo.test.dto.MemoizationPojo;
import com.codebreeze.testing.tools.pogo.test.dto.RecursivePojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.assertj.core.api.Condition;
import org.junit.Test;

import javax.xml.ws.Holder;
import java.util.Currency;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoizationTest
{

    @Test
    public void ahould_return_the_same_instance_for_different_invocations_whenMemoization_is_enabled() throws Exception
    {
        //given
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl( 3, true );
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        SimplePojoToTestSetters pojo1 = pogoFactory.manufacturePojo( SimplePojoToTestSetters.class );
        SimplePojoToTestSetters pojo2 = pogoFactory.manufacturePojo( SimplePojoToTestSetters.class );
        //then
        assertThat( pojo1 ).isNotNull();
        assertThat( pojo2 ).isNotNull();
        assertThat( pojo1 ).isSameAs( pojo2 );
    }


    @Test
    public void should_return_different_instances_for_different_invocations_when_memoization_is_disabled() throws Exception
    {
        //given
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl( 3, false );
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        SimplePojoToTestSetters pojo1 = pogoFactory.manufacturePojo( SimplePojoToTestSetters.class );
        SimplePojoToTestSetters pojo2 = pogoFactory.manufacturePojo( SimplePojoToTestSetters.class );
        //then
        assertThat( pojo1 ).isNotNull();
        assertThat( pojo2 ).isNotNull();
        assertThat( pojo1 ).isNotSameAs( pojo2 );
    }

    @Test
    public void should_allow_memoization_for_for_recursive_pojos() throws Exception
    {
        //given
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl( 3, true );
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        RecursivePojo pojo = pogoFactory.manufacturePojo( RecursivePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo ).isSameAs( pojo.getParent() );
    }

    @Test
    public void should_allow_memoization_with_generics() throws Exception
    {
        //given
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl( 3, true );
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //given
        Holder<String> pojo1 = pogoFactory.manufacturePojo( Holder.class, String.class );
        Holder<String> pojo2 = pogoFactory.manufacturePojo( Holder.class, String.class );
        //then
        assertThat( pojo1 ).isNotNull();
        assertThat( pojo2 ).isNotNull();
        assertThat( pojo1 ).isSameAs( pojo2 );
        assertThat( pojo1.value ).isSameAs( pojo2.value );
    }

    @Test
    public void should_not_return_same_objects_for_generic_pojos_with_different_types_even_if_memoization_is_enabled()
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        Holder<String> pojo1 = pogoFactory.manufacturePojo( Holder.class, String.class );
        Holder<String> pojo2 = pogoFactory.manufacturePojo( Holder.class, Integer.class );
        //then
        assertThat( pojo1 ).isNotNull();
        assertThat( pojo2 ).isNotNull();
        assertThat( pojo1 ).isNotSameAs( pojo2 );
    }

    @Test
    public void should_allow_memoization_for_collections_and_arrays() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        MemoizationPojo pojo = pogoFactory.manufacturePojo( MemoizationPojo.class );
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getArray() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( pogoFactory.getStrategy().getNumberOfCollectionElements( Currency.class ) )
        .hasOnlyElementsOfType( Currency.class );
        assertThat( pojo.getCollection() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( pogoFactory.getStrategy().getNumberOfCollectionElements( Currency.class ) )
        .hasOnlyElementsOfType( Currency.class );
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( pogoFactory.getStrategy().getNumberOfCollectionElements( Currency.class ) )
        .has( onlyKeysAndValuesOfType( Currency.class ) );
    }

    private static Condition<? super Map<Currency, Currency>> onlyKeysAndValuesOfType( final Class<Currency>
            currencyClass )
    {
        return new Condition<Map<Currency, Currency>>()
        {
            @Override
            public boolean matches( Map<Currency, Currency> map )
            {
                return map
                       .entrySet()
                       .stream()
                       .allMatch( e -> e.getKey().getClass() == currencyClass &&
                                  e.getValue().getClass() == currencyClass );
            }
        };
    }
}
