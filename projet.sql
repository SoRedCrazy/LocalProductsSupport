-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 05 jan. 2022 à 13:32
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `mail` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Prenom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mots_de_passes` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`mail`, `Nom`, `Prenom`, `mots_de_passes`) VALUES
('fb280601@gmail.com', 'Bardel', 'François', 'Mdp1!'),
('gangneux.alex@gmail.com', 'Gangneux', 'Alexis', 'qwerty'),
('julien.boisgard37@gmail.com', 'boisgard', 'julien', 'azerty37');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero_de_rue` int(11) NOT NULL,
  `rue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `code_postal` int(11) NOT NULL,
  `ville` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pays` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero_de_telephone` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idclient`, `prenom`, `nom`, `numero_de_rue`, `rue`, `code_postal`, `ville`, `pays`, `numero_de_telephone`, `mail`) VALUES
(47, 'Alexis', 'Gangneux', 3, 'rue des bas', 32600, 'tours', 'france', '0278443696', 'julien.boisgard37@gmail.com'),
(48, 'francis', 'bardou', 12, 'Rue de la rue', 37000, 'tours', 'france', '0489637852', 'julien.boisgard37@gmail.com'),
(49, 'Marion', 'Broudin', 20, 'Rue de la bise', 37100, 'tours', 'france', '0301057896', 'julien.boisgard37@gmail.com'),
(50, 'amaury', 'Mechin', 63, 'Rue de la neige', 37100, 'tours', 'france', '0456898781', 'julien.boisgard37@gmail.com'),
(51, 'Adibou', 'Boubou', 2, 'Rue de la bou', 37100, 'tours', 'france', '0123568974', 'julien.boisgard37@gmail.com'),
(52, 'Jabba', 'The Hut', 1, 'Rue du desert', 37200, 'tours', 'Tatooine', '0785964152', 'julien.boisgard37@gmail.com'),
(53, 'nuggets', 'chicken', 20, 'Rue du poulet', 37000, 'tours', 'france', '0163548524', 'gangneux.alex@gmail.com'),
(54, 'Giorno', 'Giovanna', 20, 'Rue de la golden', 80100, 'naples', 'Italie', '0950708090', 'gangneux.alex@gmail.com'),
(55, 'toile', 'arakne', 30, 'Rue de la foret', 37100, 'tours', 'france', '0905475896', 'gangneux.alex@gmail.com'),
(56, 'Jonathan', 'Joestar', 25, 'Rue de wal', 37100, 'tours', 'france', '0185967423', 'gangneux.alex@gmail.com'),
(57, 'Bruce ', 'Wayne', 1, 'Avenue sombre', 37100, 'tours ', 'france', '0274859658', 'gangneux.alex@gmail.com'),
(58, 'carré ', 'racine', 56, 'Rue de la terre', 37100, 'tours', 'france', '0526378415', 'gangneux.alex@gmail.com'),
(59, 'jolyne', 'Kujo', 85, 'Rue de la paix', 37600, 'tours', 'france', '0540698720', 'gangneux.alex@gmail.com'),
(60, 'bob', 'whale', 45, 'Rue de la vague', 37000, 'tours', 'france', '0354698523', 'gangneux.alex@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idcommande` int(11) NOT NULL,
  `libelle` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `poids` int(11) NOT NULL,
  `Heure_de_debut` time NOT NULL,
  `Heure_de_fin` time NOT NULL,
  `SIRET` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idclient` int(11) NOT NULL,
  `idtournee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idcommande`, `libelle`, `poids`, `Heure_de_debut`, `Heure_de_fin`, `SIRET`, `idclient`, `idtournee`) VALUES
(5, 'Cannabis', 50, '00:20:00', '00:25:00', '280601', 52, 2),
(6, 'Poulet', 50, '00:40:00', '00:45:00', '280601', 47, 2),
(7, 'Poulet', 100, '01:00:00', '01:00:00', '280601', 53, 2),
(8, 'Blé', 100, '01:20:00', '01:20:00', '280601', 49, 2),
(9, 'boue', 50, '01:40:00', '01:45:00', '280601', 51, 2),
(10, 'Argent', 60, '01:50:00', '02:00:00', '280601', 57, 2),
(11, 'Vin', 90, '02:00:00', '02:20:00', '280601', 54, 2),
(12, 'Oeufs', 100, '14:00:00', '14:05:00', '280601', 56, 3),
(13, 'Café', 50, '14:20:00', '14:25:00', '280601', 48, 3),
(14, 'Pain', 50, '14:40:00', '14:45:00', '280601', 59, 3),
(15, 'Poisson', 100, '15:00:00', '15:05:00', '280601', 60, 3),
(16, 'Pates', 100, '15:20:00', '15:25:00', '280601', 55, 3),
(17, 'Lentille', 90, '15:40:00', '15:45:00', '280601', 47, 3),
(19, 'Farine', 10, '18:00:00', '18:20:00', '000001', 59, 4),
(20, 'Céréales', 50, '19:00:00', '20:00:00', '000001', 48, 4),
(21, 'Neige', 100, '15:00:00', '15:45:00', '000001', 50, 4),
(22, 'Alcool', 150, '23:00:00', '00:00:00', '000001', 52, 4),
(23, 'poireau ', 100, '21:00:00', '23:00:00', '000001', 51, 4),
(24, 'lait', 20, '15:00:00', '15:30:00', '000001', 60, 5),
(25, 'boeuf', 25, '18:00:00', '18:15:00', '000001', 55, 5),
(26, 'ciment', 100, '19:00:00', '19:45:00', '000001', 58, 5),
(27, 'Oeufs', 6, '14:30:00', '14:50:00', '000001', 47, 5),
(28, 'Cacao', 54, '16:00:00', '20:00:00', '000001', 54, 5),
(29, 'épices', 25, '15:45:00', '16:00:00', '000001', 49, 5),
(30, 'Sel', 50, '16:00:00', '16:05:00', '000002', 49, 7),
(31, 'Poivre', 50, '16:20:00', '16:25:00', '000002', 50, 7),
(32, 'Paprika', 50, '16:40:00', '16:45:00', '000002', 53, 7),
(33, 'Sel', 50, '17:00:00', '17:05:00', '000002', 59, 7),
(34, 'Poivre', 100, '17:20:00', '17:25:00', '000002', 60, 7),
(35, 'Paprika', 100, '17:40:00', '17:45:00', '000002', 55, 7),
(36, 'Paprika', 75, '13:00:00', '13:05:00', '000002', 57, 8),
(37, 'Sel', 50, '13:20:00', '13:25:00', '000002', 59, 8),
(38, 'Poivre', 25, '13:40:00', '13:45:00', '000002', 50, 8),
(39, 'Sel', 150, '14:00:00', '14:05:00', '000002', 54, 8),
(40, 'Sel', 75, '14:20:00', '14:25:00', '000002', 58, 8),
(41, 'Poivre', 100, '14:40:00', '14:45:00', '000002', 50, 8),
(42, 'Poivron', 50, '14:00:00', '14:05:00', '000003', 53, 9),
(43, 'Courgette', 100, '14:20:00', '14:25:00', '000003', 55, 9),
(44, 'Poivron', 150, '14:40:00', '14:45:00', '000003', 56, 9),
(45, 'Poivron', 75, '15:00:00', '15:05:00', '000003', 58, 9),
(46, 'Courgette', 75, '15:20:00', '15:25:00', '000003', 60, 9),
(47, 'Courgette', 75, '15:40:00', '15:45:00', '000003', 52, 9),
(48, 'Poivron', 75, '15:55:00', '16:00:00', '000003', 54, 9),
(49, 'Courgette', 50, '10:00:00', '10:05:00', '000003', 48, 10),
(50, 'Aubergine', 75, '10:20:00', '10:25:00', '000003', 52, 10),
(51, 'Poivron', 75, '10:40:00', '10:45:00', '000003', 50, 10),
(52, 'Aubergine', 150, '11:00:00', '11:05:00', '000003', 49, 10),
(53, 'Aubergine', 100, '11:20:00', '11:25:00', '000003', 54, 10),
(54, 'Aubergine', 25, '11:40:00', '11:45:00', '000003', 57, 10),
(55, 'Poivron', 25, '11:55:00', '12:00:00', '000003', 60, 10),
(56, 'Farine', 150, '15:55:00', '16:00:00', '280601', 57, 3);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `SIRET` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Numero_de_rue` int(11) NOT NULL,
  `rue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `code_postal` int(11) NOT NULL,
  `ville` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pays` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NOM` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Numero_de_telephone` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mots_de_passes` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`SIRET`, `Numero_de_rue`, `rue`, `code_postal`, `ville`, `pays`, `NOM`, `prenom`, `Numero_de_telephone`, `mots_de_passes`, `mail`) VALUES
('000001', 53, 'rue du sergent bobillot', 37000, 'Tours', 'France', 'Gang', 'Alex', '0701010101', 'motdepasse1', 'julien.boisgard37@gmail.com'),
('000002', 66, 'rue Ratatouille', 37000, 'Tours', 'France', 'Costa', 'Luna', '0602020202', 'motdepasse2', 'julien.boisgard37@gmail.com'),
('000003', 3, 'rue george sand', 37000, 'Tours', 'France', 'sand', 'George', '0611111111', 'motdepasse3', 'julien.boisgard37@gmail.com'),
('000004', 63, 'rue dela paie', 75000, 'Paris', 'Tours', 'McQueen', 'Flash', '0600000095', 'sallyjlademarre', 'julien.boisgard37@gmail.com'),
('000005', 33, 'rue HotWeels', 37000, 'Tours', 'France', 'Joestar', 'Joseph', '0633333333', 'motdepasse5', 'fb280601@gmail.com'),
('000006', 99, 'rue de Tours', 37000, 'Tours', 'France', 'Tours', 'Tours', '0700000000', 'toursrpz', 'fb280601@gmail.com'),
('000007', 63, 'rue du monde', 37000, 'Tours', 'France', 'Brando', 'Dio', '0247000000', 'MudaMuda', 'fb280601@gmail.com'),
('000008', 8, 'rue de la Gare', 37000, 'Tours', 'France', 'Higashigata', 'Josuke', '0620000000', 'softandwet', 'fb280601@gmail.com'),
('000009', 52, 'des peupliers', 37000, 'Tours', 'France', 'Allen', 'Bartholemew', '0744444444', 'jesuisrapide', 'fb280601@gmail.com'),
('280601', 8, 'rue Louis Braille', 37000, 'Tours', 'France', 'Bardel', 'François', '0600000000', 'motdepasse', 'julien.boisgard37@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `tournee`
--

CREATE TABLE `tournee` (
  `idtournee` int(11) NOT NULL,
  `Horaire_de_debut` time NOT NULL,
  `Horaire_de_fin` time NOT NULL,
  `Date` date NOT NULL,
  `poid` int(11) NOT NULL,
  `Imaticulation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `tournee`
--

INSERT INTO `tournee` (`idtournee`, `Horaire_de_debut`, `Horaire_de_fin`, `Date`, `poid`, `Imaticulation`) VALUES
(2, '00:00:00', '02:20:00', '2022-01-20', 500, 'R2-D2-37-FR'),
(3, '14:00:00', '16:00:00', '2022-03-02', 640, 'MU-DA-21-FR'),
(4, '14:00:00', '00:00:00', '2022-01-25', 410, 'BD-SM-37-FR'),
(5, '06:00:00', '20:00:00', '2022-01-18', 230, 'C3-PO-37-FR'),
(6, '15:00:00', '17:00:00', '2022-01-02', 0, 'MU-DA-21-FR'),
(7, '16:00:00', '18:00:00', '2022-04-06', 400, 'LU-CY-23-FR'),
(8, '13:00:00', '15:00:00', '2022-06-07', 475, 'AC-DC-66-FR'),
(9, '14:00:00', '16:00:00', '2022-03-08', 600, 'CA-M1-0N-FR'),
(10, '10:00:00', '12:00:00', '2022-03-15', 500, 'SA-ND-00-FR');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `Imaticulation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Poids_maximal` int(11) NOT NULL COMMENT 'Po',
  `SIRET` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`Imaticulation`, `Poids_maximal`, `SIRET`) VALUES
('AC-DC-66-FR', 750, '000002'),
('BD-SM-37-FR', 500, '000001'),
('C3-PO-37-FR', 350, '000001'),
('CA-M1-0N-FR', 750, '000003'),
('LU-CY-23-FR', 750, '000002'),
('MU-DA-21-FR', 750, '280601'),
('R2-D2-37-FR', 500, '280601'),
('SA-ND-00-FR', 500, '000003');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`mail`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idclient`),
  ADD KEY `Client_Admin_FK` (`mail`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idcommande`),
  ADD KEY `Commande_Entreprise_FK` (`SIRET`),
  ADD KEY `Commande_Client0_FK` (`idclient`),
  ADD KEY `Commande_Tournee1_FK` (`idtournee`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`SIRET`),
  ADD UNIQUE KEY `Numero_de_telephone` (`Numero_de_telephone`),
  ADD KEY `Entreprise_Admin_FK` (`mail`);

--
-- Index pour la table `tournee`
--
ALTER TABLE `tournee`
  ADD PRIMARY KEY (`idtournee`),
  ADD KEY `Tournee_Vehicule_FK` (`Imaticulation`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`Imaticulation`),
  ADD KEY `Vehicule_Entreprise_FK` (`SIRET`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idcommande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT pour la table `tournee`
--
ALTER TABLE `tournee`
  MODIFY `idtournee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `Client_Admin_FK` FOREIGN KEY (`mail`) REFERENCES `admin` (`mail`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `Commande_Client0_FK` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`),
  ADD CONSTRAINT `Commande_Entreprise_FK` FOREIGN KEY (`SIRET`) REFERENCES `entreprise` (`SIRET`),
  ADD CONSTRAINT `Commande_Tournee1_FK` FOREIGN KEY (`idtournee`) REFERENCES `tournee` (`idtournee`);

--
-- Contraintes pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `Entreprise_Admin_FK` FOREIGN KEY (`mail`) REFERENCES `admin` (`mail`);

--
-- Contraintes pour la table `tournee`
--
ALTER TABLE `tournee`
  ADD CONSTRAINT `Tournee_Vehicule_FK` FOREIGN KEY (`Imaticulation`) REFERENCES `vehicule` (`Imaticulation`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `Vehicule_Entreprise_FK` FOREIGN KEY (`SIRET`) REFERENCES `entreprise` (`SIRET`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
