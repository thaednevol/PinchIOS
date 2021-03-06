#!/bin/sh
JAVA_HOME=/opt/java/jdk1.8.0_144/

echo '*********************Generando proyectos java de SOI Empresarial para incluir en aplicativo********************'


echo 'Ofuscar Codigo' $1


echo 'Generando pila-util.jar'
cd ..
SOI_EMPRESARIAL_HOME=$(pwd)
cd  java/pila-util/
mvn clean
mvn package

echo 'pila-util.jar Generado'
cd target
mvn install:install-file -Dfile=pila-util-2.0.0.jar  -DgroupId=pila-business -DartifactId=pila-util -Dversion=2.0.0 -Dpackaging=jar
mvn install:install-file -Dfile=pila-util-2.0.0.jar  -DgroupId=lucasian-nsoi -DartifactId=pila-util -Dversion=2.0 -Dpackaging=jar


echo 'Generando pila-business.jar'
cd $SOI_EMPRESARIAL_HOME
cd  java/pila-business/
mvn clean
if [ $1 = "S" ]; then
  echo '------- Ofuscando pila-business.jar'
  mvn install
else
  mvn package
fi

echo 'pila-business.jar Generado'
cd target
cp pila-business-2.0.0.jar $SOI_EMPRESARIAL_HOME/electron/jar/pila-business.jar


echo 'Generando soi.empresarial.converters.jar'
cd $SOI_EMPRESARIAL_HOME
cd java/soi.empresarial.converters/
mvn clean
if [ $1 = "S" ]; then
  echo '------- Ofuscando soi.empresarial.converters'
  mvn install
  cd target
else
  mvn package
  cd target
    mvn install:install-file -Dfile=soi.empresarial.converters-2.0.0.jar -DgroupId=soi-empresarial -DartifactId=soi-empresarial-converters -Dversion=1.0 -Dpackaging=jar
fi
echo 'soi.empresarial.converters.jar Generado'
cp soi.empresarial.converters-2.0.0.jar $SOI_EMPRESARIAL_HOME/electron/jar/soi-empresarial-converters-1.0.jar

echo 'Generando soi.empresarial.liquidacion-1.0.1.jar'
cd $SOI_EMPRESARIAL_HOME
cd java/soi.empresarial.liquidacion/
mvn clean
mvn compile
if [ $1 = "S" ]; then
  echo '------- Ofuscando soi.empresarial.liquidacion'
  mvn install
else
  mvn package
fi

echo 'soi.empresarial.liquidacion-1.0.1.jar Generado'
cd target
cp soi.empresarial.liquidacion-1.0.1-exec.jar $SOI_EMPRESARIAL_HOME/electron/jar/soi.empresarial.liquidacion-1.0.1.jar

if [ -d "$SOI_EMPRESARIAL_HOME/electron/jar/lib" ]; then
  echo 'Eliminando directorio $SOI_EMPRESARIAL_HOME/electron/jar/lib'
  rm -r $SOI_EMPRESARIAL_HOME/electron/jar/lib/
fi


echo '*********************Fin Generación proyectos java de SOI Empresarial para incluir en aplicativo, revise el log********************'
