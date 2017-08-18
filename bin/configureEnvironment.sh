#!/bin/bash

detener(){
dur=$(echo "$(date +%s) - $start" | bc);
while [ $dur -le 25 ]; do
dur=$(echo "$(date +%s) - $start" | bc);
done
killall -9 gulp;
}
buscar(){
read -e -p "Ingrese la ruta de la carpeta weblogic: " WLPATH;
echo "Usted ingresó la siguiente ruta: $WLPATH";
cd $WLPATH/server/lib;
pwd;
busqueda=($(find -name wlfullclient.jar));

if [ "${busqueda[0]}" == "" ]; then
echo "El archivo wlfullclient.jar no se encuentra.";
echo;
echo "1 ¿Desea omitir este paso? (No se intalará wlfullclient.jar en la libreria de maven).";
echo "2 ¿Desea agregar una nueva ruta de weblogic?";
read -p "Ingrese el número de la opción deseada: " RESP;

if [ "$RESP" == "2" ]; then
buscar;
fi
else 
mvn install:install-file -Dfile=wlfullclient.jar -DgroupId=co.com.swatit.pila -DartifactId=wlfullclient -Dversion=1.0 -Dpackaging=jar;
fi
}

cd ..;
scriptpath=$(pwd);
pwd;


buscar;


cd $scriptpath/electron/;
pwd;

sudo chown -R $USER:$GROUP ~/.npm;
sudo chown -R $USER:$GROUP ~/.config;
echo "Ejecutando npm install -g electron";
sudo npm install -g electron;
echo "Ejecutando npm install";
sudo npm install;
echo "Ejecutando npm install -g gulp";
sudo npm install -g gulp;
echo "Ejecutando bower install";
bower install;
echo "Ejecutando gulp development";
start=$(date +%s);
gulp development & detener;


cd jar/lib/;
pwd;


#Pila-util
echo "Instalando dependencias de maven para pila-util";
echo;
mvn install:install-file -Dfile=apt-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=apt.api.biz -Dversion=2.0 -Dpackaging=jar;
mvn install:install-file -Dfile=cfg-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=cfg.api.biz -Dversion=2.0 -Dpackaging=jar;
mvn install:install-file -Dfile=common-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=common.api.biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-exceptions-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-exceptions -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-base-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-base -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-jee-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-jee -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=seg-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=seg.api.biz -Dversion=1.0 -Dpackaging=jar;
# no se encuentra en la carpeta lib
#mvn install:install-file -Dfile=wlfullclient.jar -DgroupId=co.com.swatit.pila -DartifactId=wlfullclient -Dversion=1.0 -Dpackaging=jar 
mvn install:install-file -Dfile=pla-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=pla.api.biz -Dversion=2.0 -Dpackaging=jar;
#Falta un metodo
mvn install:install-file -Dfile=arc-biz-1.0.jar -DgroupId=co.com.swatit.pila -DartifactId=arc.api.biz -Dversion=2.0 -Dpackaging=jar;

#Carpeta Java/pila-util
cd $scriptpath/java/pila-util/;


mvn clean;
mvn package;
cd target/;

echo "Instalando dependencias de maven para pila-business";
echo;
mvn install:install-file -Dfile=pila-util-2.0.0.jar -DgroupId=pila-business -DartifactId=pila-util -Dversion=2.0.0 -Dpackaging=jar;

#Cambiar nombre por pila-util-2.0 Copiar y remplazar de java\pila-util\target a electron\jar\lib 

sudo cp pila-util-2.0.0.jar $scriptpath/electron/jar/lib/;

sudo cd $scriptpath/electron/jar/lib/;
sudo rm pila-util-2.0.jar;
sudo mv pila-util-2.0.0.jar pila-util-2.0.jar;

 

#Pila Business

cd $scriptpath/java/pila-business/;

mvn clean;
mvn package;

cd target/;

cp pila-util-2.0.0.jar $scriptpath/electron/jar/lib/;
#El archivo POM solo tiene una dependencia


#pila-webservices
cd $scriptpath/electron/jar/lib;
pwd;

echo "Instalando dependencias de maven para pila-webservices";
echo;

mvn install:install-file -Dfile=flatworm-1.0.jar -DgroupId=flatworm -DartifactId=flatworm -Dversion=1.2 -Dpackaging=jar

#Soi empresarial liquidacion
echo "Instalando dependencias de maven para soi-empresarial-liquidación";
echo;

mvn install:install-file -Dfile=soi-empresarial-converters-1.0.jar -DgroupId=soi-empresarial -DartifactId=soi-empresarial-converters -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=soi-empresarial-soportes-1.0.jar -DgroupId=soi-empresarial -DartifactId=soi-empresarial-soportes -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=common-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=common-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=apt-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=apt-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=cfg-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=cfg-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=pla-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=pla-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=arc-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=arc-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=sop-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=sop-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=seg-biz-1.0.jar -DgroupId=lucasian-nsoi -DartifactId=seg-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=pila-util-2.0.jar -DgroupId=lucasian-nsoi -DartifactId=pila-util -Dversion=2.0 -Dpackaging=jar;
mvn install:install-file -Dfile=coherence-standalone-3.4.2.jar -DgroupId=oracle-coherence -DartifactId=coherence-standalone -Dversion=3.4.2 -Dpackaging=jar;
mvn install:install-file -Dfile=flatworm-1.0.jar -DgroupId=flatworm -DartifactId=flatworm -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=common-biz-1.0.jar -DgroupId=lucasian-leaf -DartifactId=common-biz -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-base-1.0.jar -DgroupId=lucasian-leaf -DartifactId=leaf-base -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-jee-1.0.jar -DgroupId=lucasian-leaf -DartifactId=leaf-jee -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=common-validator-1.0.jar -DgroupId=lucasian-leaf -DartifactId=common-validator -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=jbel-0.8.1.jar -DgroupId=jbel -DartifactId=jbel -Dversion=0.8.1 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-exceptions-1.0.jar -DgroupId=lucasian-leaf -DartifactId=leaf-exceptions -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=jasper-itext-2.1.7.jar -DgroupId=jasper -DartifactId=jasper-itext -Dversion=2.1.7 -Dpackaging=jar;
mvn install:install-file -Dfile=jasper-reports-3.7.4.jar -DgroupId=jasper -DartifactId=jasper-reports -Dversion=3.7.4 -Dpackaging=jar;
echo;
echo "El proceso de configuración ha terminado";
