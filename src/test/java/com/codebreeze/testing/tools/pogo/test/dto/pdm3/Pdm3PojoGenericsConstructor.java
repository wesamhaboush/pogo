package com.codebreeze.testing.tools.pogo.test.dto.pdm3;

import java.util.List;

public class Pdm3PojoGenericsConstructor
{

    public Pdm3PojoGenericsConstructor(
        List<?> something,
        List<? extends RuntimeException> descendants,
        List<? super NullPointerException> ancestors )
    {
        this.something = something;
        this.descendants = descendants;
        this.ancestors = ancestors;
    }

    private final List<?> something;

    private final List<? extends RuntimeException> descendants;

    private final List<? super NullPointerException> ancestors;

    public List<?> getSomething()
    {
        return something;
    }

    public List<? extends RuntimeException> getDescendants()
    {
        return descendants;
    }

    public List<? super NullPointerException> getAncestors()
    {
        return ancestors;
    }

    @Override
    public String toString()
    {
        return String.format(
                   "{something: '%s'} {descendants: '%s'} {ancestors: '%s'}",
                   something, descendants, ancestors );
    }
}
