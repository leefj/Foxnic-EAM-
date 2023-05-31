#!/bin/sh


#sh deploy_replace_local_db.sh
#sh deploy_release.sh
#sh deploy_upload_release_file.sh
sh deploy_release_tomcat.sh
sh deploy_update_demo.sh

exit 0