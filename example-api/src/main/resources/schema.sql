drop table if exists example;

CREATE TABLE IF NOT EXISTS `example`
(
    `id`   bigint(100) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `description` varchar(200) DEFAULT NULL,
    `createdTime` varchar(50) NOT NULL ,
    `lastModifiedTime` varchar(50) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS sys_message (
                                           id bigint(20) NOT NULL AUTO_INCREMENT,
                                           message varchar(100) NOT NULL,
                                           PRIMARY KEY (id)
);