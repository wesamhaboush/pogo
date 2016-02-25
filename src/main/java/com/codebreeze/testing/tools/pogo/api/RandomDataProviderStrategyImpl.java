package com.codebreeze.testing.tools.pogo.api;


public final class RandomDataProviderStrategyImpl extends
    AbstractRandomDataProviderStrategy
{
    public RandomDataProviderStrategyImpl()
    {
        super();
        setMemoization( false );
    }

    public static RandomDataProviderStrategyImpl getInstance(
        int nbrCollectionElements )
    {
        RandomDataProviderStrategyImpl strategy = new RandomDataProviderStrategyImpl();
        strategy.setDefaultNumberOfCollectionElements( nbrCollectionElements );
        return strategy;
    }
}
