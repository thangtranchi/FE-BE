package com.metasoft.em.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * See http://wiki.sitemesh.org/display/sitemesh3/Configuring+SiteMesh+3
 */
public class SitemeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        // apply this decorator (template) to the path defined...
        builder.addDecoratorPath("/*", "/WEB-INF/decorators/mainDecorator.jsp");
        builder.addExcludedPath("/ajax/*");
        // ... when the response type matches one of these
        builder.setMimeTypes("text/html", "application/xhtml+xml", "application/vnd.wap.xhtml+xml");
    }
}
