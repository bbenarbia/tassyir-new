<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Owner Information</h2>

    <table class="table table-striped" style="width:600px;">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${user.firstName} ${user.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Login</th>
            <td><c:out value="${user.login}"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><c:out value="${user.password}"/></td>
        </tr>
        <tr>
            <th>Contact</th>
            <td><c:out value="${user.contact.name}"/></td>
        </tr>
        <tr>
            <th>titreContact</th>
            <td><c:out value="${user.contact.titreContact}"/></td>
        </tr>
        <tr>
            <th>nomSocieteContact</th>
            <td><c:out value="${user.contact.nomSocieteContact}"/></td>
        </tr>
	  <tr>
            <td> 
            	<spring:url value="{userId}/edit.html" var="editUrl">
                    <spring:param name="userId" value="${user.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit User</a></td>
            <td>
            	<spring:url value="{userId}/pets/new.html" var="addUrl">
                    <spring:param name="userId" value="${owner.id}"/>
                </spring:url>
                <a href="${fn:escapeXml(addUrl)}"  class="btn btn-success">Add New Pet</a></td>
        </tr> 
    </table>

    <h2>Roles</h2>
 <%--
    <c:forEach var="role" items="${user.roles}">
        <table class="table" style="width:600px;">
            <tr>
                <td valign="top" style="width: 120px;">
                    <dl class="dl-horizontal">
                        <dt>Name</dt>
                        <dd><c:out value="${role.name}"/></dd>
                        <%-- <dt>Birth Date</dt>
                        <dd><joda:format value="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt>Type</dt>
                        <dd><c:out value="${pet.type.name}"/></dd> 
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th>Visit Date</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <c:forEach var="visit" items="${pet.visits}">
                            <tr>
                                <td><joda:format value="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td> 
                            	<spring:url value="/owners/{ownerId}/pets/{petId}/edit" var="petUrl">
			                        <spring:param name="ownerId" value="${owner.id}"/>
			                        <spring:param name="petId" value="${pet.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(petUrl)}">Edit Pet</a>
			                </td>
                            <td>
			                    <spring:url value="/owners/{ownerId}/pets/{petId}/visits/new" var="visitUrl">
			                        <spring:param name="ownerId" value="${owner.id}"/>
			                        <spring:param name="petId" value="${pet.id}"/>
			                    </spring:url>
			                    <a href="${fn:escapeXml(visitUrl)}">Add Visit</a>
                            </td>
                       	</tr>
                    </table>
                </td>
            </tr>
        </table>
    </c:forEach>  
--%>
    <jsp:include page="../fragments/footer.jsp"/>

</div>

</body>

</html>
