drop user pipi;
/
drop profile app_user cascade;
/
CREATE PROFILE app_user LIMIT
   FAILED_LOGIN_ATTEMPTS 5
   PASSWORD_LIFE_TIME 60
   PASSWORD_REUSE_TIME 60
   PASSWORD_REUSE_MAX 5
   PASSWORD_LOCK_TIME 1/24
   PASSWORD_GRACE_TIME 10;
/
CREATE USER pipi2
   IDENTIFIED by pipi
   PROFILE app_user;
/