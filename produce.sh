#!/bin/bash
for release in {79..79}
do
  version=3.0.${release}

  echo producing backend ${version}  
  rm -rf backend-jpa
  mvn -Dmaven-bootstrap-plugin.interactive=false -Pjj -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-backend-jpa com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap
  mv appli backend-jpa
  cd backend-jpa
  mvn -Pdb,metadata,gen,jj generate-sources
  cd ..

  echo producing jsf2 ${version}  
  rm -rf jsf2-primefaces
  mvn -Dmaven-bootstrap-plugin.interactive=false -Pjj -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-jsf2-primefaces com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap 
  mv appli jsf2-primefaces
  cd jsf2-primefaces
  mvn -Pdb,metadata,gen,jj generate-sources
  cd ..

git add . --a 
git commit -m "generated with Celerio v${version} - http://www.springfuse.com/" 
git tag ${version}
done;
