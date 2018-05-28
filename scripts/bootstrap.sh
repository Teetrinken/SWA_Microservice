#!/bin/sh

export SSHPASS=vagrant
sshpass -e sftp -oBatchMode=no -b - vagrant@192.168.50.103 << !
  get -r images /home/vagrant
  put /vagrant/web/js/app.js /home/vagrant/components
  put /vagrant/web/js/parcel-address.component.js /home/vagrant/components
  put /vagrant/web/js/parcel-option.component.js /home/vagrant/components
  put /vagrant/web/js/parcel-price.component.js /home/vagrant/components
  put /vagrant/web/js/parcel-size.component.js /home/vagrant/components
  bye
!

docker load < /home/vagrant/images/mysql.tar
docker load < /home/vagrant/images/parcelsize.tar
docker load < /home/vagrant/images/parcelwebserver.tar

docker network create -d bridge bridge-network

docker run --detach --name=parcelsize --network=bridge-network -p 8000:8000 teetrinken/parcelsize:8.0
docker run --detach --name=parcel_webserver --network=bridge-network -p 8080:8080 teetrinken/parcelwebserver:asset-1.0
docker run --detach --name=mysql_parcelsize --mount type=bind,src=/vagrant/scripts/mysql,dst=/docker-entrypoint-initdb.d/ --network=bridge-network -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=mypass" mysql:5.7
