# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:
>Atributos (privados):
>id (String): Identificador corto único.
>nombre (String): Nombre completo de la persona
>codigo_postal (String): Ubicación  para determinar si un envío entre dos personas es local o foráneo.
>Constructores:Persona() (por omisión): Inicializa los atributos con valores predeterminados.
>Persona(parametrizado): Crea una instancia asignando directamente los datos proporcionados como argumentos.
>Métodos:Getters y setters (getId/setId, getNombre/setNombre, getCodigoPostal/setCodigoPostal)
>mismaUbicacionQue(Persona otra): Verifica que el parámetro no sea null y compara los códigos postales para determinar si el envío es local o foráneo.
>esLaMismaPersona(Persona otra): Valida que la otra referencia no sea null y comprueba si ambas instancias comparten el mismo id.
>toString(): Devuelve una cadena multilínea con el nombre, identificador y código postal de la persona.  
---


>Atributos y constantes:
>CARGO_FORANEO (public static final double): Constante fijada en 80.0
>folioGuia, remitente, destinatario y paquete (privados)
>conteo (private static int): Contador a nivel de clase inicializado en 0 para llevar el registro global de guías emitidas
>Constructores:
>Envio(): Valida que las referencias recibidas no sean null, incrementa conteo, asigna los atributos y genera automáticamente el folioGuia.
>Métodos GETTERS Y SETTERS y ce creación de folio:
>getConteoGuias() y crearFolioGuia(): El primero devuelve el total de guías emitidas convertido a String; el segundo arma folios con el formato "GUIA-XXX-N" combinando tres dígitos aleatorios (0 a 9) y el número consecutivo.
>Getters (getFolioGuia, getRemitente, getDestinatario, getPaquete): Permiten consultar de forma segura los datos privados de la guía.4

>Métodos de lógica de negocio y representación:
>esEnvioForaneo() y esAutoEnvio(): Evalúan si el envío es entre distintas ubicaciones (comparando códigos postales) o si remitente y destinatario tienen el mismo identificador.>calcularCostoTotal(): Obtiene la tarifa base mediante cotizarEnvio() y suma CARGO_FORANEO si el envío es foráneo.
>cambiarDestinatario(): Actualiza el destinatario siempre que la nueva referencia no sea null.
>generarGuiaRetorno(): Crea una nueva guía invirtiendo remitente y destinatario y antepone "RET-" al código de rastreo del paquete.
>toString(): Devuelve el comprobante textual de la guía con remitente, destinatario, paquete, folio y el tipo de ruta evaluado mediante un operador ternario.   

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta (`practica09/`):

### 1. Compilación
```bash
<javac src/*java -d bin>
```

### 2. Ejecución de pruebas y simulación (`PruebaEnvio`)
```bash
<java -cp bin PruebaEnvio>
```


### 4. Generación de documentación Javadoc
```bash
<javadoc -d doc src/*.java>
```

---

## Evidencia de ejecución

### 1. Salida de `PruebaEnvio`
Copia y pega aquí la salida final que mostró tu terminal al ejecutar `PruebaEnvio`:

```text
================================================================================
  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO
================================================================================

>>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE
  [OK]    Paquete.toString() incluye el codigo de rastreo
  [OK]    Constructor por copia de Paquete crea instancia independiente en memoria
  [OK]    Modificar el codigo del paquete clonado no altera el paquete plantilla original
  [OK]    Constructor por copia con null asigna valores predeterminados validos

>>> PARTE 2: VERIFICACION DE LA CLASE PERSONA
¿Maria tiene la misma ubicación que Juan? expected:true value: true
¿Maria tiene la misma ubicación que Ana? expected:false value: false
¿Maria es la misma persona que Ana? expected:false value: false
¿Maria es la misma persona que Maria 2? expected: true value: true
¿Maria es la misma persona que null? expected:false value: false
Nombre: Maria
 ID: 1
 Código postal: 01832
Nombre: Juan
 ID: 2
 Código postal: 01832
Nombre: Ana
 ID: 30
 Código postal: 07353
>>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS
Conteo de número de guías emitidas: 0
Folio envio1: GUIA-086-1
Folio envio2: GUIA-483-2
¿Es foráneo el envio1: expected: false value: false
¿Es foráneo el envio2: expected: true value: false
Costo de envio1: $120.0
Costo de envio2: $200.0
¿Se cambia destinatario si es null?  expected: false value: false
Cambio válido de destinatario 
Remitente: Nombre: Maria
 ID: 1
 Código postal: 01832
Destinatario: Nombre: Maria
 ID: 1
 Código postal: 01832
Paquete: Código de rastreo: KIT-101
 Peso real: 4.0
 Peso volumétrico: 1.6
 Peso cobrable: 4.0
 Valor declarado: 500.0
 Modalidad exprés: false
Folio: GUIA-086-1
Local
>>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO
Guia de envio paquete 3

Remitente: Nombre: Maria
 ID: 1
 Código postal: 01832
Destinatario: Nombre: Juan
 ID: 2
 Código postal: 01832
Paquete: Código de rastreo: KIT-101
 Peso real: 4.0
 Peso volumétrico: 1.6
 Peso cobrable: 4.0
 Valor declarado: 500.0
 Modalidad exprés: false
Folio: GUIA-081-3
Local
Guia de envio paquete 4

Remitente: Nombre: Maria
 ID: 1
 Código postal: 01832
Destinatario: Nombre: Juan
 ID: 2
 Código postal: 01832
Paquete: Código de rastreo: KIT-101
 Peso real: 4.0
 Peso volumétrico: 1.6
 Peso cobrable: 4.0
 Valor declarado: 500.0
 Modalidad exprés: false
Folio: GUIA-619-4
Local
Guia de  retorno del paquete 3

Remitente: Nombre: Juan
 ID: 2
 Código postal: 01832
Destinatario: Nombre: Maria
 ID: 1
 Código postal: 01832
Paquete: Código de rastreo: RET-KIT-101
 Peso real: 4.0
 Peso volumétrico: 1.6
 Peso cobrable: 4.0
 Valor declarado: 500.0
 Modalidad exprés: false
Folio: GUIA-696-5
Local

================================================================================
  RESUMEN DE PRUEBAS: 4 / 4 pruebas superadas con exito
================================================================================
```

### 2. Ejemplo de ejecución interactiva (`MenuPostal`)
Copia y pega aquí un ejemplo sencillo de interacción en terminal ejecutando `MenuPostal`:

```text
[Pega aquí tu ejemplo de ejecución del menú interactivo]
```

---

## Preguntas de reflexión 

1. **¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?**
   > new Paquete(kitBase) realiza una copia independiente y no comparte datos en  memoria, mientras que new Envio(guiaBase, nuevoPaquete) usa las instancias de Persona en memoria y únicamente cambia la guía y el paquete .

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > Agregué el modificador static, sin este modificador estático el conteo se perdería con cada nueva instancia de Envio.

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > Siguen existiendo en memoria, porque su relación era de agregación.
