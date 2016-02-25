package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.List;

/**
 * Pojo derived from two interfaces: List and another one
 *
 * @author daivanov
 *
 */
public interface MultipleInterfacesListPojo<T> extends List<T>, Appendable
{
}

