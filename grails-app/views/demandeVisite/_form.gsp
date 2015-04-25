<%@ page import="museetoulouse.DemandeVisite" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateDebutPeriode', 'error')} required">
    <label for="dateDebutPeriode">
        <g:message code="demandeVisite.dateDebutPeriode.label" default="Date Debut Periode"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dateDebutPeriode" precision="day" value="${demandeVisiteInstance?.dateDebutPeriode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateFinPeriode', 'error')} required">
    <label for="dateFinPeriode">
        <g:message code="demandeVisite.dateFinPeriode.label" default="Date Fin Periode"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dateFinPeriode" precision="day" value="${demandeVisiteInstance?.dateFinPeriode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonnes', 'error')} required">
    <label for="nbPersonnes">
        <g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="nbPersonnes" type="number" value="${demandeVisiteInstance.nbPersonnes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'musees', 'error')} ">
    <label for="musees">
        <g:message code="demandeVisite.musees.label" default="Musees"/>
        <span class="required-indicator">*</span>
    </label>
    <ul>
        <g:each in="${session.musees}" var="musee">
            <li><g:checkBox name="museesPreferees" value="${musee.id}" checked="false"/>
            <label for="museesPreferees">${musee.nom}</label></li>
        </g:each>
    </ul>
</div>

