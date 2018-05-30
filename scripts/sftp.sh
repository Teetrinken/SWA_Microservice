#!/bin/sh

sftp vagrant@192.168.33.10 <<EOT
  get -r images
  bye
EOT
