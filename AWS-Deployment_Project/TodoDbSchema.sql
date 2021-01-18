-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema todo_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema todo_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `todo_database` DEFAULT CHARACTER SET utf8 ;
USE `todo_database` ;

-- -----------------------------------------------------
-- Table `todo_database`.`todo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `todo_database`.`todo` (
  `num` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '',
  `title` VARCHAR(45) NOT NULL COMMENT '',
  `text` VARCHAR(200) NOT NULL COMMENT '',
  `completed` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`num`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `todo_database`.`todo`
(`title`,`text`,`completed`)
VALUES
("First TODO", "My First TODO", FALSE);