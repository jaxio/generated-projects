<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ attribute name="totalSize" type="java.lang.Integer" required="true"
%><%@ attribute name="search" type="com.company.demo.repository.support.SearchParameters" required="true"
%><%@ attribute name="url" type="java.lang.String"
%><%
int pageSize = search.getPageSize();
int pageNumber = search.getPageNumber();

int totalPages = ((totalSize - 1) / pageSize) + 1;

boolean hasFirstPage 	= false;
boolean hasPreviousPage = false;
boolean hasNextPage 	= false;
boolean hasLastPage 	= false;

int previousPage 	= 0;
int nextPage 		= 0;
int lastPage 		= totalPages;

if (pageNumber > 1) {
	hasFirstPage = true;
	hasPreviousPage = true;
	previousPage = pageNumber - 1;
}
if (pageNumber < totalPages) {
	hasNextPage = true;
	hasLastPage = true;
	nextPage = pageNumber + 1;
}
%>
<c:set var="operator" value="?"/>
<c:url var="computedUrl" value="${url}">
	<c:forEach items="${param}" var="par">
		<c:choose>
			<c:when test="${par.key == 'decorator'}"/>
			<c:when test="${par.key == 'sp.pageNumber'}"/>
			<c:when test="${par.key == 'sp.sortOrder'}"/>
			<c:otherwise>
				<c:param name="${par.key}" value="${par.value}"/>
				<c:set var="operator" value="&amp;"/>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:url>
<c:forEach items="${param}" var="par">
	<c:choose>
		<c:when test="${par.key == 'decorator'}"/>
		<c:when test="${par.key == 'sp.pageNumber'}"/>
		<c:when test="${par.key == 'sp.sortOrder'}"/>
		<c:otherwise>
			<input type="hidden" name="${par.key}" value="<c:out value="${par.value}"/>"/>
		</c:otherwise>
	</c:choose>
</c:forEach>
<ul id="navigation">
<%if (hasFirstPage) { %>
	<li><a class="ui-widget ui-helper-clearfix ui-corner-all navigation" href="${computedUrl}${operator}sp.pageNumber=0"><span class="ui-state-active ui-icon ui-icon-seek-first"><fmt:message key="navigation.first"/></span></a></li>
<% } else { %>
	<li><span class="ui-state-disabled ui-icon ui-icon-seek-first"><fmt:message key="navigation.first"/></span></li>
<% } %>

<%if (hasPreviousPage) { %>
	<li><a class="ui-widget ui-helper-clearfix ui-corner-all navigation" href="${computedUrl}${operator}sp.pageNumber=<%= previousPage %>"><span class="ui-state-active ui-icon ui-icon-seek-prev"><fmt:message key="navigation.previous"/></span></a></li>
<% } else { %>
	<li><span class="ui-state-disabled ui-icon ui-icon-seek-prev"><fmt:message key="navigation.previous"/></span></li>
<% } %>

<%if (hasNextPage) { %>
	<li><a class="ui-widget ui-helper-clearfix ui-corner-all navigation" href="${computedUrl}${operator}sp.pageNumber=<%= nextPage %>"><span class="ui-state-active ui-corner-all ui-icon ui-icon-seek-next"><fmt:message key="navigation.next"/></span></a></li>
<% } else { %>
	<li><span class="ui-state-disabled ui-corner-all ui-icon ui-icon-seek-next"><fmt:message key="navigation.next"/></span></li>
<% } %>

<%if (hasLastPage) { %>
	<li><a class="ui-widget ui-helper-clearfix ui-corner-all navigation" href="${computedUrl}${operator}sp.pageNumber=<%= lastPage %>"><span class="ui-state-active ui-corner-all ui-icon ui-icon-seek-end"><fmt:message key="navigation.last"/></span></a></li>
<% } else { %>
	<li><span class="ui-state-disabled ui-corner-all ui-icon ui-state-disabled ui-icon-seek-end"><fmt:message key="navigation.last"/></span></li>
<% } %>
	<li><form action="${computedUrl}" class="search"><input id="navigationPageNumber" name="sp.pageNumber" value="<%= pageNumber %> / <%= totalPages %>" onClick="this.value='';this.select();" size="8" align="center"/></form></li>
</ul>