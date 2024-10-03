# LlamadoFuncionesBD
Taller 6 : Trabajemos en clase con Oracle y Spring Boot
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