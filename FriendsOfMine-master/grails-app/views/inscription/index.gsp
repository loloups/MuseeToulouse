
<%@ page import="friendsofmine.Inscription" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'inscription.label', default: 'Inscription')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-inscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-inscription" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="titre">
                            Titre activité contient :
                        </label>
                        <g:textField name="titre"/>
                        <label for="responsable">
                            Le nom ou le prénom du responsable contient :
                        </label>
                        <g:textField name="responsable"/>
                    </div>
                    <div class="fieldcontain">
                        <label for="utilisateur">
                            Le nom ou le prénom de l'inscrit(e) contient :
                        </label>
                        <g:textField name="utilisateur"/>
                    </div>
                    <div style="float: right">
                        <g:actionSubmit action="doSearchInscriptions" value="Rechercher" />
                    </div>
                </fieldset>

            </g:form>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="inscription.activite.label" default="Activite" /></th>
					
						<g:sortableColumn property="dateInscription" title="${message(code: 'inscription.dateInscription.label', default: 'Date Inscription')}" />
					
						<th><g:message code="inscription.utilisateur.label" default="Utilisateur" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${inscriptionInstanceList}" status="i" var="inscriptionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${inscriptionInstance.id}">${fieldValue(bean: inscriptionInstance, field: "activite")}</g:link></td>
					
						<td><g:formatDate date="${inscriptionInstance.dateInscription}" /></td>
					
						<td>${fieldValue(bean: inscriptionInstance, field: "utilisateur")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${inscriptionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
