package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Map;

/**
 * Pojo derived from two interfaces: Map and another one
 *
 * @author daivanov
 *
 */
public interface MultipleInterfacesMapPojo<K, V> extends Map<K, V>, Appendable
{
}

