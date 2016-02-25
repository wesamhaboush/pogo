package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;

public class PogoStrategySteps
{

    public <T> void addOrReplaceSpecific( PogoFactory PogoFactory, Class<T> abstractType,
                                          Class<? extends T> concreteType )
    {
        DataProviderStrategy strategy = PogoFactory.getStrategy();
        strategy.addOrReplaceSpecific( abstractType, concreteType );
    }


}
