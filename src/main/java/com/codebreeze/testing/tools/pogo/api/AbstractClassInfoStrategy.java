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


    @Override
    public boolean approve( ClassAttribute attribute )
    {
        return ( attribute.getAttribute() != null );
    }

    @Override
    public Set<Class<? extends Annotation>> getExcludedAnnotations()
    {
        return excludedAnnotations;
    }


    @Override
    public Set<String> getExcludedFields( final Class<?> pojoClass )
    {
        return excludedFields.get( pojoClass );
    }

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
}
