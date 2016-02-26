package com.codebreeze.testing.tools.pogo.test.dto.pdm42;

public class FieldInfo
{

    private String fieldName;

    private String namespace;

    private String namespacePrefix;

    public FieldInfo()
    {
    }

    public FieldInfo( String fieldName, String namespace )
    {
        this.fieldName = fieldName;
        this.namespace = namespace;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName( String fieldName )
    {
        this.fieldName = fieldName;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public void setNamespace( String namespace )
    {
        this.namespace = namespace;
    }

    public String getNamespacePrefix()
    {
        return namespacePrefix;
    }

    public void setNamespacePrefix( String namespacePrefix )
    {
        this.namespacePrefix = namespacePrefix;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "FieldInfo ( " +
                          super.toString() + TAB +
                          "fieldName = " + this.fieldName + TAB +
                          "namespace = " + this.namespace + TAB +
                          "namespacePrefix = " + this.namespacePrefix + TAB +
                          " )";
        return retValue;
    }


}
