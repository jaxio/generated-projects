<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" 
%><%@ attribute name="model" type="java.lang.String" required="true"
%><%@ attribute name="attribute" type="java.lang.String" required="true"
%><%@ attribute name="url" type="java.lang.String"
%>
<c:url var="url" value="${url}">
	<c:forEach items="${param}" var="par">
		<c:choose>
			<c:when test="${par.key == 'decorator'}"/>
			<c:when test="${par.key == 'sp.sortOrder'}">
				<c:param name="${par.key}" value="${par.value == 'ascending' ? 'descending' : 'ascending'}"/>
			</c:when>
			<c:when test="${par.key == 'sp.sortColumnKey'}">
				<c:param name="${par.key}" value="${attribute}"/>
			</c:when>
			<c:otherwise>
				<c:param name="${par.key}" value="${par.value}"/>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${param['sp.sortColumnKey'] == null}">
		<c:param name="sp.sortColumnKey" value="${attribute}"/>
	</c:if>
	<c:if test="${param['sp.sortOrder'] == null}">
		<c:param name="sp.sortOrder" value="ascending"/>
	</c:if>
</c:url>
<a class="navigation" href="${url}"><fmt:message key="${model}_${attribute}"/><c:if test="${param['sp.sortColumnKey'] == attribute}"><span class="ui-icon ui-icon-arrow-1-${param['sp.sortOrder'] == 'ascending' ? 'n' : 's'}" style="float:right""></span></c:if></a>
