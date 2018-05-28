#!/bin/sh

vagrant up

sftp vagrant@192.168.50.103 <<EOT
  get -r images
  bye
EOT
