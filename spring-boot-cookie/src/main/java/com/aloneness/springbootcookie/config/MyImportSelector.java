package com.aloneness.springbootcookie.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                MyConfiguration1.class.getName(), MyConfiguration2.class.getName(), MyConfiguration3.class.getName()
        };
    }
}
