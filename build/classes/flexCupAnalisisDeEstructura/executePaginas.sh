
#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar /home/jesfrin/Documentos/LibreriasJava/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d  /home/jesfrin/NetBeansProjects/Proyecto1Compi1Manejador/src/recuperacionPaginas flexPaginas.flex

echo "STARTING CUP COMPILING"
java -jar /home/jesfrin/Documentos/LibreriasJava/cup/java-cup-11b.jar cupPaginas.cup 
mv parser.java  /home/jesfrin/NetBeansProjects/Proyecto1Compi1Manejador/src/recuperacionPaginas/parser.java
mv sym.java  /home/jesfrin/NetBeansProjects/Proyecto1Compi1Manejador/src/recuperacionPaginas/sym.java


