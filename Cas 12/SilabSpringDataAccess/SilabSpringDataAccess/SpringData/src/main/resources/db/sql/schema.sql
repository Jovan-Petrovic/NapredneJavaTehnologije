/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Korisnik
 * Created: Nov 13, 2018
 */

CREATE TABLE user (
  user_id  bigint auto_increment PRIMARY KEY ,
  firstname VARCHAR(50),
lasttname VARCHAR(50),
password VARCHAR(100),
  email  VARCHAR(25)
);