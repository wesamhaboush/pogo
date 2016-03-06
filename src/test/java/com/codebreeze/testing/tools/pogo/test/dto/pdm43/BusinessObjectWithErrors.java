package com.codebreeze.testing.tools.pogo.test.dto.pdm43;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class BusinessObjectWithErrors<ID extends Serializable> extends
    BusinessObject<ID>
{

    private List<String> errorCodeList = new ArrayList<>();

    public List<String> getErrorCodeList()
    {
        return errorCodeList;
    }

    public void setErrorCodeList( List<String> allErrors )
    {
        this.errorCodeList = allErrors;
    }
}
