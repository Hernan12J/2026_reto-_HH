# Autor: hhern
# Fecha: 03/22/2026
# language: es
Característica: Login de usuario y compra de producto  en Demoblaze

  @HH-3
Escenario: Compra exitosa de producto
  Dado que "Hernan" abre el sitio web
  Y el inicia sesion con credenciales validas
  Cuando el agrega un producto al carrito
  Y el completa la compra
  Entonces el deberia ver un mensaje de compra exitosa