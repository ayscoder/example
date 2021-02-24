CREATE TABLE IF NOT EXISTS `example`
(
    `id`   int(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `description` varchar(200) DEFAULT NULL,
    `createdOn` varchar(20) DEFAULT NULL,
    `updatedOn` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;
