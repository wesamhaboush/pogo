package com.codebreeze.testing.tools.pogo.test.unit.features.classInfo;

import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import com.codebreeze.testing.tools.pogo.api.ClassAttributeApprover;
import com.codebreeze.testing.tools.pogo.api.ClassInfo;
import com.codebreeze.testing.tools.pogo.api.PogoUtils;
import com.codebreeze.testing.tools.pogo.test.dto.EmptyTestPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassInfoTest
{

    @Test
    public void should_return_a_valid_class_info_for_pojo_with_no_attributes()
    {
        //given
        List<ClassAttribute> attributes = new ArrayList<>();
        ClassInfo expectedClassInfo = new ClassInfo( EmptyTestPojo.class, attributes );
        ClassAttributeApprover nullApprover = null;
        //when
        ClassInfo actualClassInfo = PogoUtils.getClassInfo( EmptyTestPojo.class, nullApprover );
        //then
        assertThat( actualClassInfo ).isEqualTo( expectedClassInfo );
    }

    @Test
    public void should_return_a_class_info_object_which_contains_the_same_attributes_as_the_pojo_being_processed()
    {
        //given
        ClassAttributeApprover nullApprover = null;
        //when
        ClassInfo actualClassInfo = PogoUtils.getClassInfo( SimplePojoToTestSetters.class, nullApprover );
        //then
        assertThat( actualClassInfo ).isNotNull();
        assertThat( actualClassInfo.getClassName() ).isSameAs( SimplePojoToTestSetters.class );
        assertThat( actualClassInfo.getClassAttributes() )
        .hasSize( 2 )
        .extracting( "attribute.name" )
        .containsOnly( "stringField", "intField" );
        assertThat( actualClassInfo.getClassAttributes() )
        .filteredOn( attribute -> attribute.getGetters().size() != 1 || attribute.getSetters().size() != 1 )
        .isEmpty();
    }
}
