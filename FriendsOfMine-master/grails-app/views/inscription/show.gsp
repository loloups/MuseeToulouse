
<%@ page import="friendsofmine.Inscription" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'inscription.label', default: 'Inscription')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-inscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-inscription" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list inscription">
			
				<g:if test="${inscriptionInstance?.activite}">
				<li class="fieldcontain">
					<span id="activite-label" class="property-label"><g:message code="inscription.activite.label" default="Activite" /></span>
					
						<span class="property-value" aria-labelledby="activite-label"><g:link controller="activite" action="show" id="${inscriptionInstance?.activite?.id}">${inscriptionInstance?.activite?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.dateInscription}">
				<li class="fieldcontain">
					<span id="dateInscription-label" class="property-label"><g:message code="inscription.dateInscription.label" default="Date Inscription" /></span>
					
						<span class="property-value" aria-labelledby="dateInscription-label"><g:formatDate date="${inscriptionInstance?.dateInscription}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.utilisateur}">
				<li class="fieldcontain">
					<span id="utilisateur-label" class="property-label"><g:message code="inscription.utilisateur.label" default="Utilisateur" /></span>
					
						<span class="property-value" aria-labelledby="utilisateur-label"><g:link controller="utilisateur" action="show" id="${inscriptionInstance?.utilisateur?.id}">${inscriptionInstance?.utilisateur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:inscriptionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${inscriptionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
