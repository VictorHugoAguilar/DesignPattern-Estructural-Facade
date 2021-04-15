# DesignPattern - Estructural - Facade

Facade es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.

El patrón Facade (fachada) tiene la característica de ocultar la complejidad de interactuar con un conjunto de subsistemas proporcionando una interface de alto nivel, la cual se encarga de realizar la comunicación con todos los subsistemas necesarios. La fachada es una buena estrategia cuando requerimos interactuar con varios subsistemas para realizar una operación concreta ya que se necesita tener el conocimiento técnico y funcional para saber qué operaciones de cada subsistema tenemos que ejecutar y en qué orden, lo que puede resultar muy complicado cuando los sistemas empiezan a crecer demasiado.

![UML Sigleton](https://github.com/VictorHugoAguilar/DesignPattern-Estructural-Facade/blob/master/img/facade-diagram.png?raw=true)

IFacade: Proporciona una interface de alto nivel que oculta la complejidad de interactuar con varios sistemas para realizar una operación.
Client : Sistema o evento que interactúa con la fachada.
DefaultFacadeImpl: Representa la implementación de IFacade y se encarga de comunicarse con todos los subsistemas.
Subsystems: Representa módulos o subsistemas que exponen interfaces para comunicarse con ellos.

![Diagrama de secuencia](https://github.com/VictorHugoAguilar/DesignPattern-Estructural-Facade/blob/master/img/facade-sequence.png?raw=true)

El cliente invoca una operación de la fachada.
La fachada se comunica con el SubsystemA para realiar una operación.
La fachada se comunica con el SubsystemB para realiar una operación.
La fachada se comunica con el SubsystemC para realiar una operación.
La fachada responde al cliente con el resultado de la operación.

## Analogía en el mundo real

![Diagrama de secuencia](https://github.com/VictorHugoAguilar/DesignPattern-Estructural-Facade/blob/master/img/live-example-es.png?raw=true)

Cuando llamas a una tienda para hacer un pedido por teléfono, un operador es tu fachada a todos los servicios y departamentos de la tienda. El operador te proporciona una sencilla interfaz de voz al sistema de pedidos, pasarelas de pago y varios servicios de entrega.

## Estructura

![Diagrama de secuencia](https://github.com/VictorHugoAguilar/DesignPattern-Estructural-Facade/blob/master/img/structure.png?raw=true)

1.- El patrón Facade proporciona un práctico acceso a una parte específica de la funcionalidad del subsistema. Sabe a dónde dirigir la petición del cliente y cómo operar todas las partes móviles.

2.- Puede crearse una clase Fachada Adicional para evitar contaminar una única fachada con funciones no relacionadas que podrían convertirla en otra estructura compleja. Las fachadas adicionales pueden utilizarse por clientes y por otras fachadas.

3.- El Subsistema Complejo consiste en decenas de objetos diversos. Para lograr que todos hagan algo significativo, debes profundizar en los detalles de implementación del subsistema, que pueden incluir inicializar objetos en el orden correcto y suministrarles datos en el formato adecuado.

Las clases del subsistema no conocen la existencia de la fachada. Operan dentro del sistema y trabajan entre sí directamente.

4.- El Cliente utiliza la fachada en lugar de invocar directamente los objetos del subsistema.




