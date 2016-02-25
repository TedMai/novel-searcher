-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `novelinfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novelinfo` ;

CREATE TABLE IF NOT EXISTS `novelinfo` (
  `id` VARCHAR(32) NOT NULL COMMENT '',
  `url` VARCHAR(100) NOT NULL COMMENT '',
  `name` VARCHAR(50) NOT NULL COMMENT '',
  `author` VARCHAR(30) NOT NULL COMMENT '',
  `description` TEXT NULL COMMENT '',
  `type` VARCHAR(20) NOT NULL COMMENT '',
  `lastchapter` VARCHAR(100) NULL COMMENT '',
  `chaptercount` INT NULL COMMENT '',
  `chapterlisturl` VARCHAR(100) NOT NULL COMMENT '',
  `wordcount` INT NULL COMMENT '',
  `keywords` VARCHAR(100) NULL COMMENT '',
  `createtime` BIGINT NULL COMMENT '',
  `updatetime` BIGINT NULL COMMENT '',
  `state` CHAR(1) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '小说概要信息表';


-- -----------------------------------------------------
-- Table `novelchapterdetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novelchapterdetail` ;

CREATE TABLE IF NOT EXISTS `novelchapterdetail` (
  `id` VARCHAR(32) NOT NULL COMMENT '',
  `url` VARCHAR(100) NOT NULL COMMENT '',
  `title` VARCHAR(50) NOT NULL COMMENT '',
  `wordcount` INT NULL COMMENT '',
  `chapterid` INT NULL COMMENT '',
  `content` TEXT NULL COMMENT '',
  `createtime` BIGINT NULL COMMENT '',
  `updatetime` BIGINT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '小说章节详情';


-- -----------------------------------------------------
-- Table `novelchapter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novelchapter` ;

CREATE TABLE IF NOT EXISTS `novelchapter` (
  `id` VARCHAR(32) NOT NULL COMMENT '',
  `url` VARCHAR(100) NOT NULL COMMENT '',
  `title` VARCHAR(50) NULL COMMENT '',
  `wordcount` INT NULL COMMENT '',
  `chapterid` INT NULL COMMENT '',
  `createtime` BIGINT NULL COMMENT '',
  `state` CHAR(1) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '小说章节列表';


-- -----------------------------------------------------
-- Table `crawllist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crawllist` ;

CREATE TABLE IF NOT EXISTS `crawllist` (
  `id` BIGINT NOT NULL COMMENT '',
  `url` VARCHAR(100) NULL COMMENT '',
  `state` CHAR(1) NULL COMMENT '',
  `info` VARCHAR(100) NULL COMMENT '',
  `frequency` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '采集入口表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
