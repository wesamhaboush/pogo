package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;

public class PodamStrategySteps
{

    public <T> void addOrReplaceSpecific( PodamFactory podamFactory, Class<T> abstractType,
                                          Class<? extends T> concreteType )
    {
        DataProviderStrategy strategy = podamFactory.getStrategy();
        strategy.addOrReplaceSpecific( abstractType, concreteType );
    }


}
