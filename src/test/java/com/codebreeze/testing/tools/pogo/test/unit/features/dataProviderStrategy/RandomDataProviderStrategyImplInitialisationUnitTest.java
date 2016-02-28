package com.codebreeze.testing.tools.pogo.test.unit.features.dataProviderStrategy;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static com.codebreeze.testing.tools.pogo.common.PogoConstants.DEFAULT_NBR_COLLECTION_ELEMENTS;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomDataProviderStrategyImplInitialisationUnitTest
{


    @Test
    public void
    random_data_provider_strategy_should_be_initialised_correctly_and_allow_for_changes_in_number_of_collection_elements()
    {
        //when
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        //then
        assertThat( dataProviderStrategy.getNumberOfCollectionElements( Object.class ) ).isEqualTo(
            DEFAULT_NBR_COLLECTION_ELEMENTS );
        //when
        dataProviderStrategy.setDefaultNumberOfCollectionElements( 3 );
        //then
        assertThat( dataProviderStrategy.getNumberOfCollectionElements( Object.class ) ).isEqualTo( 3 );
    }

    @Test
    public void should_create_pojos_in_accordance_with_custom_data_provider_strategies() throws Exception
    {
        //given
        DataProviderStrategy strategy = new CustomRandomDataProviderStrategy();
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        PojoWithMapsAndCollections pojo = pogoFactory.manufacturePojo( PojoWithMapsAndCollections.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getArray() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( 2 );
        assertThat( pojo.getList() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( 3 );
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( 4 );
    }

    @Test
    public void should_correct_generate_hash_maps_with_long_as_key_type() throws Exception
    {
        //given
        DataProviderStrategy strategy = new CustomRandomDataProviderStrategy();
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        Map<?, ?> pojo = pogoFactory.manufacturePojo( HashMap.class, Long.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( strategy.getNumberOfCollectionElements( String.class ) ).isEqualTo( pojo.size() );
    }

    @Test
    public void creating_a_random_data_provider_strategy_should_create_a_constructor_light_comparator() throws Exception
    {
        //given
        AbstractRandomDataProviderStrategy randomStrategy = new RandomDataProviderStrategyImpl();
        Comparator<Constructor<?>> comparator = randomStrategy.getConstructorLightComparator();
        //then
        assertThat( comparator ).isNotNull();
        //when
        randomStrategy.setConstructorLightComparator( null );
        //then
        assertThat( randomStrategy.getConstructorLightComparator() ).isNull();
        //when
        randomStrategy.setConstructorLightComparator( comparator );
        //then
        assertThat( randomStrategy.getConstructorLightComparator() ).isEqualTo( comparator );
    }

    @Test
    public void creating_a_random_data_provider_strategy_should_create_a_constructor_heavy_comparator() throws Exception
    {
        //given
        AbstractRandomDataProviderStrategy randomStrategy = new RandomDataProviderStrategyImpl();
        //when
        Comparator<Constructor<?>> comparator = randomStrategy.getConstructorHeavyComparator();
        //then
        assertThat( comparator ).isNotNull();
        //when
        randomStrategy.setConstructorHeavyComparator( null );
        //then
        assertThat( randomStrategy.getConstructorHeavyComparator() ).isNull();
        //when
        randomStrategy.setConstructorHeavyComparator( comparator );
        //then
        assertThat( randomStrategy.getConstructorHeavyComparator() ).isEqualTo( comparator );
    }

    @Test
    public void creating_a_random_data_provider_strategy_should_create_a_method_light_comparator() throws Exception
    {
        //given
        AbstractRandomDataProviderStrategy randomStrategy = new RandomDataProviderStrategyImpl();
        //when
        Comparator<Method> comparator = randomStrategy.getMethodLightComparator();
        //then
        assertThat( comparator ).isNotNull();
        //when
        randomStrategy.setMethodLightComparator( null );
        //then
        assertThat( randomStrategy.getMethodLightComparator() ).isNull();
        //when
        randomStrategy.setMethodLightComparator( comparator );
        //then
        assertThat( randomStrategy.getMethodLightComparator() ).isEqualTo( comparator );
    }

    @Test
    public void creating_a_random_data_provider_strategy_should_create_a_method_heavy_comparator() throws Exception
    {
        //given
        AbstractRandomDataProviderStrategy randomStrategy = new RandomDataProviderStrategyImpl();
        //when
        Comparator<Method> comparator = randomStrategy.getMethodHeavyComparator();
        //then
        assertThat( comparator ).isNotNull();
        //when
        randomStrategy.setMethodHeavyComparator( null );
        //then
        assertThat( randomStrategy.getMethodHeavyComparator() ).isNull();
        //when
        randomStrategy.setMethodHeavyComparator( comparator );
        //then
        assertThat( randomStrategy.getMethodHeavyComparator() ).isEqualTo( comparator );
    }

}
