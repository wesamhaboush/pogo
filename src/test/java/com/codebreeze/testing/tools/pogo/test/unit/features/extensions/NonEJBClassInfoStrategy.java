package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import com.codebreeze.testing.tools.pogo.test.dto.NonEJBPojo;
import com.codebreeze.testing.tools.pogo.api.AbstractClassInfoStrategy;

import java.lang.reflect.Method;

public class NonEJBClassInfoStrategy extends AbstractClassInfoStrategy
{

    @Override
    public boolean approve( ClassAttribute attribute )
    {
        /* EJB attributes: field and setter */
        if ( attribute.getAttribute() != null )
        {
            return true;
        }

        /* Exclusion for NonEJBPojo class */
        for ( Method setter : attribute.getSetters() )
        {
            if ( NonEJBPojo.class.equals( setter.getDeclaringClass() ) )
            {
                return true;
            }
        }

        return false;
    }
}
