package com.codebreeze.testing.tools.pogo.test.dto.pdm3;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Pdm3Pojo
{

    private List<?> something;

    private List<? extends RuntimeException> descendants;

    private List<? super NullPointerException> ancestors;

    public List<?> getSomething()
    {
        return something;
    }

    public void setSomething( List<?> something )
    {
        this.something = something;
    }

    public List<? extends RuntimeException> getDescendants()
    {
        return descendants;
    }

    public void setDescendants( List<? extends RuntimeException> descendants )
    {
        this.descendants = descendants;
    }

    public List<? super NullPointerException> getAncestors()
    {
        return ancestors;
    }

    public void setAncestors( List<? super NullPointerException> ancestors )
    {
        this.ancestors = ancestors;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
