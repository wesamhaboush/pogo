package com.codebreeze.testing.tools.pogo.test.dto.pdm6;

import java.util.List;

public class RecursiveList
{

    private List<RecursiveList> list;

    public List<RecursiveList> getList()
    {
        return this.list;
    }

    public void setList( List<RecursiveList> list )
    {
        this.list = list;
    }
}
