package com.codebreeze.testing.tools.pogo.test.unit.issue86;

import com.codebreeze.testing.tools.pogo.api.DefaultClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class MyInitPojoUnitTest
{

    private final DefaultClassInfoStrategy classInfoStrategy = DefaultClassInfoStrategy.getInstance();


    private final PodamFactory podam = new PodamFactoryImpl();

    @Before
    public void init() throws Exception
    {
        classInfoStrategy.addExtraMethod( MyInitPojo.class, "init", String.class, String.class );
    }

    @Test
    public void testMyInitPojo() throws Exception
    {
        MyInitPojo pojo = podam.manufacturePojo( MyInitPojo.class );
        assertNotNull( pojo );
        assertNotSame( pojo.getString1(), pojo.getBackupString1() );
        assertNotSame( pojo.getString2(), pojo.getBackupString2() );
    }
}
