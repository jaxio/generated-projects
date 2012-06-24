/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package fr.jaxio.demo.web.domain.more;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import fr.jaxio.demo.dao.support.SearchParameters;
import fr.jaxio.demo.domain.more.MoreTypesDemo;
import fr.jaxio.demo.service.more.MoreTypesDemoService;
import fr.jaxio.demo.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 * Note: instanciate it as a var from your flow to avoid http://jira.springframework.org/browse/SWF-1224
 */
public class MoreTypesDemoLazyDataModel extends GenericLazyDataModel<MoreTypesDemo> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private MoreTypesDemoService moreTypesDemoService;
    @Inject
    transient private MoreTypesDemoSearchForm moreTypesDemoSearchForm;

    /**
     * Prepare the search parameters and call the moreTypesDemoService finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<MoreTypesDemo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = moreTypesDemoSearchForm.getSearchParameters();
        sp.clearRanges();
        sp.addRange(moreTypesDemoSearchForm.getNumberIntRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberLongRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberDoubleRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberFloatRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberBigIntegerRange());
        sp.addRange(moreTypesDemoSearchForm.getNumberBigDecimalRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJavaTemporalDateRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJavaTemporalTimestampRange());
        sp.addRange(moreTypesDemoSearchForm.getDateJodaRange());
        sp.addRange(moreTypesDemoSearchForm.getDateTimeJodaRange());

        MoreTypesDemo moreTypesDemo = moreTypesDemoSearchForm.getMoreTypesDemo();

        // total count so the paginator may display the total number of pages
        setRowCount(moreTypesDemoService.findCount(moreTypesDemo, sp));

        // load one page of data
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters);
        return moreTypesDemoService.find(moreTypesDemo, sp);
    }
}