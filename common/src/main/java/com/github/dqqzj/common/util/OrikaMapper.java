package com.github.dqqzj.common.util;

import com.github.dqqzj.common.util.convert.orika.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


import java.util.List;

/**
 * @author qinzhongjian
 * @date created in 2018/6/25 23:17
 * @since 1.0.0
 */
public final class OrikaMapper {

    private static final MapperFacade FACADE;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        final ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new InstantConverter());
        converterFactory.registerConverter(new LocalDateConverter());
        converterFactory.registerConverter(new LocalDateTimeConverter());
        converterFactory.registerConverter(new LocalTimeConverter());
        converterFactory.registerConverter(new OffsetDateTimeConverter());
        converterFactory.registerConverter(new ZonedDateTimeConverter());
        FACADE = mapperFactory.getMapperFacade();
    }

    private OrikaMapper() {
    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return FACADE.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return FACADE.mapAsList(sourceList, destinationClass);
    }

}
