<%@ page import="museetoulouse.Adresse" %>



<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'codePostal', 'error')} required">
	<label for="codePostal">
		<g:message code="adresse.codePostal.label" default="Code Postal" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="codePostal" type="number" value="${adresseInstance.codePostal}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'ville', 'error')} required">
	<label for="ville">
		<g:message code="adresse.ville.label" default="Ville" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ville" pattern="${adresseInstance.constraints.ville.matches}" required="" value="${adresseInstance?.ville}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="adresse.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numero" required="" value="${adresseInstance?.numero}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: adresseInstance, field: 'rue', 'error')} required">
	<label for="rue">
		<g:message code="adresse.rue.label" default="Rue" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rue" required="" value="${adresseInstance?.rue}"/>

</div>

