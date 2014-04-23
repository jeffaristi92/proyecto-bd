/*Funciones para clientes*/

create or replace function actualizarSaldoClienteV() returns trigger as'
begin
update Cliente set saldoCliente = saldoCliente + NEW.vlrTotal where idCliente = NEW.idCliente;
return NEW;
end'
language 'plpgsql';

create or replace function actualizarSaldoClienteP() returns trigger as'
begin
update Cliente set saldoCliente = saldoCliente - NEW.monto where idCliente in (select idCliente 
									      from venta 
									      where NEW.idVenta = venta.idVenta);
update Venta set saldoVenta = saldoVenta - NEW.monto where idVenta = NEW.idVenta;
return NEW;
end'
language 'plpgsql';

/*Funciones para proveedores*/

create or replace function actualizarSaldoProveedorC() returns trigger as'
begin
update Proveedor set saldoProveedor = saldoProveedor + NEW.vlrTotal where idProveedor = NEW.idProveedor;
return NEW;
end'
language 'plpgsql';

create or replace function actualizarSaldoProveedorP() returns trigger as'
begin
update Proveedor set saldoProveedor = saldoProveedor - NEW.monto where idProveedor in (select idProveedor
										      from compra
										      where NEW.idCompra = compra.idCompra);
update Compra set saldoCompra = saldoCompra - NEW.monto where idCompra = NEW.idCompra;
return NEW;
end'
language 'plpgsql';


/*Funciones para productos*/

create or replace function actualizarCantDispProductoV() returns trigger as'
begin
   update Producto set cantDisponible = cantDisponible - NEW.cantidad where idProducto = NEW.idProducto;
return NEW;
end'
language 'plpgsql';

create or replace function actualizarCantDispProductoC() returns trigger as'
begin
   update Producto set cantDisponible = cantDisponible + NEW.cantidad where idProducto = NEW.idProducto;
return NEW;
end'
language 'plpgsql';