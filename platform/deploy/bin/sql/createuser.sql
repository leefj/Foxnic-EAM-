create user 'app'@'%' identified by 'P@ssw0rd654321';
grant all privileges  on update_db.* to 'app'@'%' ;
grant all on update_db.* to 'app'@'%' ;
flush privileges;