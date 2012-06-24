/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package fr.jaxio.demo.web.domain;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import fr.jaxio.demo.dao.support.SearchParameters;
import fr.jaxio.demo.domain.Role;
import fr.jaxio.demo.service.RoleService;
import fr.jaxio.demo.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 * Note: instanciate it as a var from your flow to avoid http://jira.springframework.org/browse/SWF-1224
 */
public class RoleLazyDataModel extends GenericLazyDataModel<Role> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private RoleService roleService;
    @Inject
    transient private RoleSearchForm roleSearchForm;

    /**
     * Prepare the search parameters and call the roleService finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Role> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = roleSearchForm.getSearchParameters();

        Role role = roleSearchForm.getRole();

        // total count so the paginator may display the total number of pages
        setRowCount(roleService.findCount(role, sp));

        // load one page of data
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters);
        return roleService.find(role, sp);
    }
}