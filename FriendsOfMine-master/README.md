Plan TP Java EE
===================

Dans l'ensemble des TP, des tests unitaires ou d'intégrations sont donnés aux étudiants : leur travail consiste principalement à écrire le code permettant aux tests de passer.

TP1
-----

Objectif : prise en main Groovy

Introduction à Groovy.
Cible : tous les étudiants arrivent à l'exercice 5.

> **Note:**

> Il y a 8 exercices mais à partir du 6ème rien ne sera vraiment utilisé dans le cadre des TP Grails.

TP2
-----

Objectif : prise en main IDE et Grails

- Prise en main de l'IDE
- Création des classes du domaine
- Scaffold dynamique et statique
- Création d'objets dans le Bootstrap.groovy

TP3
-----

Objectif : gestion des relations et utilisation de services

- Gestion des relations to-one d'activité vers "propriétaire" de l'activité
- Création du service ActiviteService pour la création/modification/suppression d'une activité
- modification du scaffold sur activité pour utilisation du service dans le contrôleur
- Gestion de la Classe Inscription gérant l'affectation des participants à une activité avec relations one-to-many d'inscription vers utilisateur et d'inscription vers activité
- Complétion du service pour assurer la gestion des inscriptions
- Création d'une situation permettant de vérifier qu'une méthode de services s'exécutent bien dans une transaction; comparer à ce qui se passe dans le Bootstrap.groovy

> **Note**

> La relation many-to-many n'est pas abordée car elle est très rarement utilisée concrètement : on a toujours besoin d'une
information complémentaire dans la table de jointure. Pour l'inscription, la date d'inscription par exemple.

TP4
----

Objectif : langages de requêtes et correction du N+1 select

- Complétion du service ActiviteService avec méthodes de requêtes en utilisant : dynamic finders, criteria et HQL
- Création d'une vue et d'un contrôleur permettant la recherche d'inscriptions suivant différents critères (date début date de fin, inscrits ou propriétaires) avec pagination ; pour chaque
inscription, la vue affiche les informations du responsable de l'activité et la liste des inscrits.
- Logging sql pour mise en exergue du problème du N+1 select.
- Correction du N+1 select au niveau mapping et au niveau requête

> **Note**

> Pour la vue et le contrôleur à créer, l'objectif est que les étudiants s'inspirent du scaffold généré pour la classe Activité en utilisant le support de cours ou la doc officielle en complément.
