# LlamadoFuncionesBD
Taller 6 : Trabajemos en clase con Oracle y Spring Boot


## Función Calculo Factorial
Para hacer la petición desde postman se debe agregar en la ruta de URL "factorial/'numero'" 
(Ej. http://localhost:8080/factorial/10)
```
create or replace function calcular_factorial(
 numero in number)
return number 
is 
factorial number;
begin
    IF numero = 0 then 
        return 1;
    else 
        factorial := numero * calcular_factorial(numero-1);
        return factorial;
    end if;
end;
```

## Función Calculo Máximo Común Divisor

Para hacer la petición desde postman se debe agregar en la ruta de URL "mcd/'num_a'/'num_b'" 
(Ej. http://localhost:8080/mcd/48/60)

```
create or replace function maximo_comun_divisor( a in number, b in number)
return number
is
divisor number := a;
dividendo number := b;

temporal number := 0;

begin
    while dividendo != 0 loop
        temporal := dividendo;
        dividendo := mod(divisor,dividendo);
        divisor := temporal;
    end loop;

    return divisor;
end;
```

## Función Verificador de Número Primo

Para hacer la petición desde postman se debe agregar en la ruta de URL "primo/'numero'" 
(Ej. http://localhost:8080/primo/60)

```
create or replace FUNCTION es_primo (numero IN NUMBER)
RETURN varchar2
IS
BEGIN
    IF numero <= 1 THEN
        RETURN numero || ' NO es primo';
    END IF;

    IF numero = 2 THEN
        RETURN numero || ' SI es primo';
    END IF;

    IF MOD(numero, 2) = 0 THEN
        RETURN numero || ' NO es primo';
    END IF;

    FOR i IN 3..FLOOR(SQRT(numero)) LOOP
        IF MOD(numero, i) = 0 THEN
            RETURN numero || ' NO es primo';
        END IF;
    END LOOP;

    RETURN numero || ' SI es primo';
END;
```

## Función Serie Fibonacci

Para hacer la petición desde postman se debe agregar en la ruta de URL "fibonacci/'numero'" 
(Ej. http://localhost:8080/fibonacci/7)

```
create or replace function fibonacci (numero in number )
return number
is
   fib number; 
begin
    if numero = 0 then 
        return 0;
    end if;
    if numero = 1 then
        return 1;
    else 
        fib := fibonacci(numero-1) + fibonacci(numero-2);
    end if;
    return fib;
end;
```
## Procedimiento Almacenado Actualizar Precio Producto

Para hacer la petición desde postman se debe agregar en la ruta de URL los parametros codigo y precio "actualizar-precio?codigo='cod'&precio='numero'" 
(Ej. http://localhost:8080/actualizar-precio?codigo=P0002&precio=150)

```
create or replace PROCEDURE actualizar_precio_producto (
    p_cod_producto IN CHAR,      
    p_precio_unitario IN NUMBER    
)
IS
BEGIN
    UPDATE productos
    SET precio_unitario = p_precio_unitario
    WHERE cod_producto = p_cod_producto;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El producto no existe o el código es incorrecto.');
    ELSE
        COMMIT;
    END IF;
END;
```