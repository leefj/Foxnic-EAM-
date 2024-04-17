#!/bin/sh
ds=`date`
echo $ds>>/tmp/all.log
sh deploy_replace_local_db.sh
sh deploy_release.sh
sh deploy_upload_release_file.sh
sh deploy_release_tomcat.sh
sh deploy_update_demo.sh
de=`date`
echo $de>>/tmp/all.log
echo "-------">>/tmp/all.log
exit 0
