/**
 *
 */
package com.codebreeze.testing.tools.pogo.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to customise string type attributes or constructor parameter.
 *
 * <p>
 * The {@code strValue} attribute takes precedence over {@code length}. If the
 * former was specified the latter will be ignored.
 * </p>
 *
 * @author mtedone
 *
 */
@Documented
@Target( value = { ElementType.FIELD, ElementType.PARAMETER } )
@Retention( RetentionPolicy.RUNTIME )
public @interface PogoStringValue
{
    /**
     * The length of the String for the annotated attribute. It defaults to
     * {@link PogoConstants#STR_DEFAULT_LENGTH}
     *
     * @return string length
     */

int length() default PogoConstants.STR_DEFAULT_LENGTH;
    /** If specified, it allows clients to specify an exact value for the string
     *
     * @return string value
     */

String strValue() default "";
    /** It allows clients to specify a comment on this annotation
     *
     * @return comment value
     */

String comment() default "";
}
