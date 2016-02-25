/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.pdm43;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mtedone
 *
 */
public abstract class BusinessObjectWithErrors<ID extends Serializable> extends
    BusinessObject<ID>
{

    private List<String> errorCodeList = new ArrayList<>();

    /**
     * @return the errorCodes
     */
    public List<String> getErrorCodeList()
    {
        return errorCodeList;
    }

    /**
     * Set the error strings.
     */
    public void setErrorCodeList( List<String> allErrors )
    {
        this.errorCodeList = allErrors;
    }

    // body

}
