INSERT INTO levels ( point, levels) VALUES
	( 10, 1),
	( 20, 2),
	( 30, 3),
	( 50, 4),
	( 100, 5),
	( 150, 6),
	( 200, 7),
	( 250, 8),
	( 300, 9),
	( 320, 10);

	
INSERT INTO point ( itemName, itemType, point) VALUES
	( '회원가입', 'join', 50),
	( '로그인', 'login', 20),
	( '글쓰기', 'write', 30),
	( '댓글달기', 'reple', 20);
	

INSERT INTO member ( userEmail, userPassword, userName, userPhone, userAddr, userPoint, userLevel, userLoginCount, userDate, userValidate, userAdmin, sessionkey, sessionlimit) VALUES
	( 'harom99@gmail.com', '1234', '홍길동', '0', '서울특별시 동작구 노량진로 171-2, 123 (노량진동)', 1160, 10, 69, '2018-11-30 10:21:27', 1, 1, '8E2DCCABB3883F23DB7F32411970743A', '2018-12-11 16:40:11');
