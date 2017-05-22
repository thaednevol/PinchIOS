## Como contribuir

El sistema de control de versiones hace uso de las ramas recomendadas por GIT, todo cambio realizado al codigo se debe realizar y versionar haciendo uso de estas normas.

Las ramas utilizadas en el proyecto son:
* **master:** Almacenara todo el codigo que es de producción, unicamente se realiza merge si el codigo esta testeado, aprobado y listo para realizar una entrega a cliente.
* **develop:** Almacena el codigo que se esta desarrollando en el momento, esta rama se crea desde la versión mas reciente o donde se encuentren errores de la rama master, solo desde esta rama se pueden hacer las integraciones a master.
* **feature_XX:** Almacena el codigo de una caracteristica que se desarrolla en la aplicación, si el programador desarrolla un modulo de login se debe crear la rama feature_login.
