# Stefanini_todo1
Se realiza creación del proyecto sobre spring boot

Se debe configurar application properties para donde se almacena la bd y sonde se guarda el log

Para descargar el proyecto se debe importa el proyecto parent, despues los modules asociados 
y por alguna razon el todo1-kardex no carga, asi que se debe importar el proyecto desde la carpeta
git donde se descarga el proyecto.

Para compilar se realiza desde el modulo padre para que compile todo los otros.

La version java es <b>1.8</b>
Para ejecutar <b>java -vesion todo1-kardex-0.0.1-SHANPSHOT.jar</b>

# Servicio y objetos de entrada

Servicio de movimiento de ingreso de productos
http://localhost:8080/movements/input

Servicio de movimiento de salida de productos
http://localhost:8080/movements/output

Para movimiento entrada y salida <b>{refProduct,quantity,pucharseValue,movement}</b>

Servicio para obtener loas movimientos de un producto buscando por la referencia del producto
http://localhost:8080/movements/movements/{referencia-producto}

Servicio para probar el funcionamiento
http://localhost:8080/movements/test

Servicio para crear parametros
http://localhost:8080/parameters/create

parametro {name,description,group,value,state}
Para la creacion de parametros <b>{parameters:[:Parametro]}</b>

Servicio para obtener los parametros asociados algrupo
http://localhost:8080/parameters/parameter/{group}

Servicio para obtener el parametro segun el nombre
http://localhost:8080/parameters/parameter/{name}

Servicio para actualizar un parametro
http://localhost:8080/parameters/update

Servicio para crear un producto
http://localhost:8080/products/create

Para creación del producto <b>{name,description,references}</b>

Servicio para obtener producto por referencia
http://localhost:8080/products/product/{reference}

Servicio para obtener todos los servicios
http://localhost:8080/products/products

Servicio para crear varios productos
http://localhost:8080/products/adds

Para creacion de varios productos <b>[{:Producto}]</b>

Servicio para obtener el resumen de un producto
http://localhost:8080/summary/product/{reference}

Servicio para realizar login
http://localhost:8080/user/

Para loggin <b>{userName,passwordBase64}</b>

# cargar datos a parametros

value: LIFO
group: typemovement
state: 1

value: FIFO
group: typemovement
state: 1

desciption: {reference-product}
group: percentagesale
state: 1


