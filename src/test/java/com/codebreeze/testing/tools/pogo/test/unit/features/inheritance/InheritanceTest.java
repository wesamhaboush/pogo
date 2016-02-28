package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ClassInheritedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalChildPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.A;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.B;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InheritanceTest extends AbstractPogoSteps
{

    @Test
    public void should_handle_basic_inheritance() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        OneDimensionalChildPojo pojo = pogoFactory.manufacturePojo( OneDimensionalChildPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getParentCalendarField() ).isNotNull();
        assertThat( pojo.getParentCalendarField().getTime() ).isNotNull();
        assertThat( pojo.getIntField() ).isNotNull();
        assertThat( pojo.getStrField() ).isNotNull().isNotEmpty();
    }

    @Test
    public void should_handle_the_manufacturing_of_pojos_which_inherit_from_other_classes() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ClassInheritedPojo pojo = pogoFactory.manufacturePojo( ClassInheritedPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getClazz() ).isNotNull().isEqualTo( String.class );
    }


    @Test
    public void should_manufacture_all_pojos_in_a_tree_hierarchy() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        A pojo = pogoFactory.manufacturePojo( A.class );
        B b = pojo.getB();
        //then
        assertThat( pojo ).isNotNull();
        assertThat( b ).isNotNull();
        assertThat( b.getCustomValue() ).isNotNull();
    }
}
