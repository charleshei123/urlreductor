/************ URL REDUCTOR ********/

Projet réalisé par : Charles de Franssu et Thomas Roqueplot

Ce projet est un travail réalisé dans le cadre d'un projet de fin de matière JEE à HEI en master 2 ITI
Il a pour but de reproduire le fonctionnement des réducteurs d'url connus sur le web et en vogue en ce moment car utiles pour poster sur des réseaux sociaux limitant le nombre de caractères.

Ce projet a été réalisé en Java EE.
C'est un maven project.

=>l'interface graphique propose 3 pages :

- index.vm => première page qui affiche deux formulaires permettant de réduire un url
- contact.vm => page de contact (pas encore implémentée mais qui est censée envoyer un mail aux développeurs)
- tableau.vm => affiche la liste des urls déjà raccoucis et aussi un bouton pour supprimer


=>Notre Bdd => appellée simplement hei_urlreductor contient deux tables :
(Dans ressources à la racine du projet, vous trouverez notre BDD au format Sql)
il faut préalablement creer dans son projet une base de donnée vierge et specifier son nom et ses propriétés de connexion dans le "db.properties"
(dans le module url-core)

- baseUrl => stocke le nom de domaine du site
- url => liste des urls (un id, un url long, un url court)

=>Notre arborescence java suit ce qui a été ensseigné avec 2 modules :

- url-core => 
	contient l'API de l'application permettant de réduire les liens urls, il établi aussi le lien avec la BDD
- url-web => contient la version web de l'application au format vélocity, en collaboration avec le "url-core" il affiche à l'utilisateurs les pages souhaitées.S

