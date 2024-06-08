-- 1. Listar el nombre de una sucursal y su equipo de trabajo en base a su id.
SELECT
    S.nombre AS Sucursal,
    C.nombre AS Nombre_Trabajador,
    C.primerApellido AS Primer_Apellido,
    C.segundoApellido AS Segundo_Apellido
FROM
    SUCURSAL S
JOIN
    COLABORADOR C ON S.idSucursal = C.idSucursal
WHERE
    S.idSucursal = 1; -- ID sucursal 1, cambiar por la que se requiera.

-- 2. Listar el nombre de cada jefe de sucursal en base al id de la sucursal. Considérese que el
-- campo rol de la tabla COLABORADOR cuando es 1 corresponderá al jefe de la sucursal y
-- cuando es 0 al resto de los colaboradores.
SELECT
    S.idSucursal,
    S.nombre AS NombreSucursal,
    C.nombre AS NombreJefe,
    C.primerApellido AS PrimerApellidoJefe,
    C.segundoApellido AS SegundoApellidoJefe
FROM
    SUCURSAL S
JOIN
    COLABORADOR C ON S.idSucursal = C.idSucursal
WHERE
    C.rol = 1 AND S.idSucursal = 1; -- ID sucursal 1, cambiar por la que se requiera.

-- 3. Listar todos los clientes que se les ha realizado una venta en una determinada sucursal.
-- Considerar el id de sucursal para filtrar la información(en el ejemplo se tomó el id de
-- sucursal 1).
SELECT
    C.nombre AS Nombre_Cliente,
    C.primerApellido,
    C.segundoApellido,
    S.nombre AS NombreSucursal
FROM
    VENTA V
JOIN
    CLIENTE C ON V.rutCliente = C.rutCliente
JOIN
    SUCURSAL S ON V.idSucursal = S.idSucursal
WHERE
    V.idSucursal = 1; -- ID sucursal 1, cambiar por la que se requiera.

-- 4. Listar la disponibilidad de productos para una sucursal determinada entregando como
-- información el nombre de la sucursal, el nombre del producto y el stock
SELECT
    S.nombre AS Nombre_Sucursal,
    P.nombreProducto AS NombreProducto,
    ST.stock AS Stock
FROM
    stock ST
JOIN
    SUCURSAL S ON ST.idSucursal = S.idSucursal
JOIN
    PRODUCTO P ON ST.idProducto = P.idProducto
WHERE
    S.idSucursal = 5; -- ID sucursal 1, cambiar por la que se requiera.

-- 5. Agrupar la cantidad de ventas que se han realizado a los clientes en una sucursal
-- determinada, mostrando el stock, el nombre del cliente y la sucursal , estableciendo el
-- orden de forma descendiente por la cantidad de ventas de los 10 clientes
SELECT
    COUNT(V.idVenta) AS CantidadVentas,
    C.nombre AS NombreCliente,
    C.primerApellido,
    C.segundoApellido,
    S.nombre AS NombreSucursal
FROM
    VENTA V
JOIN
    CLIENTE C ON V.rutCliente = C.rutCliente
JOIN
    SUCURSAL S ON V.idSucursal = S.idSucursal
GROUP BY
    C.rutCliente, C.nombre, C.primerApellido, C.segundoApellido, S.nombre
ORDER BY
    CantidadVentas DESC
LIMIT 10; -- Se puede cambiar el límite de 10 a la cantidad deseada.