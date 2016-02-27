package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.BooleanPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanUnitTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleBooleansCorrect() throws Exception
    {
        final PogoFactory pogoFactory = new PogoFactoryImpl();;
        final BooleanPojo pojo = pogoFactory.manufacturePojo( BooleanPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.isValue2() ).isNotNull();
        assertThat( pojo.getValue3() ).isNotNull();
        assertThat( pojo.getValue4() ).isNotNull();
    }

}
