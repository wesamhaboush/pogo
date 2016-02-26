package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class MapExtendingImplementingPojo extends TreeMap<Integer, String>
    implements Observer
{
    private static final long serialVersionUID = 1L;

    @Override
    public void update( Observable o, Object arg )
    {
    }
}
