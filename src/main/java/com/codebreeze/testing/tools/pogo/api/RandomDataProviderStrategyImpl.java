package com.codebreeze.testing.tools.pogo.api;


public final class RandomDataProviderStrategyImpl extends
    AbstractRandomDataProviderStrategy
{
    public RandomDataProviderStrategyImpl()
    {
        super();
        setMemoization( false );
    }

    public RandomDataProviderStrategyImpl( int nbrCollectionElements, boolean enableMemoization )
    {
        super();
        setMemoization( enableMemoization );
        setDefaultNumberOfCollectionElements( nbrCollectionElements );
    }
}
