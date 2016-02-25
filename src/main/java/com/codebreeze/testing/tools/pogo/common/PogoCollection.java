/**
 *
 */
package com.codebreeze.testing.tools.pogo.common;

import com.codebreeze.testing.tools.pogo.api.ObjectStrategy;

import java.lang.annotation.*;

@Documented
@Target( value = { ElementType.FIELD, ElementType.PARAMETER } )
@Retention( RetentionPolicy.RUNTIME )
public @interface PogoCollection
{
    /** The number of elements to create for the collection
     *
     * @return number of elements to place into collection
     */

int nbrElements() default PogoConstants.DEFAULT_NBR_COLLECTION_ELEMENTS;
    /**
     * The strategy that will populate the annotated attribute.
     * <p>
     * The default, in order to make the strategy actually <i>optional</i> is
     * type Object. At runtime, only if both the value of this annotation and
     * the collection element type are Objects, then the collection will be set
     * with type {@link Object}, otherwise the collection element type will win.
     * </p>
     *
     * @return The strategy that will populate the annotated attribute
     */

Class<? extends AttributeStrategy<?>> collectionElementStrategy() default ObjectStrategy.class;
    /**
     * The strategy that will populate a map key on an attribute of type Map.
     * <p>
     * The default, in order to make the strategy actually <i>optional</i> is
     * type Object. At runtime, only if both the value of this annotation and
     * the collection element type are Objects, then the collection will be set
     * with type {@link Object}, otherwise the collection element type will win.
     * </p>
     *
     * @return The strategy that will populate a map key on an attribute of type
     *         Map.
     */

Class<? extends AttributeStrategy<?>> mapKeyStrategy() default ObjectStrategy.class;
    /**
     * The strategy that will populate a map element on an attribute of type
     * Map.
     * <p>
     * The default, in order to make the strategy actually <i>optional</i> is
     * type Object. At runtime, only if both the value of this annotation and
     * the collection element type are Objects, then the collection will be set
     * with type {@link Object}, otherwise the collection element type will win.
     * </p>
     *
     * @return The strategy that will populate a map element on an attribute of
     *         type Map.
     */

Class<? extends AttributeStrategy<?>> mapElementStrategy() default ObjectStrategy.class;
    /** It allows clients to specify a comment on this annotation
     *
     * @return comment value
     */

String comment() default "";
}
