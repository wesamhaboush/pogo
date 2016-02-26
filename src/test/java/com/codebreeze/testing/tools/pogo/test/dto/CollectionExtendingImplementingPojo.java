package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class CollectionExtendingImplementingPojo extends LinkedList<String>
    implements Observer
{
    private static final long serialVersionUID = 1L;

    @Override
    public void update( Observable o, Object arg )
    {
    }
}
