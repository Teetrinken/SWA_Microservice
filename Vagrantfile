Vagrant.configure("2") do |config|
	
	config.vm.provider "virtualbox" do |v|
  		v.memory = 2048
  		v.cpus = 2
	end
	config.vm.box = "ubuntu/xenial64"
	config.vm.network "private_network", ip: "192.168.50.10"
	
 	config.vm.provision :docker
end
