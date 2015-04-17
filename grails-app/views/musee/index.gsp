
<%@ page import="museetoulouse.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<div style="float:left;">
				<g:form>
					<fieldset class="form">
						<div class="fieldcontain">
							<label for="nom">
								Nom du musée contient :
							</label>
							<g:textField name="nom"/>
						</div>
						<div class="fieldcontain">
							<label for="codepostal">
								Le code postal :
							</label>
							<g:select name="codepostal" from="${museetoulouse.Adresse.list().codePostal.unique()}" noSelection="['':'-Choose your Code Postal-']"/>
						</div>
						<div class="fieldcontain">
							<label for="rue">
								La rue contient :
							</label>
							<g:textField name="rue"/>
						</div>
						<div style="float: right">
							<g:actionSubmit action="doSearchMusees" value="Rechercher" />
						</div>
					</fieldset>

				</g:form>
			</div>
			<div style="float: right;">
				<g:if test="${museesPrefereesCount > 0}"><table>
					<caption>Liste de mes musées préférés</caption>
					<thead>
					<tr>
						<g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
						<th></th>
					</tr>
					</thead>
					<tbody>
					<g:each in="${museesPreferees}" status="i" var="museePreferee">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td>${fieldValue(bean: museePreferee, field: "nom")}</td>
							<td></td>
						</tr>
					</g:each>
					</tbody>
				</table></g:if>
			</div>
			<div>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />

						<g:sortableColumn property="telephone" title="${message(code: 'musee.telephone.label', default: 'Telephone')}" />

						<th><g:message code="musee.adresse.label" default="Adresse" /></th>
					
						<g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />
					
						<g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />
					
						<g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />
					
						<th><g:message code="musee.responsable.label" default="Responsable" /></th>

						<th></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${museeInstanceList}" status="i" var="museeInstance">
					
						<td>${fieldValue(bean: museeInstance, field: "nom")}</td>

						<td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

						<td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

						<td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

						<td>${fieldValue(bean: museeInstance, field: "responsable")}</td>

						<td><g:if test="${museeInstance.prefere == false}">
							<g:form url="[resource:museeInstance, action:'ajouterMuseePreferee']" method="PUT" >
								<fieldset class="buttons">
									<g:actionSubmit class="btn-success" action="ajouterMuseePreferee" value="Ajouter à la liste des musées" />
								</fieldset>
							</g:form>
						</g:if></td>
					
					</tr>
				</g:each>
				</tbody>
				<tfoot>
					<div class="pagination">
						<g:paginate max="5" total="${museeInstanceCount ?: 0}" name=""/>
					</div>
				</tfoot>
			</table>
			</div>
		</div>
	</body>
</html>
