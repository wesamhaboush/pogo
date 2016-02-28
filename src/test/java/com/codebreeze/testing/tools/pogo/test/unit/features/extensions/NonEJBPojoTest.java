package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.NonEJBPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class NonEJBPojoTest extends AbstractPogoSteps
{

    @Test
    public void should_handle_attributes_in_accordance_with_custom_class_info_strategies() throws Exception
    {
        //given
        NonEJBClassInfoStrategy classInfoStrategy = new NonEJBClassInfoStrategy();
        PogoFactory pogoFactory = new PogoFactoryImpl().setClassStrategy( classInfoStrategy );
        //when
        NonEJBPojo pojo = pogoFactory.manufacturePojo( NonEJBPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getMyString() ).isNotNull().isNotEmpty();
        assertThat( pojo.getMyLong() ).isNotNull();
    }
}
