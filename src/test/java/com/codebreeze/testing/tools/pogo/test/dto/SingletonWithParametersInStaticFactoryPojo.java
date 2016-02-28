package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class SingletonWithParametersInStaticFactoryPojo
{
    private final Calendar createDate;

    private final List<OneDimensionalTestPojo> pojoList;

    private final Map<String, OneDimensionalTestPojo> pojoMap;

    private final String firstName;

    private static SingletonWithParametersInStaticFactoryPojo singleton;

    private SingletonWithParametersInStaticFactoryPojo( Calendar createDate,
            List<OneDimensionalTestPojo> pojoList,
            Map<String, OneDimensionalTestPojo> pojoMap, String firstName )
    {
        super();
        this.createDate = createDate;
        this.pojoList = pojoList;
        this.pojoMap = pojoMap;
        this.firstName = firstName;
    }

    public static SingletonWithParametersInStaticFactoryPojo getInstance(
        Calendar createDate, List<OneDimensionalTestPojo> pojoList,
        Map<String, OneDimensionalTestPojo> pojoMap, String firstName )
    {
        if ( null == singleton )
        {
            singleton = new SingletonWithParametersInStaticFactoryPojo(
                createDate, pojoList, pojoMap, firstName );
        }

        return singleton;
    }

    public Calendar getCreateDate()
    {
        return createDate;
    }

    public List<OneDimensionalTestPojo> getPojoList()
    {
        return pojoList;
    }

    public Map<String, OneDimensionalTestPojo> getPojoMap()
    {
        return pojoMap;
    }

    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
