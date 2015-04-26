<g:if test="${museesPrefereesCount > 0}">
    <table id="museePrefere">
        <caption>Liste de mes musées préférés</caption>
        <thead>
        <tr>
            %{--<th> Favoris </th>--}%
            <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
            <th style="max-width: 8%;word-wrap: break-word; table-layout: fixed">
                <g:form controller="demandeVisite">
                    <fieldset class="buttons">
                        <g:actionSubmit class="btn-success" action="create" value="Effectuer une demande de visite"/>
                    </fieldset>
                </g:form>
            </th>
            <th><div style="text-align: right" onclick="jQuery('#encart').hide();">X</div> </th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${session.musees}" status="i" var="museePreferee">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${fieldValue(bean: museePreferee, field: "nom")}</td>
                <td>
                    %{--<g:form url="[resource:museePreferee, action:'supprimerMuseePreferee']" method="PUT" >--}%
                        %{--<fieldset class="buttons">--}%
                            %{--<g:actionSubmit class="btn-success" action="supprimerMuseePreferee" value="X" />--}%
                        %{--</fieldset>--}%
                    %{--</g:form>--}%
                    <g:if test="${session.musees.size() > 1 }">
                    <g:formRemote onSuccess="jQuery('#${museePreferee.getId()}').removeAttr('disabled'); jQuery('#${museePreferee.getId()}').prop('value', 'Ajouter à la list des musées')" url="[resource:museePreferee, action:'supprimerMuseePreferee']" method="PUT"  name="myForm2" update="encart">
                        <fieldset class="buttons">
                            <g:actionSubmit class="btn-success" action="supprimerMuseePreferee" value="Supprimer de	ma liste de musées" />
                        </fieldset>
                    </g:formRemote>
                    </g:if>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</g:if>