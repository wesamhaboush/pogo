/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public abstract class AbstractClassInfoStrategy implements ClassInfoStrategy,
    ClassAttributeApprover
{

    private final Set<Class<? extends Annotation>> excludedAnnotations =
        new HashSet<>();

    private final Map<Class<?>, Set<String>> excludedFields
        = new HashMap<>();

    private final Map<Class<?>, List<Method>> extraMethods = new HashMap<>();


    public AbstractClassInfoStrategy addExcludedAnnotation(
        final Class<? extends Annotation> annotation )
    {
        excludedAnnotations.add( annotation );
        return this;
    }

    public AbstractClassInfoStrategy addExtraMethod(
        Class<?> pojoClass, String methodName, Class<?> ... methodArgs )
    throws NoSuchMethodException, SecurityException
    {
        Method method = pojoClass.getMethod( methodName, methodArgs );
        List<Method> methods = extraMethods.get( pojoClass );

        if ( methods == null )
        {
            methods = new ArrayList<>();
            extraMethods.put( pojoClass, methods );
        }

        methods.add( method );
        return this;
    }

    public AbstractClassInfoStrategy removeExcludedAnnotation(
        final Class<? extends Annotation> annotation )
    {
        excludedAnnotations.remove( annotation );
        return this;
    }

    /**
     * Adds the specified field to set of excluded fields,
     * if it is not already present.
     *
     * @param pojoClass
     *        a class for which fields should be skipped
     * @param fieldName
     *            the field name to use as an exclusion mark
     * @return itself
     */
    public AbstractClassInfoStrategy addExcludedField(
        final Class<?> pojoClass, final String fieldName )
    {
        Set<String> fields = excludedFields.get( pojoClass );

        if ( fields == null )
        {
            fields = new HashSet<>();
            excludedFields.put( pojoClass, fields );
        }

        fields.add( fieldName );
        return this;
    }

    /**
     * Removes the field name from set of excluded fields.
     *
     * @param pojoClass
     *        a class for which fields should be skipped
     * @param fieldName
     *            the field name used as an exlusion mark
     * @return itself
     */
    public AbstractClassInfoStrategy removeExcludedField(
        final Class<?> pojoClass, final String fieldName )
    {
        Set<String> fields = excludedFields.get( pojoClass );

        if ( fields != null )
        {
            fields.remove( fieldName );
        }

        return this;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean approve( ClassAttribute attribute )
    {
        return ( attribute.getAttribute() != null );
    }

    // ------------------->> Getters / Setters
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Class<? extends Annotation>> getExcludedAnnotations()
    {
        return excludedAnnotations;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> getExcludedFields( final Class<?> pojoClass )
    {
        return excludedFields.get( pojoClass );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassInfo getClassInfo( Class<?> pojoClass )
    {
        Set<String> excludedAttributes = excludedFields.get( pojoClass );

        if ( null == excludedAttributes )
        {
            excludedAttributes = Collections.emptySet();
        }

        List<Method> localExtraMethods = extraMethods.get( pojoClass );

        if ( null == localExtraMethods )
        {
            localExtraMethods = Collections.emptyList();
        }

        return PogoUtils.getClassInfo( pojoClass,
                                       excludedAnnotations, excludedAttributes, this, localExtraMethods );
    }

    @Override
    public ClassAttributeApprover getClassAttributeApprover( Class<?> pojoClass )
    {
        return this;
    }

    @Override
    public Collection<Method> getExtraMethods( Class<?> pojoClass )
    {
        return extraMethods.get( pojoClass );
    }


    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
