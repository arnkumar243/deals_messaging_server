CREATE TABLE `deals_admin`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(10) NULL,
  `isvendor` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE);
  
CREATE TABLE `deals_admin`.`shops` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `deals_admin`.`fixed_deals` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `deals_admin`.`deals` (
  `id` INT NOT NULL,
  `shop_id` INT NULL,
  `fixed_deals_id` INT NULL,
  `deal_info` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `shop_id_idx` (`shop_id` ASC) VISIBLE,
  INDEX `fixed_deals_id_idx` (`fixed_deals_id` ASC) VISIBLE,
  CONSTRAINT `shop_id`
    FOREIGN KEY (`shop_id`)
    REFERENCES `deals_admin`.`shops` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fixed_deals_id`
    FOREIGN KEY (`fixed_deals_id`)
    REFERENCES `deals_admin`.`fixed_deals` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `deals_admin`.`subscribers` (
  `user_id` INT NULL,
  `sub_shop_id` INT NULL,
  `sub_fixed_deals_id` INT NULL,
  `id` INT NOT NULL,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `fixed_deals_id_idx` (`sub_fixed_deals_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `sub_shop_id_idx` (`sub_shop_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `deals_admin`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sub_shop_id`
    FOREIGN KEY (`sub_shop_id`)
    REFERENCES `deals_admin`.`shops` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sub_fixed_deals_id`
    FOREIGN KEY (`sub_fixed_deals_id`)
    REFERENCES `deals_admin`.`fixed_deals` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
