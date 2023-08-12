#!/bin/bash
echo '{ "insecure-registries" : ["$REGISTRY"] }' | sudo tee /etc/docker/daemon.json
sudo systemctl restart docker
