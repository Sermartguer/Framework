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

**Manual**

En la opción "Manual" el usuario introduce un DNI y se muestra el usuario que ha seleccionado

##Update

La opción update nos permite actualizar los datos de un usuario, se muestra un combobox donde elegiremos que usuario queremos actualizar, posteriormente saldra un menú donde el usuario elige que parametro necesita actualizar.

##Delete

La opción "Delete" nos ofrece la opción de eliminar un usuario, en esta opción se muestran dos opciones de las quales podemos seleccionar "Delete All" que nos elimina todos los usuarios y "Search" donde nos saldrá la opción de elegir en un combobox que usuario queremos eliminar

##Order

El parametro "Order" nos permite ordenar todos los usuarios por: DNI, Nombre, Fecha de nacimiento, Años

##Open

La opción "Open" da la opción de abrir un fitxero con el formato que se ha indicado en el "setting".

##Save

La opción "Save" permite guardar la lista de todos los usuarios en un fixero, el formato del cual se ha establecido en "settings"
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
