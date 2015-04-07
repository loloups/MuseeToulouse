<%@ page import="friendsofmine.Inscription" %>



<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'activite', 'error')} required">
	<label for="activite">
		<g:message code="inscription.activite.label" default="Activite" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="activite" name="activite.id" from="${friendsofmine.Activite.list()}" optionKey="id" required="" value="${inscriptionInstance?.activite?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'dateInscription', 'error')} required">
	<label for="dateInscription">
		<g:message code="inscription.dateInscription.label" default="Date Inscription" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateInscription" precision="day"  value="${inscriptionInstance?.dateInscription}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'utilisateur', 'error')} required">
	<label for="utilisateur">
		<g:message code="inscription.utilisateur.label" default="Utilisateur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="utilisateur" name="utilisateur.id" from="${friendsofmine.Utilisateur.list()}" optionKey="id" required="" value="${inscriptionInstance?.utilisateur?.id}" class="many-to-one"/>

</div>

