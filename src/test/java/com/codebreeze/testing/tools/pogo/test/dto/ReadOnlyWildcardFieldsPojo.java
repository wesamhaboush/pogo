/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POJO to test read-only fields with wildcards instantiation
 *
 * @author daivanov
 *
 */
public class ReadOnlyWildcardFieldsPojo
{

    private final Class<?> clazz = Object.class;

    private final List<?> list = new ArrayList<>();

    private final Map<?, ?> map = new HashMap<>();

    public Class<?> getClazz()
    {
        return clazz;
    }

    public List<?> getList()
    {
        return list;
    }

    public Map<?, ?> getMap()
    {
        return map;
    }
}
