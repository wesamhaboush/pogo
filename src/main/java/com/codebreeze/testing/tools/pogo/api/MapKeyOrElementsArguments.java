package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MapKeyOrElementsArguments extends AbstractMapArguments implements
    Serializable
{

    private static final long serialVersionUID = 1L;

    private Class<?> keyOrValueType;

    private AttributeStrategy<?> elementStrategy;

    private Type[] genericTypeArgs;

    public Class<?> getKeyOrValueType()
    {
        return keyOrValueType;
    }

    public void setKeyOrValueType( Class<?> keyOrValueType )
    {
        this.keyOrValueType = keyOrValueType;
    }

    public AttributeStrategy<?> getElementStrategy()
    {
        return elementStrategy;
    }

    public void setElementStrategy( AttributeStrategy<?> elementStrategy )
    {
        this.elementStrategy = elementStrategy;
    }

    public Type[] getGenericTypeArgs()
    {
        return genericTypeArgs;
    }

    public void setGenericTypeArgs( Type[] genericTypeArgs )
    {
        this.genericTypeArgs = genericTypeArgs.clone();
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
