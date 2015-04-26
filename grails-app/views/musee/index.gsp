
<%@ page import="museetoulouse.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<style type="text/css" media="screen">
		#status {
			background-color: #eee;
			border: .2em solid #fff;
			margin: 2em 2em 1em;
			padding: 1em;
			width: 12em;
			float: left;
			-moz-box-shadow: 0px 0px 1.25em #ccc;
			-webkit-box-shadow: 0px 0px 1.25em #ccc;
			box-shadow: 0px 0px 1.25em #ccc;
			-moz-border-radius: 0.6em;
			-webkit-border-radius: 0.6em;
			border-radius: 0.6em;
		}

		.ie6 #status {
			display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
		}

		#status ul {
			font-size: 0.9em;
			list-style-type: none;
			margin-bottom: 0.6em;
			padding: 0;
		}

		#status li {
			line-height: 1.3;
		}

		#status h1 {
			text-transform: uppercase;
			font-size: 1.1em;
			margin: 0 0 0.3em;
		}

		#page-body {
			margin: 2em 1em 1.25em 18em;
		}

		h2 {
			margin-top: 1em;
			margin-bottom: 0.3em;
			font-size: 1em;
		}

		p {
			line-height: 1.5;
			margin: 0.25em 0;
		}

		#controller-list ul {
			list-style-position: inside;
		}

		#controller-list li {
			line-height: 1.3;
			list-style-position: inside;
			margin: 0.25em 0;
		}

		@media screen and (max-width: 480px) {
			#status {
				display: none;
			}

			#page-body {
				margin: 0 1em 1em;
			}

			#page-body h1 {
				margin-top: 0;
			}
		}
		</style>
		<g:javascript library="jquery" />
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

			<div>
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
			<div id="encart" style="float: right; max-width: 15%; max-height: 60%; overflow:auto; position: fixed; right: 2%; top: 30%; font-size: 80%;">
				<g:render id="" template="/aa1" collection="${print}"/>

			</div>
			<div style="max-width: 100%; overflow:auto;">
			<table id="temp" style="width: 100%; table-layout: fixed; font-size: 70%">
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

						<td>
							<g:if test="${museeInstanceCount > 2}">
								<g:formRemote onSuccess="jQuery('#${museeInstance.getId()}').attr('disabled', 'true'); jQuery('#${museeInstance.getId()}').prop('value', 'Déjà en favoris'); jQuery('#encart').show();" url="[resource:museeInstance, action:'ajouterMuseePreferee']" method="PUT"  name="myForm" update="encart">
									<fieldset class="buttons">
										<g:actionSubmit id="${museeInstance.getId()}" class="btn-success" action="ajouterMuseePreferee" value="${session.musees.any{it.id == museeInstance.id}? "Déjà en favoris" : "Ajouter à la liste des musées"}" disabled="${session.musees.contains(museeInstance)? "true" : "false"}"></g:actionSubmit>
									</fieldset>
								</g:formRemote>
							</g:if>
						</td>
					
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
