<g:if test="${museesPrefereesCount > 0}">
    <table id="museePrefere">
        <caption>Liste de mes musées préférés</caption>
        <thead>
        <tr>
            %{--<th> Favoris </th>--}%
            <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${museesPreferees}" status="i" var="museePreferee">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${fieldValue(bean: museePreferee, field: "nom")}</td>
                <td>
                    %{--<g:form url="[resource:museePreferee, action:'supprimerMuseePreferee']" method="PUT" >--}%
                        %{--<fieldset class="buttons">--}%
                            %{--<g:actionSubmit class="btn-success" action="supprimerMuseePreferee" value="X" />--}%
                        %{--</fieldset>--}%
                    %{--</g:form>--}%
                    <g:formRemote onSuccess="jQuery('#${museePreferee.getId()}').removeAttr('disabled'); jQuery('#${museePreferee.getId()}').prop('value', 'Ajouter à la list des musées')" url="[resource:museePreferee, action:'supprimerMuseePreferee']" method="PUT"  name="myForm2" update="encart">
                        <fieldset class="buttons">
                            <g:actionSubmit class="btn-success" action="supprimerMuseePreferee" value="X" />
                        </fieldset>
                    </g:formRemote>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</g:if>