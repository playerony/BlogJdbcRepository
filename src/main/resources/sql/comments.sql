CREATE TABLE `blog`.`comments` ( 
  	`id` INT NOT NULL AUTO_INCREMENT ,
	`content` TEXT CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL , 
    `articleId` INT NOT NULL,
	`userId` INT NOT NULL,
    `likes` INT NOT NULL,
    `dislikes` INT NOT NULL,
    FOREIGN KEY (`articleId`) REFERENCES `articles`(`id`),
    FOREIGN KEY (`userId`) REFERENCES `users`(`id`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;