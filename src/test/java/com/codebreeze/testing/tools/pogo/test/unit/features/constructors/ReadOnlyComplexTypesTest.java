package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyAbstract;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyGenericComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import java.beans.beancontext.BeanContextServicesSupport;

public class ReadOnlyComplexTypesTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldFillReadOnlyTypes() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ReadOnlyComplexTypesPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                            ReadOnlyComplexTypesPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Integer.class );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Long.class, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
    }

    @Test
    public void PogoShouldFillReadOnlyComplexTypes() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ReadOnlyGenericComplexTypesPojo<?, ?, ?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                ReadOnlyGenericComplexTypesPojo.class, PogoFactory, Character.class, Long.class, Integer.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Long.class );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Integer.class, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( Character.class, pojo.getValue().getValue().getClass() );
    }

    @Test
    public void PogoShouldFillInPojosWhichContainInternalLoops() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        BeanContextServicesSupport pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                              BeanContextServicesSupport.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }


    @Test
    public void PogoShouldCreateAnInstanceOfAnAbstractClassWithAFactoryMethodWhichReturnsAConcreteType()
    throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ReadOnlyAbstract pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ReadOnlyAbstract.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }
}
