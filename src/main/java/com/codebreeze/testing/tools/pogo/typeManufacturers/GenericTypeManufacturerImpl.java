package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default byte type manufacturer.
 *
 * Created by tedonema on 17/05/2015.
 *
 * @since 6.0.0.RELEASE
 */
public class GenericTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public <T extends TypeManufacturerParamsWrapper> Object getType( T wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        TypeManufacturerParamsWrapperForGenericTypes localWrapper = ( TypeManufacturerParamsWrapperForGenericTypes ) wrapper;
        AttributeMetadata attributeMetadata = localWrapper.getAttributeMetadata();
        Type[] genericArgs = attributeMetadata.getAttrGenericArgs();
        Class<?> attributeType = attributeMetadata.getAttributeType();

        if ( null == genericArgs )
        {
            String errorMessage = "For generic type arguments, the attribute metadata" +
                                  " should contain a non null Type[]";
            throw new IllegalArgumentException( errorMessage );
        }

        Type genericAttributeType = localWrapper.getAttributeGenericType();
        Map<String, Type> typeArgumentsMap = localWrapper.getTypeArgumentsMap();

        if ( null == typeArgumentsMap )
        {
            String errMsg = "The type arguments map in the wrapper cannot be null";
            throw new IllegalArgumentException( errMsg );
        }

        Object retValue = null;
        Type paremeterType = null;

        if ( genericAttributeType instanceof ParameterizedType )
        {
            ParameterizedType parametrized =  ( ParameterizedType ) genericAttributeType;
            Type[] arguments = parametrized.getActualTypeArguments();

            if ( arguments.length > 0 )
            {
                paremeterType = arguments[0];
            }
        }
        else if ( attributeType.getTypeParameters().length > 0 )
        {
            paremeterType = attributeType.getTypeParameters()[0];
        }

        if ( paremeterType != null )
        {
            AtomicReference<Type[]> elementGenericTypeArgs
                = new AtomicReference<>( PodamConstants.NO_TYPES );
            retValue = TypeManufacturerUtil.resolveGenericParameter( paremeterType,
                       typeArgumentsMap, elementGenericTypeArgs );
        }
        else
        {
        }

        return retValue;
    }
}
