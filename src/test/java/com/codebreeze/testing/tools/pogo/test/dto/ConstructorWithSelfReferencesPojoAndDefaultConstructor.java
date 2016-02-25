/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;

import java.io.Serializable;

/**
 * @author mtedone
 *
 */
public class ConstructorWithSelfReferencesPojoAndDefaultConstructor implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ------------------->> Constants

    // ------------------->> Instance / Static variables

    /** Int field */
    private int intField;

    /** Parent instance */
    private ConstructorWithSelfReferencesPojoAndDefaultConstructor parent;

    /** Another parent instance */
    private ConstructorWithSelfReferencesPojoAndDefaultConstructor anotherParent;

    // ------------------->> Constructors

    /**
     * No-args constructor
     * <p>
     * This is a pre-requisite for this type of POJOs or a
     * {@link PogoMockeryException} will be thrown
     * </p>
     */
    public ConstructorWithSelfReferencesPojoAndDefaultConstructor()
    {
    }

    /**
     * @param intField
     * @param parent
     * @param anotherParent
     */
    @PogoConstructor
    public ConstructorWithSelfReferencesPojoAndDefaultConstructor( int intField,
            ConstructorWithSelfReferencesPojoAndDefaultConstructor parent,
            ConstructorWithSelfReferencesPojoAndDefaultConstructor anotherParent )
    {
        super();
        this.intField = intField;
        this.parent = parent;
        this.anotherParent = anotherParent;
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the intField
     */
    public int getIntField()
    {
        return intField;
    }

    /**
     * @return the parent
     */
    public ConstructorWithSelfReferencesPojoAndDefaultConstructor getParent()
    {
        return parent;
    }

    /**
     * @return the anotherParent
     */
    public ConstructorWithSelfReferencesPojoAndDefaultConstructor getAnotherParent()
    {
        return anotherParent;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
