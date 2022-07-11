-- login config
update sys_config set value=0 where code='system.login.captcha.any';
update sys_config set value='{account:"",password:"",captcha:""}'  where code='system.login.default';

