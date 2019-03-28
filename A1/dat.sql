-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
SET SQL_SAFE_UPDATES = 0;

-- -----------------------------------------------------
-- Table `mydb`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teacher` (
  `idTeacher` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `cnp` VARCHAR(13) NULL,
  PRIMARY KEY (`idTeacher`),
  UNIQUE INDEX `idTeacher_UNIQUE` (`idTeacher` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course` (
  `idCourse` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `startHour` VARCHAR(5) NULL,
  `endHour` VARCHAR(5) NULL,
  `location` INT NULL,
  `Teacher_idTeacher` INT NOT NULL,
  PRIMARY KEY (`idCourse`),
  UNIQUE INDEX `idCourse_UNIQUE` (`idCourse` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student` (
  `idStudent` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `groop` INT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `cnp` VARCHAR(13) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idStudent`),
  UNIQUE INDEX `idStudent_UNIQUE` (`idStudent` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Enrollment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Enrollment` (
  `idEnrollment` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `grade` FLOAT NULL,
  `exam` VARCHAR(10) NULL,
  `Student_idStudent` INT NOT NULL,
  `Course_idCourse` INT NOT NULL,
  PRIMARY KEY (`idEnrollment`),
  UNIQUE INDEX `idEnrollment_UNIQUE` (`idEnrollment` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO student (groop,email,password,address,cnp,name) VALUES (6 , 'cer' ,'cer','asdfg','12345','Daca');
delete from student where email = 'rea';
select * from student;
select * from teacher;

INSERT INTO course (startHour,endHour,location,Teacher_idTeacher) VALUES ('13:07' , '16:00' ,34,2);
INSERT INTO course (startHour,endHour,location,Teacher_idTeacher) VALUES ('14:00' , '16:00' ,38,4);
INSERT INTO course (startHour,endHour,location,Teacher_idTeacher) VALUES ('15:57' , '18:00' ,14,3);
INSERT INTO course (startHour,endHour,location,Teacher_idTeacher) VALUES ('17:07' , '19:00' ,90,3);
INSERT INTO course (startHour,endHour,location,Teacher_idTeacher) VALUES ('10:00' , '12:00' ,5,1);