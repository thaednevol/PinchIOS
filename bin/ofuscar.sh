#!/bin/sh
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/
PROGUARD_HOME=/Users/jgutierrez/Downloads/proguard5.3.3

echo 'Using Java: $JAVA_HOME'
echo 'Using Proguard: $PROGUARD_HOME'

#mkdir ../electron/jar_new/

java -Djava.home=$JAVA_HOME -jar $PROGUARD_HOME/lib/proguard.jar @ofuscar_config.pro

echo 'Jars ofuscados correctamente en electron/jar/'
echo 'Eliminando directorio de jars sin ofuscar'

#rm -r ../electron/jar/

echo 'Eliminando jars originales y copiando nuevos jars ofuscados'

JARS_OFUSCADOS=0
JARS_NO_OFUSCADOS=0
COUNTER_VAR=1

if [ -f ../electron/jar/pila-business-new.jar ]; then
  echo 'Reemplazando /jar/pila-business.jar'
  rm ../electron/jar/pila-business.jar
  mv ../electron/jar/pila-business-new.jar ../electron/jar/pila-business.jar
  JARS_OFUSCADOS=$((JARS_OFUSCADOS+COUNTER_VAR))
else
  echo 'No existe /jar/pila-business_new.jar'
  JARS_NO_OFUSCADOS=$((JARS_NO_OFUSCADOS+COUNTER_VAR))
fi

if [ -f ../electron/jar/soi-empresarial-converters-1.0_new.jar ]; then
  echo 'Reemplazando jar/soi-empresarial-converters-1.0.jar'
  rm ../electron/jar/soi-empresarial-converters-1.0.jar
  mv ../electron/jar/soi-empresarial-converters-1.0_new.jar ../electron/jar/soi-empresarial-converters-1.0.jar
  JARS_OFUSCADOS=$((JARS_OFUSCADOS+COUNTER_VAR))
else
  echo 'No existe jar/soi-empresarial-converters-1.0_new.jar'
  JARS_NO_OFUSCADOS=$((JARS_NO_OFUSCADOS+COUNTER_VAR))
fi

if [ -f ../electron/jar/soi.empresarial.liquidacion-1.0.1_new.jar ]; then
  echo 'Reemplazando jar/soi.empresarial.liquidacion-1.0.1.jar'
  rm ../electron/jar/soi.empresarial.liquidacion-1.0.1.jar
  mv ../electron/jar/soi.empresarial.liquidacion-1.0.1_new.jar ../electron/jar/soi.empresarial.liquidacion-1.0.1.jar
  JARS_OFUSCADOS=$((JARS_OFUSCADOS+COUNTER_VAR))
else
  echo 'No existe jar/soi.empresarial.liquidacion-1.0.1_new.jar'
  JARS_NO_OFUSCADOS=$((JARS_NO_OFUSCADOS+COUNTER_VAR))
fi

echo 'Finalizo el proceso de ofuscar jars de aplicación'
echo 'JARS Ofuscados: '$JARS_OFUSCADOS
echo 'JARS No Ofuscados: '$JARS_NO_OFUSCADOS
