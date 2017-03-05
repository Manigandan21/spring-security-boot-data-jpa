CREATE DATABASE `p2p_dev` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `current_energy_supplier` varchar(45) DEFAULT NULL,
  `current_supplier` varchar(45) DEFAULT NULL,
  `annual_bill` int(10) DEFAULT NULL,
  `annual_consumption` int(10) DEFAULT NULL,
  `smart_meter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `prosumer` (
  `id` int(11) NOT NULL,
  `project_name` varchar(45) DEFAULT NULL,
  `current_supplier` varchar(45) DEFAULT NULL,
  `postcode` bigint(8) DEFAULT NULL,
  `installed_capacity_kw` float DEFAULT NULL,
  `smart_meter_id` int(11) NOT NULL,
  `tech_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_basic_info` (
  `user_id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `CONSUMER_ID` int(3) DEFAULT NULL,
  `PROSUMER_ID` int(3) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK5q7ul3okjionfgr04i4of2hqf` (`CONSUMER_ID`),
  KEY `FKrjg610w19sn205q396cn0wcv3` (`PROSUMER_ID`),
  CONSTRAINT `FK5q7ul3okjionfgr04i4of2hqf` FOREIGN KEY (`CONSUMER_ID`) REFERENCES `consumer` (`id`),
  CONSTRAINT `FKrjg610w19sn205q396cn0wcv3` FOREIGN KEY (`PROSUMER_ID`) REFERENCES `prosumer` (`id`),
  CONSTRAINT `user_basic_info_ibfk_1` FOREIGN KEY (`CONSUMER_ID`) REFERENCES `consumer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_basic_info_ibfk_2` FOREIGN KEY (`PROSUMER_ID`) REFERENCES `prosumer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
