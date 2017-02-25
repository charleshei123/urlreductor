●	Le fichier README.md de votre repo Github fera office de documentation, il contiendra les instructions d’installation et d’utilisation de votre solution, mais aussi la justification des choix d’architecture. Une page github.io fera aussi l’affaire à condition que vous précisiez sont adresse dans le README. 

/************ URL REDUCTOR ********/

Projet réalisé par : Charles de Franssu et Thomas Roqueplot

Ce projet est un travail réalisé dans le cadre d'un projet de fin de matière JEE à HEI en master 2 ITI
Il a pour but de reproduire le fonctionnement des réducteurs d'url connus sur le web et en vogue en ce moment car utiles pour poster sur des réseaux sociaux limitant le nombre de caractères.

Ce projet a été réalisé en Java EE.
C'est un maven project.

l'interface graphique propose 4 pages :

- index.html => première page qui affiche deux formulaires permettant de réduire un url
- contact.html => page de contact pas encore implémentée mais qui est censée envoyer un mail aux développeurs
- tableau.html => affiche la liste des urls déjà raccoucis et aussi un bouton pour supprimer
- log.html => permet de faire un connexion à des admin (à finir d'implémenter)


Notre Bdd => appellée simplement hei_urlreductor contient deux tables :

- users => liste des utilisateurs connus ayant le droit de se logger
- url => liste des urls (un id, un url long, un url court)

Notre arborescence java suit ce qui a été ensseigné avec trois modules :

- url-assets => contient la partie interface graphique qui est dans les ressources, est appelé par le module url-web
- url-core => contient le Rest machine qui defini les entités necessaires au bon fonctionnement de l'application 
- url-web => rempli l'interface en collaboration avec le url-core

