-- 테이블 gamedb.board 구조 내보내기
CREATE TABLE IF NOT EXISTS board (
  bNum SERIAL PRIMARY KEY,
  bigcategory varchar(30) DEFAULT NULL,
  category varchar(30) DEFAULT NULL,
  bTitle varchar(50) DEFAULT NULL,
  bContent text,
  bReadCount integer DEFAULT NULL,
  userEmail varchar(30) DEFAULT NULL,
  password varchar(30) DEFAULT NULL,
  fileName varchar(100) DEFAULT NULL,
  reRef integer DEFAULT NULL,
  reLev integer DEFAULT NULL,
  reSeq integer DEFAULT NULL,
  recommend integer DEFAULT NULL,
  report integer DEFAULT NULL,
  notice integer DEFAULT NULL,
  bWriteDate date DEFAULT NULL,
  ip varchar(50) 
);


-- 테이블 gamedb.boardupdown 구조 내보내기
CREATE TABLE IF NOT EXISTS boardupdown (
  num SERIAL PRIMARY KEY,
  bNum integer DEFAULT NULL,
  userEmail varchar(30) DEFAULT NULL,
  recommend integer DEFAULT '0',
  report integer DEFAULT '0',
  uri varchar(100) DEFAULT NULL,
  bTitle varchar(100) DEFAULT NULL,
  ok integer DEFAULT NULL
);


-- 테이블 gamedb.cart 구조 내보내기
CREATE TABLE IF NOT EXISTS cart (
  cartNum SERIAL PRIMARY KEY,
  userEmail varchar(30) NOT NULL,
  cartAmount integer NOT NULL DEFAULT '1',
  proNum integer NOT NULL
);


-- 테이블 gamedb.gamegradeboard 구조 내보내기
CREATE TABLE IF NOT EXISTS gamegradeboard (
  bNum SERIAL PRIMARY KEY,
  bYear varchar(30) DEFAULT NULL,
  bMonth varchar(30) DEFAULT NULL,
  bTitle varchar(50) DEFAULT NULL,
  bContent text,
  bReadCount integer DEFAULT NULL,
  userEmail varchar(30) DEFAULT NULL,
  password varchar(30) DEFAULT NULL,
  fileName varchar(100) DEFAULT NULL,
  reRef integer DEFAULT NULL,
  reLev integer DEFAULT NULL,
  reSeq integer DEFAULT NULL,
  recommend integer DEFAULT NULL,
  report integer DEFAULT NULL,
  notice integer DEFAULT NULL,
  bWriteDate timestamp DEFAULT NULL
);


-- 테이블 gamedb.gamegradedetail 구조 내보내기
CREATE TABLE IF NOT EXISTS gamegradedetail (
  num SERIAL PRIMARY KEY,
  dNum varchar(50) NOT NULL,
  bNum integer NOT NULL,
  authNum varchar(50) DEFAULT NULL,
  gameName varchar(100) DEFAULT NULL,
  gameCompany varchar(60) DEFAULT NULL,
  applyDate varchar(50) DEFAULT NULL,
  decideDate varchar(50) DEFAULT NULL,
  decideGrade varchar(20) DEFAULT NULL,
  receiptNumber varchar(30) DEFAULT NULL,
  agency varchar(10) DEFAULT NULL
);


-- 테이블 gamedb.level 구조 내보내기
CREATE TABLE IF NOT EXISTS levels (
  num SERIAL PRIMARY KEY,
  point integer DEFAULT NULL,
  levels integer DEFAULT NULL
);


-- 테이블 gamedb.point 구조 내보내기
CREATE TABLE IF NOT EXISTS point (
  num SERIAL PRIMARY KEY,
  itemName varchar(20) DEFAULT NULL,
  itemType varchar(20) DEFAULT NULL,
  point integer DEFAULT NULL
);


-- 테이블 gamedb.pointhistory 구조 내보내기
CREATE TABLE IF NOT EXISTS pointhistory (
  num SERIAL PRIMARY KEY,
  userEmail varchar(30) DEFAULT NULL,
  itemName varchar(20) DEFAULT NULL,
  itemType varchar(20) DEFAULT NULL,
  point integer DEFAULT NULL,
  reg_date timestamp DEFAULT NULL
);


-- 테이블 gamedb.product 구조 내보내기
CREATE TABLE IF NOT EXISTS product (
  proNum SERIAL PRIMARY KEY,
  proName varchar(50) NOT NULL,
  proPrice integer DEFAULT '0',
  proContent varchar(1000) DEFAULT NULL,
  proFile varchar(100) DEFAULT NULL,
  proTime timestamp
);


-- 테이블 gamedb.reply 구조 내보내기
CREATE TABLE IF NOT EXISTS reply (
  bNum integer DEFAULT NULL,
  rNum SERIAL PRIMARY KEY,
  rContent text,
  userEmail varchar(30) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  rWriteDate date DEFAULT NULL
);


-- 테이블 gamedb.user 구조 내보내기
CREATE TABLE IF NOT EXISTS member (
  userID SERIAL PRIMARY KEY,
  userEmail varchar(30) DEFAULT NULL,
  userPassword varchar(30) DEFAULT NULL,
  userName varchar(30) DEFAULT NULL,
  userPhone varchar(20) DEFAULT '0',
  userAddr varchar(100) DEFAULT NULL,
  userPoint integer DEFAULT '0',
  userLevel integer DEFAULT '0',
  userLoginCount integer DEFAULT '0',
  userDate timestamp DEFAULT NULL,
  userValidate integer DEFAULT '1',
  userAdmin integer DEFAULT '0',
  sessionkey varchar(50) NOT NULL DEFAULT 'none',
  sessionlimit timestamp
);
