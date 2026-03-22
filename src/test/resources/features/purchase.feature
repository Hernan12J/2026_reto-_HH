# Autor: hhern
# Fecha: 03/22/2026
# language: es
Característica: Login de usuario y compra de producto  en Demoblaze

Escenario: Compra exitosa de producto
  Dado que "Hernan" abre el sitio web
  Y el inicia sesion con usuario "Test2cre2g2" y contrasena "pass123"
  Cuando el agrega un producto al carrito
  Y el completa la compra
  Entonces el deberia ver un mensaje de compra exitosa