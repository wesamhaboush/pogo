package com.codebreeze.testing.tools.pogo.test.unit.issue86;

import com.codebreeze.testing.tools.pogo.api.DefaultClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyInitPojoUnitTest
{

    private final DefaultClassInfoStrategy classInfoStrategy = DefaultClassInfoStrategy.getInstance();


    private final PogoFactory Pogo = new PogoFactoryImpl();

    @Before
    public void init() throws Exception
    {
        classInfoStrategy.addExtraMethod( MyInitPojo.class, "init", String.class, String.class );
    }

    @Test
    public void testMyInitPojo() throws Exception
    {
        MyInitPojo pojo = Pogo.manufacturePojo( MyInitPojo.class );
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getString1() ).isNotSameAs( pojo.getBackupString1() );
        assertThat( pojo.getString2() ).isNotSameAs( pojo.getBackupString2() );
    }
}
