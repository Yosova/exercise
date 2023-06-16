# Introducción 
Este es un ejercicio de onboarding

# Consideraciones

El servicio está implementado usando base de datos en memoria H2.

Se valida el request con anotaciones y el response dependiendo de si devuelve resultado efectivos o no la consulta.

La versión de java utilizada es la 17.

Los test se implementaron con cucumber, pueden ver la definición en el fichero price.feature y la implementación en la clase PriceStepDefsIT. Para ejecutarlos solo hay que correr el price.feature así como PricesApplication para ejecutar el micro.

En la raíz del proyecto de adjunta un proyecto postman para realizar la petición al servicio.