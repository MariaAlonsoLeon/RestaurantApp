# RestauranteApp

## Descripción

El Sistema de Gestión de Restaurantes es una aplicación de software que permite a los restaurantes administrar de manera eficiente sus menús, platos, clientes y pedidos. El sistema es una solución completa que facilita la gestión de restaurantes de cualquier tipo y tamaño. Proporciona a los restaurantes las herramientas necesarias para ser una solución integral que facilita la administración de restaurantes.

## Características principales

- Gestión de Menús: Gestión de menús: El sistema permite a los restaurantes crear, modificar y administrar sus menús, organizándolos en categorías como "Diario", "Degustación", "Infantil" o "Especial del Chef".

- Platos y Descripciones: Los platos pueden incluir un nombre, una descripción y un precio.

- Clientes y Direcciones: Se puede registrar y administrar la información de sus clientes, incluyendo nombres, apellidos, direcciones y pedidos.

- Pedidos Personalizados: Los clientes pueden hacer pedidos personalizados seleccionando platos del menú e indicando las cantidades deseadas.
- Seguimiento de Pedidos: Los restaurantes pueden realizar un seguimiento de los pedidos y calcular el precio total de los pedidos.

- Validación de Datos: Se han implementado controles de validación para garantizar que los datos ingresados sean correctos y coherentes.

## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes:

- org.ulpgc.is1.model: Contiene las clases relacionadas con el modelo de datos, como Customer, Dish, Menu, Order, OrderItem, Phone, Restaurant, y MenuType. Estas clases representan los objetos principales del sistema.

- org.ulpgc.is1.control: contiene la clase principal, Main, para la lógica comercial y la interacción con el usuario.

## Consiederaciones importantes

Además de la implementación propuesta, se decidieron incluir otros métodos y funcionalidades adicionales. Cabe destacar que en el método order() de la clase OrderManager se asumieron algunos detalles. Como por ejemplo que la lista dishesId se refería a los índices de los platos dentro de la lista que los contiene a todos. 
Por otro lado, tal y como está comentado en el enunciado del trabajo se atendió a "La navegabilidad en las asociaciones TODO-PARTE se considerará solo del TODO
a las PARTES" siendo el todo Restaurant y Customer respecto a Order.

Además, para la realización del proyecto se hizo uso del sistema de control de versiones Git, a medida que crecía el desarrollo se fueron confirmando los cambios (commits) en una rama secundaria llamada "develop" y a las versiones funcionales se le hicieron merge a "master" (rama principal).

## Contacto

Este proyecto fue desarrollado por Daniel Talavera Hernández y María Alonso León como parte de la asignatura Ingeniería del Software en la Universidad de Las Palmas de Gran Canaria.
