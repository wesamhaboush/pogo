package com.codebreeze.testing.tools.pogo.api;


public final class DefaultClassInfoStrategy extends
    AbstractClassInfoStrategy
{

    private static final DefaultClassInfoStrategy SINGLETON = new DefaultClassInfoStrategy();

    private DefaultClassInfoStrategy()
    {
        super();
    }


    public static DefaultClassInfoStrategy getInstance()
    {
        return SINGLETON;
    }

    public static DefaultClassInfoStrategy getInstance(
        int nbrCollectionElements )
    {
        return SINGLETON;
    }
}
