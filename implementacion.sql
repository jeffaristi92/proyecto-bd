CREATE TABLE Cliente (idCliente VARCHAR(10) PRIMARY KEY,
		      nombreCliente  VARCHAR(30) NOT NULL,
		      apellidoCliente VARCHAR(30) NOT NULL,
		      direccionCliente VARCHAR(30) NOT NULL,
		      telefonoCliente VARCHAR(15) NOT NULL,
		      saldoCliente DOUBLE PRECISION NOT NULL);

CREATE TABLE  Empleado (idEmpleado VARCHAR(10) PRIMARY KEY,
		       nombreEmpleado  VARCHAR(30) NOT NULL,
		       apellidoEmpleado VARCHAR(30) NOT NULL,
		       direccionEmpleado VARCHAR(30) NOT NULL,
		       telefonoEmpleado VARCHAR(15) NOT NULL,
		       cargoEmpleado VARCHAR(30) NOT NULL);
   
CREATE TABLE Proveedor (idProveedor VARCHAR(30) PRIMARY KEY,
			nombreProveedor  VARCHAR(30) NOT NULL,
			direccionProveedor VARCHAR(30) NOT NULL,
			telefonoProveedor VARCHAR(30) NOT NULL,
			saldoPorveedor DOUBLE PRECISION NOT NULL);
        
CREATE TABLE Producto (IdProducto VARCHAR(10) PRIMARY KEY,
		       descripcion VARCHAR(100) NOT NULL,
		       precioCompra DOUBLE PRECISION NOT NULL,
		       precioVenta DOUBLE PRECISION NOT NULL,
		       cantDisponible INT NOT NULL,
		       idProveedor VARCHAR(10) REFERENCES Proveedor (idProveedor));
       
CREATE TABLE  Venta (idVenta VARCHAR(10) PRIMARY KEY ,
		     idEmpleado VARCHAR(10) NOT NULL REFERENCES Empleado(idEmpleado),
		     idCliente VARCHAR(10) NOT NULL REFERENCES Cliente(idCliente),
		     fechaVenta DATE NOT NULL,
		     vlrTotal DOUBLE PRECISION NOT NULL,
		     saldoVenta DOUBLE PRECISION NOT NULL);

CREATE TABLE  ItemVenta (nroItem VARCHAR(10) NOT NULL,
			 idVenta VARCHAR(10) NOT NULL REFERENCES Venta(idVenta),
			 idProducto VARCHAR(10) NOT NULL REFERENCES Producto(idProducto),
			 cantidad INT CHECK (cantidad>0) NOT NULL,
			 iva DOUBLE PRECISION NOT NULL,
			 vlrTotal DOUBLE PRECISION NOT NULL,
			 PRIMARY KEY (nroItem,idVenta));

CREATE TABLE PagoCliente (nroPago INT NOT NULL,
			  idVenta VARCHAR(10) NOT NULL REFERENCES Venta(idVenta),
			  fechaPago DATE NOT NULL,
			  monto DOUBLE PRECISION NOT NULL,
			  idEmpleado VARCHAR(10) NOT NULL REFERENCES Empleado(idEmpleado),
			  PRIMARY KEY (nroPago,idVenta));
         
CREATE TABLE  Devolucion (idDevolucion VARCHAR(10) NOT NULL,
			  nroItem VARCHAR(10) NOT NULL,
			  idVenta VARCHAR(10) NOT NULL,
			  motivo VARCHAR(300) NOT NULL,
			  cantidad INT CHECK(cantidad>0) NOT NULL, 
			  fechaDevolucion DATE NOT NULL,
			  PRIMARY KEY (idDevolucion,idVenta,nroItem),
			  FOREIGN KEY (nroItem,idVenta) REFERENCES ItemVenta (nroItem,idVenta));
          
CREATE TABLE  Compra (idCompra VARCHAR(10) PRIMARY KEY,
		      idProveedor VARCHAR(10) REFERENCES Proveedor (idProveedor),
		      idEmpleado VARCHAR(10) NOT NULL REFERENCES Empleado(idEmpleado),
		      fechaCompra DATE NOT NULL,
		      vlrTotal DOUBLE PRECISION NOT NULL,
		      saldoCompra DOUBLE PRECISION NOT NULL);

CREATE TABLE  ItemCompra (nroItem VARCHAR(10) NOT NULL,
			 idCompra VARCHAR(10) NOT NULL REFERENCES Compra(idCompra),
			 idProducto VARCHAR(10) NOT NULL REFERENCES Producto(idProducto),
			 cantidad INT CHECK (cantidad>0) NOT NULL,
			 vlrTotal DOUBLE PRECISION NOT NULL,
			 PRIMARY KEY (nroItem,idCompra));

CREATE TABLE PagoProveedor (nroPago INT NOT NULL,
			  idCompra VARCHAR(10) NOT NULL REFERENCES Compra(idCompra),
			  fechaPago DATE NOT NULL,
			  monto DOUBLE PRECISION NOT NULL,
			  idEmpleado VARCHAR(10) NOT NULL REFERENCES Empleado(idEmpleado),
			  PRIMARY KEY (nroPago,idCompra));