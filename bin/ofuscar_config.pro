-injars       ../electron/jar/pila-business.jar
-outjars      ../electron/jar/pila-business-new.jar
-keep public class co.swatit.pilabusiness.services.ApplicationMain { public static void main(java.lang.String[]); }
-keep class com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }
-keepattributes *Annotation*,Exceptions,InnerClasses,Signature,Deprecated,SourceFile

-injars       ../electron/jar/soi-empresarial-converters-1.0.jar 
-outjars      ../electron/jar/soi-empresarial-converters-1.0_new.jar
-keep public class com.ach.soi.empresarial.converters.core.ConverterPila { public static void main(java.lang.String[]); }
-keep class com.ach.soi.empresarial.converters.model.**,com.ach.soi.empresarial.converters.parsers.*,com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }


-injars       ../electron/jar/soi.empresarial.liquidacion-1.0.1.jar
-outjars      ../electron/jar/soi.empresarial.liquidacion-1.0.1_new.jar
-keep public class  com.ach.soi.empresarial.liquidacion.server.LiquidacionServer { public static void main(java.lang.String[]); }
-keep class com.ach.soi.empresarial.liquidacion.model.**,com.ach.soi.empresarial.liquidacion.server.LiquidacionRestController,com.ach.soi.empresarial.converters.model.**,com.ach.soi.empresarial.converters.parsers.*,com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }
-keepattributes *Annotation*,Exceptions,InnerClasses,Signature,Deprecated,SourceFile
-keepparameternames
-dontshrink

-injars       ../electron/jar/lib/pila-util-2.0.0.jar
-outjars      ../electron/jar/lib/pila-util-2.0.0_new.jar
-keep class com.ach.soi.empresarial.converters.model.**,com.ach.soi.empresarial.converters.parsers.*,com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }


-injars       ../electron/jar/lib/pila-util-2.0.jar
-outjars      ../electron/jar/lib/pila-util-2.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/pla-biz-1.0.jar
-outjars      ../electron/jar/lib/pla-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/seg-biz-1.0.jar
-outjars      ../electron/jar/lib/seg-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/soi-empresarial-converters-1.0.jar
-outjars      ../electron/jar/lib/soi-empresarial-converters-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/soi-empresarial-soportes-1.0.jar
-outjars      ../electron/jar/lib/soi-empresarial-soportes-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/sop-biz-1.0.jar
-outjars      ../electron/jar/lib/sop-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/apt-biz-1.0.jar
-outjars      ../electron/jar/lib/apt-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/arc-biz-1.0.jar
-outjars      ../electron/jar/lib/arc-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/cfg-biz-1.0.jar
-outjars      ../electron/jar/lib/cfg-biz-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/leaf-base-1.0.jar
-outjars      ../electron/jar/lib/leaf-base-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/leaf-exceptions-1.0.jar
-outjars      ../electron/jar/lib/leaf-exceptions-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-injars       ../electron/jar/lib/leaf-jee-1.0.jar
-outjars      ../electron/jar/lib/leaf-jee-1.0_new.jar
-keep class !com.lucasian.**,!co.swatit.**,co.swatit.pilautil.dto.**,!com.ach.** { *; }

-libraryjars  ../electron/jar/lib/:<java.home>/lib/rt.jar  
-dontwarn com.oracle.**
-dontwarn com.google.**
-dontwarn org.apache.**
-dontwarn com.ach.**
-dontwarn org.springframework.**
-dontwarn com.sun.**
-dontwarn org.bouncycastle.**
-dontwarn co.swatit.**
-dontwarn com.fasterxml.**
-dontwarn net.sf.**
-dontwarn com.lucasian.**
-dontwarn org.beanio.**
-dontoptimize
-dontshrink

