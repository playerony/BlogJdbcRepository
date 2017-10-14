CREATE TABLE `blog`.`users` ( 
  	`id` INT NOT NULL AUTO_INCREMENT , 
	`login` TEXT(20) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL , 
	`password` TEXT(80) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL , 
	`roleId` INT NOT NULL,
    FOREIGN KEY (`roleId`) REFERENCES `roles`(`id`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;