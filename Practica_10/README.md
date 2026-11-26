# Práctica 10 (Mini-Lab): Arreglos de Tipos Primitivos (`EstacionMeteorologica`)
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección** en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en la entrega directa de Google Classroom.

- **Nombre completo:** César Edahi Guajardo Barreto

---

## Descripción de la práctica

Este programa es fue implementado para elequipo de investigación metereológico registro y análisis de las temperaturas y sus variaciones.

Incluye los siguientes métodos:

EstacionMeteorologica()	Constructor por omisión; crea la estación "Estacion UNAM" con 7 días inicializados en -300.0 (sin lectura).
EstacionMeteorologica(String, int)	Constructor parametrizado; valida el nombre y la cantidad de días (> 0), asignando valores por defecto si son inválidos, e inicializa en -300.0
getNombreEstacion()	Devuelve el nombre identificador de la estación.
getNumeroDias()	Devuelve la capacidad total de días registrados en el arreglo.
registrarTemperatura(int, double)	Almacena la temperatura en el índice indicado si este es válido (0 a N-1) y la lectura está en el rango [-90.0, 60.0].
obtenerTemperatura(int)	Consulta y devuelve la temperatura de un día específico, o -300.0 si el índice está fuera de rango.
calcularPromedio()	Calcula y devuelve el promedio aritmético de todas las temperaturas registradas en grados Celsius.
obtenerMaxima()	Recorre el arreglo y devuelve la temperatura máxima registrada.
contarDiasCalurosos(double)	Cuenta y devuelve cuántos días superan estrictamente un umbral de temperatura dado.
toString()	Genera una cadena resumen con el nombre de la estación, total de días, promedio y temperatura máxima.
convertirAFahrenheit(double)	Método estático de utilidad que convierte una temperatura de grados Celsius a Fahrenheit.
calcularPromedio(Escala)	Método sobrecargado que devuelve el promedio en CELSIUS o FAHRENHEIT según la escala solicitada.
buscarPrimerDiaHelada()	Busca y devuelve el índice del primer día con temperatura menor o igual a 0.0 °C, o -1 si no hubo heladas.
mayorCambioConsecutivo()	Calcula la mayor diferencia absoluta.

>

---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
<javac src/*java -d bin>
```

### 2. Ejecución de las pruebas
```bash
<java -cp bin PruebaEstacionMeteorologica>
```

### 3. Generación de documentación Javadoc
```bash
<javadoc -d docs src/*.java>
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final de pruebas y la salida de tu prueba personalizada al ejecutar `PruebaEstacionMeteorologica`:

```text
================================================================================
  ICC 2027-1 | VERIFICACION AUTOMATIZADA: ESTACION METEOROLOGICA (MINI-LAB 10)
================================================================================

>>> 1. PROBANDO CONSTRUCTORES, INICIALIZACION Y ACCESO SEGURO:
  [OK] Constructor por omision asigna "Estacion UNAM" y 7 dias
  [OK] Constructor por omision inicializa las casillas en -300.0 (sin lectura)
  [OK] Constructor con parametros valida nombre null y numDias <= 0 (usa 7)
  [FALLO] registrarTemperatura guarda valor valido en [0] y mantiene sin captura [5] en -300.0 (Obtenido [0]=-300.0, [5]=-300.0)
  [OK] registrarTemperatura rechaza indices fuera de rango (-1 y 10)
  [OK] registrarTemperatura rechaza lecturas fuera de [-90.0, 60.0]
  [OK] obtenerTemperatura devuelve -300.0 en indices fuera de rango (-1 y 10)

>>> 2. PROBANDO ESTADISTICAS BASICAS Y toString():
  [OK] obtenerTemperatura(3) coincide con el ejemplo de la tabla (23.0)
  [OK] calcularPromedio de {18.5, 21.0, 19.5, 23.0, 17.0} es 19.8
  [OK] obtenerMaxima de {18.5, 21.0, 19.5, 23.0, 17.0} es 23.0
  [OK] obtenerMaxima funciona cuando TODAS las lecturas son negativas (-3.2)
  [OK] contarDiasCalurosos(> 20.0) en CU-UNAM devuelve 2
  [OK] contarDiasCalurosos(> 30.0) devuelve 0 cuando ninguno supera el umbral
  [OK] toString() devuelve el resumen estadistico exacto

>>> 3. PROBANDO CONVERSION A FAHRENHEIT Y ESCALAS:
  [OK] convertirAFahrenheit(0.0) devuelve 32.0 y convertirAFahrenheit(20.0) devuelve 68.0

>>> 4. PROBANDO RETOS (HELADA Y VARIACION CONSECUTIVA):
  [OK] buscarPrimerDiaHelada en {12.0, 4.5, 0.0, -2.5, 3.0} devuelve indice 2
  [OK] buscarPrimerDiaHelada devuelve -1 si no hubo temperaturas <= 0.0
  [OK] mayorCambioConsecutivo en {18.0, 20.0, 11.5, 15.0, 22.0} es 8.5
  [OK] mayorCambioConsecutivo detecta el mayor cambio en el ultimo par (13.0)
  [OK] mayorCambioConsecutivo con 1 solo dia devuelve 0.0 sin excepcion

================================================================================
  RESUMEN DE PRUEBAS: 19 / 20 pruebas superadas con exito.
================================================================================

>>> 5. PRUEBA PERSONALIZADA:
Estacion: Guajardo | Dias: 6 | Promedio: 11.333333333333334 C | Maxima: 35.0 C
```

---

## Preguntas de reflexión (1.0 punto)

1. **En la Parte 3.2 definiste el método `convertirAFahrenheit(double celsius)`. ¿Lo implementaste como método de instancia o como método de clase (`static`)? Justifica tu decisión de diseño explicando qué ventajas o implicaciones tiene la opción que elegiste.**
   > Lo implemeté como static, la razón de diseño es que la conversión de unidades no requiere obtener valores de algún objeto creado, lo único que necesitamos es el dato pasado como parámetro.

2. **En el método `obtenerMaxima()`, ¿por qué es incorrecto inicializar la variable auxiliar del máximo en `0.0`? Explica qué problema concreto ocurre en estaciones donde todas las temperaturas son negativas y cómo lo resolviste.**
   > No se puede inicializar la variable en 0.0 por el simple hecho de que existen temperaturas negativas hasta -300, entonces tienes que abarcar todo el abanico de posibilidades que puedan llegar a necesitar en la Estación. Por lo que la variable debe iniciarse como -300.

3. **Sobre la Parte 4 (Retos) y el manejo de días sin lectura (`-300.0`): explica brevemente cómo diseñaste la lógica de alguno de los dos retos (o qué limitaciones tendría calcular el promedio de la Parte 2 si un usuario consulta el promedio cuando solo se han registrado algunos días del arreglo).**
   > Implemeté condiciones que filtraban los valores que eran iguales a -300, en todos los métodos en dond ese tenga que ir elemento por elemento y se haga algún análisis estadístico, es necesario eliminar de la ecuación los elementos vacíos porque afectan el cómputo final.

---

## Comentarios adicionales sobre tu experiencia

Agrega aquí cualquier observación pertinente sobre el desarrollo de la práctica (por ejemplo: qué partes te costaron más trabajo, en dónde te atoraste o si algún caso específico no lograste resolver).
> Me cuesta trabajo todavía entender la utilidad de los métodos sobrecargados.
