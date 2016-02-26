package com.codebreeze.testing.tools.pogo.test.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class SimplePojoWithExcludeAnnotationToTestSetters extends SimplePojoToTestSetters
{

    private static final long serialVersionUID = 1L;

    @TestExclude
    private Object excludeField1;

    private Object excludeField2;

    private Boolean excludeField3;

    public SimplePojoWithExcludeAnnotationToTestSetters()
    {
    }

    public Object getExcludeField1()
    {
        return excludeField1;
    }

    public void setExcludeField1( Object excludeField1 )
    {
        this.excludeField1 = excludeField1;
    }

    @TestExclude
    public Object getExcludeField2()
    {
        return excludeField2;
    }

    public void setExcludeField2( Object excludeField2 )
    {
        this.excludeField2 = excludeField2;
    }

    @TestExclude
    public Boolean isExcludeField3()
    {
        return excludeField3;
    }

    public void setExcludeField3( Boolean excludeField3 )
    {
        this.excludeField3 = excludeField3;
    }

    @Target( value = {ElementType.FIELD, ElementType.METHOD} )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface TestExclude
    {

    }
}
