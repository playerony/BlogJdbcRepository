CREATE TABLE `blog`.`articles` ( 
  	`id` INT NOT NULL AUTO_INCREMENT , 
	`title` TEXT(50) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL , 
	`content` TEXT CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL , 
	`userId` INT NOT NULL,
    FOREIGN KEY (`userId`) REFERENCES `users`(`id`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;