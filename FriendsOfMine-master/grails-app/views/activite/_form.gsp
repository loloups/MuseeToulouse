<%@ page import="friendsofmine.Activite" %>



<div class="fieldcontain ${hasErrors(bean: activiteInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="activite.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${activiteInstance?.titre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: activiteInstance, field: 'descriptif', 'error')} ">
	<label for="descriptif">
		<g:message code="activite.descriptif.label" default="Descriptif" />
		
	</label>
	<g:textField name="descriptif" value="${activiteInstance?.descriptif}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: activiteInstance, field: 'responsable', 'error')} required">
	<label for="responsable">
		<g:message code="activite.responsable.label" default="Responsable" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="responsable" name="responsable.id" from="${friendsofmine.Utilisateur.list()}" optionKey="id" required="" value="${activiteInstance?.responsable?.id}" class="many-to-one"/>

</div>

