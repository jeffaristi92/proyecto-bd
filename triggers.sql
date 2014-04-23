/*trigger para actualizar saldo de cliente*/

create trigger nvaVenta
after insert on venta
for each row
execute procedure actualizarSaldoClienteV();


create trigger nvoPagoCliente
after insert on PagoCliente
for each row
execute procedure actualizarSaldoClienteP();


/*trigger para actualizar saldo de proveedor*/


create trigger nvaCompra
after insert on Compra
for each row
execute procedure actualizarSaldoProveedorC();


create trigger nvoPagoProveedor
after insert on PagoProveedor
for each row
execute procedure actualizarSaldoProveedorP();


/*trigger para actualizar cantidad disponible de productos*/

create trigger nvoItemVenta
after insert on ItemVenta
for each row
execute procedure actualizarCantDispProductoV();

create trigger nvoItemCompra
after insert on ItemCompra
for each row
execute procedure actualizarCantDispProductoC();
