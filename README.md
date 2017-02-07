# Framework
Framework de Usuarios

Proyecto 1ºDAW de Sergio Martínez Guerrero. Aplicación basada en un CRUD de usuarios, con modelo MVC.
El proyecto esta programado en su totalidad con JAVA.

##Elementos generales
El Framework se basa en 3 tipos de usuarios Admin, Client, Normal.

Contiene un menu basico de CRUD, con opciones añadidas como: "Order","Open","Save".

Las opciones Open y Save, abren o guardan fixeros JSON, TXT y XML de el arraylist de el usuario que estas usando, estas opciones son OnDemmand.

##Inicio de APP
Al iniciar la aplicación cargara de los archivos JSON, TXT y XML automaticamente los usuarios que tenga en el fixero directamente al Arraylist, cargara el fixero JSON de settings,
e iniciara la parte grafica.

##Creación de usaurios (CREATE)
Dentro de "Create" se podran crear tantos usuarios como uno quiera.

Cuenta con 2 modos:

**Modo dummies** (Que se establecen en "Settings") donde crea usuarios automaticamente, totalmente automatizado.

**Modo Normal** donde el usuario debera introducir todos los datos.

##Mostrar usuarios (READ)
El botón "Read" contiene dos opciones:

**Read All**

La opción "Read All" accede a el ArrayList donde se muestran todos los usuarios que contiene.

**Search One**

En la opción "Search One" muestra en un combobox todos los usuarios, donde el usuario deberá elegir uno.
##Settings
El menu settings contiene la configuración de el formato fecha, formato de la moneda, numero de decimales, idioma, dummies, el formato file (de donde se cogera el formato del fixero que posteriomente se abrira o guardara en OnDemmand), el Tema.

A parte se ha añadido una opcion "Default APP" donde se establecera la configuración por defecto de la aplicación.

**Configuración por defecto**

Formato fecha:		dd/mm/yyyy

Formato monneda:	€

Formato Decimales:	.0

Idioma:				Ingles

Dummies:			True

Formato File:		XML

Tema:				METAL

##Idioma
El framework cuenta con 5 idiomas: Ingles, Español, Valencià, Portuges, Italiano.
