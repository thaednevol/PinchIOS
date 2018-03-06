#!/bin/bash

SVN_PATH="http://190.145.18.210/nuevo_soi.frontend/impl/branch/2018/proximaVersion_Febrero_3/"
cd ..;
scriptpath=$(pwd);
SOI_EMPRESARIAL_HOME=$(pwd)

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

obtenerComunes(){
svn co $SVN_PATH/deploy
svn co $SVN_PATH/deploy.back
svn co $SVN_PATH/deploy.src
svn co $SVN_PATH/lib.biz
svn co $SVN_PATH/lib.web
svn co $SVN_PATH/resources

cd $scriptpath/deploy/APP-INF/lib

mvn install:install-file -Dfile=leaf-evol-common-exceptions.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-exceptions -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-evol-common-exceptions.jar -DgroupId=lucasian-leaf -DartifactId=leaf-exceptions -Dversion=1.0 -Dpackaging=jar;

mvn install:install-file -Dfile=leaf-evol-common-base.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-base -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-evol-common-base.jar -DgroupId=lucasian-leaf -DartifactId=leaf-base -Dversion=1.0 -Dpackaging=jar;

mvn install:install-file -Dfile=leaf-evol-common-jee.jar -DgroupId=co.com.swatit.pila -DartifactId=leaf-evol-common-jee -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-evol-common-jee.jar -DgroupId=lucasian-leaf -DartifactId=leaf-jee -Dversion=1.0 -Dpackaging=jar;

mvn install:install-file -Dfile=flatworm-1.2-LUC.jar -DgroupId=flatworm -DartifactId=flatworm -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=coherence.jar -DgroupId=oracle-coherence -DartifactId=coherence-standalone -Dversion=3.4.2 -Dpackaging=jar;
mvn install:install-file -Dfile=leaf-evol-common-validator.jar -DgroupId=lucasian-leaf -DartifactId=common-validator -Dversion=1.0 -Dpackaging=jar;

mvn install:install-file -Dfile=iText-2.1.7.jar -DgroupId=jasper -DartifactId=jasper-itext -Dversion=2.1.7 -Dpackaging=jar;
mvn install:install-file -Dfile=jasperreports-3.7.4.jar -DgroupId=jasper -DartifactId=jasper-reports -Dversion=3.7.4 -Dpackaging=jar;
}

construirDependencia(){
cd $scriptpath
rm -Rf $SVN_MODULE
svn co $SVN_PATH/$SVN_MODULE
cd $SVN_MODULE
xmlstarlet ed --inplace -s /project -t elem -n property -v "" --var new-field '$prev' -i '$new-field' -t attr -n "name" -v "library.soiclic" -i '$new-field' -t attr -n "value" -v $ANT_MODULE build.xml
xmlstarlet ed --inplace -s /project -t elem -n property -v "" --var new-field '$prev' -i '$new-field' -t attr -n "name" -v "library.path.soiclic" -i '$new-field' -t attr -n "value" -v $scriptpath/electron/jar/lib/ build.xml
xmlstarlet ed --inplace -s "/project" -t elem -n 'target' -v '' --var new-field '$prev' \
-i '$new-field' -t attr -n name -v 'soiclic' \
-i '$new-field' -t attr -n depends -v 'deploy' \
-s '$new-field' -t "elem" -n "copy" -v "" --var new-field '$prev' \
-i '$new-field' -t attr -n file -v '${app-inf-lib}/${library.api.filename}' \
-i '$new-field' -t attr -n tofile -v  '${library.path.soiclic}/${library.soiclic}' \
build.xml

ant soiclic
cd $scriptpath/electron/jar/lib/
#Pila-util
echo "Instalando dependencias de maven para pila-util $SVN_MODULE";
echo;
mvn install:install-file -Dfile=$ANT_MODULE -DgroupId=co.com.swatit.pila -DartifactId=$MVN_MODULE -Dversion=2.0 -Dpackaging=jar;
mvn install:install-file -Dfile=$ANT_MODULE -DgroupId=lucasian-nsoi -DartifactId=$MVN_LUC_MODULE -Dversion=1.0 -Dpackaging=jar;
mvn install:install-file -Dfile=$ANT_MODULE -DgroupId=lucasian-leaf -DartifactId=$MVN_LUC_MODULE -Dversion=1.0 -Dpackaging=jar;
}

construirDependencias(){
CFG=("cfg.biz" "cfg-biz-1.0.jar" "cfg.api.biz" "cfg-biz")
APT=("apt.biz" "apt-biz-1.0.jar" "apt.api.biz" "apt-biz")
COMMON=("common.biz" "common-biz-1.0.jar" "common.api.biz" "common-biz")
SEG=("seg.biz" "seg-biz-1.0.jar" "seg.api.biz" "seg-biz")
PLA=("pla.biz" "pla-biz-1.0.jar" "pla.api.biz" "pla-biz")
ARC=("arc.biz" "arc-biz-1.0.jar" "arc.api.biz" "arc-biz")
AUD=("aud.biz" "aud-biz-1.0.jar" "aud.api.biz" "aud-biz")
INTOPE=("intOpe.biz" "intOpe-biz-1.0.jar" "intOpe.api.biz" "intope-biz")
COMMONPEN=("common.pen" "common-pen-1.0.jar" "common.pen.api.biz" "common-pen")
PENONLINE=("pen.online.biz" "pen-online-biz-1.0.jar" "pen.online.api.biz" "pen-online-biz")
PSEBIZ=("pse.biz" "pse-biz-1.0.jar" "pse.api.biz" "pse-biz")
SOP=("sop.biz" "sop-biz-1.0.jar" "sop.api.biz" "sop-biz")

MODULES=(
COMMON[@]
CFG[@]
SEG[@]
AUD[@]
APT[@]
INTOPE[@]
PLA[@]
COMMONPEN[@]
ARC[@]
PENONLINE[@]
PSEBIZ[@]
SOP[@]
)
COUNT=${#MODULES[@]}
for ((i=0; i<$COUNT; i++))
do
  SVN_MODULE=${!MODULES[i]:0:1}
  ANT_MODULE=${!MODULES[i]:1:1}
  MVN_MODULE=${!MODULES[i]:2:1}
  MVN_LUC_MODULE=${!MODULES[i]:3:1}
  construirDependencia
done
}

configurarElectron(){
cd $scriptpath/electron/;
pwd;

#sudo chown -R $USER:$GROUP ~/.npm;
#sudo chown -R $USER:$GROUP ~/.config;
echo "Ejecutando npm install -g electron";
npm install electron;
echo "Ejecutando npm install";
npm install;
echo "Ejecutando npm install -g gulp";
npm install gulp;
echo "Ejecutando bower install";
bower install;
echo "Ejecutando gulp development";
start=$(date +%s);
gulp development & detener;
}

construirJarsElectron(){
cd jar/lib/;
pwd;

#Carpeta Java/pila-util
cd $scriptpath/java/pila-util/;


mvn clean;
mvn package;
cd target/;

echo "Instalando dependencias de maven para pila-business";
echo;
mvn install:install-file -Dfile=pila-util-2.0.0.jar -DgroupId=pila-business -DartifactId=pila-util -Dversion=2.0.0 -Dpackaging=jar;
mvn install:install-file -Dfile=pila-util-2.0.0.jar -DgroupId=lucasian-nsoi -DartifactId=pila-util -Dversion=2.0 -Dpackaging=jar;

#Cambiar nombre por pila-util-2.0 Copiar y remplazar de java\pila-util\target a electron\jar\lib 

cp pila-util-2.0.0.jar $scriptpath/electron/jar/lib/;

cd $scriptpath/electron/jar/lib/;
rm pila-util-2.0.jar;
mv pila-util-2.0.0.jar pila-util-2.0.jar;


#Pila Business
echo 'Generando pila-business.jar'
cd $SOI_EMPRESARIAL_HOME/java/pila-business/
mvn clean
mvn package

echo 'pila-business.jar Generado'
cd target
cp pila-business-2.0.0.jar $SOI_EMPRESARIAL_HOME/electron/jar/pila-business.jar


echo 'Generando soi.empresarial.converters.jar'
cd $SOI_EMPRESARIAL_HOME/java/soi.empresarial.converters/

mvn clean
mvn package
cd target
mvn install:install-file -Dfile=soi.empresarial.converters-2.0.0.jar -DgroupId=soi-empresarial -DartifactId=soi-empresarial-converters -Dversion=1.0 -Dpackaging=jar
cp soi.empresarial.converters-2.0.0.jar $SOI_EMPRESARIAL_HOME/electron/jar/soi-empresarial-converters-1.0.jar
echo 'soi.empresarial.converters.jar Generado'

echo 'Generando soi.empresarial.soprtes-1.0.1.jar'
cd $SOI_EMPRESARIAL_HOME/java/soi.empresarial.soportes/

mvn clean
mvn package
cd target
cp soi.empresarial.soportes-1.0.1-exec.jar $SOI_EMPRESARIAL_HOME/electron/jar/soi.empresarial.soportes-1.0.1.jar
mvn install:install-file -Dfile=soi.empresarial.soportes-1.0.1-exec.jar -DgroupId=soi-empresarial -DartifactId=soi-empresarial-soportes -Dversion=1.0 -Dpackaging=jar

echo 'soi.empresarial.liquidacion-1.0.1.jar Generado'


echo '*********************Fin Generación proyectos java de SOI Empresarial para incluir en aplicativo, revise el log********************'

echo 'Generando soi.empresarial.liquidacion-1.0.1.jar'
cd $SOI_EMPRESARIAL_HOME/java/soi.empresarial.liquidacion/

mvn clean
mvn package
cd target
cp soi.empresarial.liquidacion-1.0.1-exec.jar $SOI_EMPRESARIAL_HOME/electron/jar/soi.empresarial.liquidacion-1.0.1.jar
echo 'soi.empresarial.liquidacion-1.0.1.jar Generado'
}

buscar;
obtenerComunes;
construirDependencias;
configurarElectron
construirJarsElectron


echo '*********************Fin Generación proyectos java de SOI Empresarial para incluir en aplicativo, revise el log********************'

