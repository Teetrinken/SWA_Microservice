Vagrant.configure("2") do |config|
  
  config.vm.box = "ubuntu/xenial64"

  config.vm.network "private_network", ip: "192.168.50.102"

  config.vm.provision :docker
  # config.vm.provision :shell, path: "scripts/bootstrap.sh"

end
