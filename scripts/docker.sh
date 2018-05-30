#!/bin/sh

vagrant ssh <<EOT
sudo docker load < /vagrant/images/mysql.tar
sudo docker load < /vagrant/images/parcelsize.tar
sudo docker load < /vagrant/images/parcelwebserver.tar

sudo docker network create -d bridge bridge-network

sudo docker run --detach --name=parcelsize --network=bridge-network -p 8000:8000 teetrinken/parcelsize:8.0
sudo docker run --detach --name=parcel_webserver --network=bridge-network -p 8080:8080 teetrinken/parcelwebserver:asset-1.0
sudo docker run --detach --name=mysql_parcelsize --mount type=bind,src=/vagrant/scripts/mysql,dst=/docker-entrypoint-initdb.d/ --network=bridge-network -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=mypass" mysql:5.7
exit
EOT
