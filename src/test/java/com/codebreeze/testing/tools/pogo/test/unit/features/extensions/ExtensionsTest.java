package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoClassic;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import org.assertj.core.api.Condition;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtensionsTest extends AbstractPogoSteps
{


    private Condition<? super Map<Integer, Long>> atLeastOneNonEmptyElement = new Condition<Map<?, ?>>()
    {
        @Override
        public boolean matches( Map<?, ?> map )
        {
            return map.entrySet().stream().anyMatch( e -> e.getKey() != null && e.getValue() != null );
        }
    };

    @Test
    public void should_fill_the_attribute_metadata_with_the_attribute_names() throws Exception
    {
        //given
        PogoFactory pogoFactory = PogoFactorySteps.givenAPogoExternalFactorytoTestAttributeMetadata();
        //when
        PojoClassic pojoClassic = pogoFactory.manufacturePojo( PojoClassic.class );
        PojoSpecific pojoSpecific = pogoFactory.manufacturePojo( PojoSpecific.class );
        //then
        assertThat( pojoClassic ).isNotNull();
        assertThat( pojoSpecific ).isNotNull();
        assertThat( pojoClassic.getAtt() ).isEqualTo( "classic" );
        assertThat( pojoSpecific.getAtt() ).isEqualTo( "specific" );
    }

    @Test
    public void should_create_pojos_in_accordance_with_custom_data_provider_strategies() throws Exception
    {
        //given
        CustomRandomDataProviderStrategy strategy = new CustomRandomDataProviderStrategy();
        PogoFactory pogoFactory = new PogoFactoryImpl( strategy );
        //when
        PojoWithMapsAndCollections pojo = pogoFactory.manufacturePojo( PojoWithMapsAndCollections.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getArray() ).isNotNull().hasSize( 2 );
        assertThat( pojo.getList() ).isNotNull().hasSize( 3 );
        assertThat( pojo.getMap() )
        .hasSize( 4 )
        .has( atLeastOneNonEmptyElement );
    }


}
