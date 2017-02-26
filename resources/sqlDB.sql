-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 26 Février 2017 à 13:19
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hei_urlreductor`
--

-- --------------------------------------------------------

--
-- Structure de la table `baseurl`
--

CREATE TABLE `baseurl` (
  `id` int(11) NOT NULL,
  `baseUrl` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `baseurl`
--

INSERT INTO `baseurl` (`id`, `baseUrl`) VALUES
(1, 'http://localhost:8082/');

-- --------------------------------------------------------

--
-- Structure de la table `url`
--

CREATE TABLE `url` (
  `id` int(11) NOT NULL,
  `urlCourt` text NOT NULL,
  `urlLong` text NOT NULL,
  `nomUrl` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `url`
--

INSERT INTO `url` (`id`, `urlCourt`, `urlLong`, `nomUrl`) VALUES
(1, 'a', 'https://github.com/ThomasRoqueplo/jee-hei-2017-pw06', 'git'),
(2, 'b', 'https://www.google.fr/', 'google');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `baseurl`
--
ALTER TABLE `baseurl`
  ADD KEY `id` (`id`);

--
-- Index pour la table `url`
--
ALTER TABLE `url`
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `baseurl`
--
ALTER TABLE `baseurl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `url`
--
ALTER TABLE `url`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
