# DesignPattern - Creational - Singleton
Patrón de diseño - Creacional - Singleton

Este patrón se implementa haciendo privado el constructor de la clase y creando (en la propia clase) un método que crea una instancia del objeto si este no existe. Veamos a continuación un ejemplo de este patrón en el que vamos a crear una clase llamada "SoyUnico" con un constructor que va a ser privado y un método llamado 'getSingletonInstance()' que será el encargado de crear una instancia de esta clase si no se ha creado todavía:

![UML Sigleton](https://github.com/VictorHugoAguilar/DesignPattern-Creational-Singleton/blob/master/img/singleton-diagram.png?raw=true)

![Diagrama de secuencia](https://github.com/VictorHugoAguilar/DesignPattern-Creational-Singleton/blob/master/img/singleton-diagram.png?raw=true)
