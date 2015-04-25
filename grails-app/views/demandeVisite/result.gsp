<%--
  Created by IntelliJ IDEA.
  User: loicleger
  Date: 25/04/15
  Time: 16:01
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

    <body>

    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
        <h2>${message}</h2>
    </div>
    </body>
</html>