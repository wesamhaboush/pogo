package com.codebreeze.testing.tools.pogo.typeManufacturers;

public interface TypeManufacturer
{
    <T extends TypeManufacturerParamsWrapper> Object  getType( T wrapper );
}
