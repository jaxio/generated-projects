#!/bin/bash
for release in {70..83}
do
  version=3.0.${release}

  echo producing backend ${version}  
  rm -rf appli 
  mvn com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap -Dmaven-bootstrap-plugin.interactive=false -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-backend-jpa
  mv appli backend-jpa
  cd backend-jpa
  mvn -Pdb,metadata,gen
  cd ..

  echo producing jsf2 ${version}  
  rm -rf appli
  mvn com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap -Dmaven-bootstrap-plugin.interactive=false -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-jsf2-primefaces
  mv appli jsf2-primefaces
  cd jsf2-primefaces
  mvn -Pdb,metadata,gen
  cd ..

  git add . --a 
  git commit -m "${version}" 
  git tag ${version}
done;
