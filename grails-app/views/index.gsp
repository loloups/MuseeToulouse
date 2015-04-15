<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Musée Toulouse</title>
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
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="page-body" role="main">
			<h1>Bienvenue sur Musée Toulouse</h1>
			<div id="controller-list" role="navigation">

				<h2>Recherche de musee:</h2>
				<form method="post" action="gestionnaire">
					<input type="submit" value="Gest" />
				</form>
				<form method="post" action="adresse">
					<input type="submit" value="Add" />
				</form>
				<g:form action = "search" controller="musee">
					Nom : <g:field type="search" placeholder="Entrez un nom de musée" name="nom" value="${nom}"/>
					Code Postal : <g:select name="codepostal" from="${museetoulouse.Adresse.list().codePostal}" value="${codepostal}" noSelection="['':'-Choose your Code Postal-']"/>
					Rue: <g:field type="search" placeholder="Entrez un nom de musée" name="rue" value="${rue}"/>
					<input type="submit" value="Valider">
				</g:form>
			</div>
		</div>
	</body>
</html>
