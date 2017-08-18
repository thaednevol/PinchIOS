-injars       ../electron/jar/pila-business.jar
-outjars      ../electron/jar/pila-business-new.jar
-keep public class co.swatit.pilabusiness.services.ApplicationMain { public static void main(java.lang.String[]); }
-keep class com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }
-keepattributes *Annotation*,Exceptions,InnerClasses,Signature,Deprecated,SourceFile
-dontoptimize
-dontshrink


-injars       ../electron/jar/soi-empresarial-converters-1.0.jar 
-outjars      ../electron/jar/soi-empresarial-converters-1.0_new.jar
-keep public class com.ach.soi.empresarial.converters.core.ConverterPila { public static void main(java.lang.String[]); }
-keep class com.lucasian.common.validator.**,com.ach.soi.empresarial.converters.model.**,com.ach.soi.empresarial.converters.parsers.*,com.ach.**.biz.transfer.**,com.ach.**.biz.model.**,co.swatit.pilautil.dto.**,!com.lucasian.**,!co.swatit.**,!com.ach.** { *; }
-dontoptimize
-dontshrink
-ignorewarnings



-injars       ../electron/jar/soi.empresarial.liquidacion-1.0.1.jar(BOOT-INF/classes/)
-outjars      ../electron/jar/soi.empresarial.liquidacion-1.0.1_new.jar
-keep public class  com.ach.soi.empresarial.liquidacion.server.LiquidacionServer { public static void main(java.lang.String[]); }
-keep class com.ach.soi.empresarial.liquidacion.model.**,com.ach.soi.empresarial.liquidacion.server.LiquidacionRestController,!com.ach.soi.empresarial.liquidacion.**{ *; }
-keepattributes *Annotation*,Exceptions,InnerClasses,Signature,Deprecated,SourceFile
-keepparameternames
-dontwarn com.ach.arc.biz.ejb.AlmacenarPlanillasIncompletasMDBean,com.ach.sop.**,oracle.sql.**,com.ach.pse.**,com.ach.intOpe.**,com.ach.aud.**,commonj.**,com.ach.pa.**,weblogic.**,com.ach.pen.**,oracle.jdbc.**,com.bea.**,com.blackbear.**,com.lowagie.**,com.strategicgains.**,domain.**,com.wutka.**,com.tangosol.**,javax.**,junit.**,org.yaml.**,org.**,com.oracle.**,com.google.**,org.springframework.**,com.sun.**,co.swatit.**,com.fasterxml.**,net.sf.**
-dontoptimize
-dontshrink



-libraryjars <java.home>/lib/rt.jar:<java.home>/lib/jce.jar:<java.home>/lib/ext/sunjce_provider.jar     

