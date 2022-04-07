

// Requerimientos:
// -Poder generar una Venta, la cual debe contener, fecha, prendas, cantidad de cada prenda, metodo de pago y poder calcular el interes correspondiente segun el mismo, 
// como tambien el descuento correspondiente segun la prenda.
// -Poder Calcular los descuentos
// -Poder Calcular los intereses con tarjeta de Credito
// -Poder Consultar todas las ganancias de una determinada fecha

Int coeficienteFijo = settings.coeficienteFijo(); // asumo que voy a tener un settings file donde pueda conseguir este coeficiente fijo

Class Usuario(){
    String nombre;
    Int dni;
    String direccion;
}

Class Prenda(){
    Int id;
    String nombre;
    Int precio;
    Tipo tipo;
    EstadoPrenda estado;
    Float descuento; //Aca estoy asumiendo que puedo pedirle al usuario que ingrese el descuento 
                    // como valor decimal, sino tendria que convertir el valor entero a decimal en el metodo calcularDescuento()
}

Class Venta(){
    Int id;
    Item[] prendas;
    Date fecha;
    Int montoTotal;
    TipoVenta metodoPago;
    Usuario comprador;
}

Class Item(){
    Prenda prenda;
    Int cantidad;
}

Enum Tipo{
    1 Saco;
    2 Pantalon;
    3 Camia;
}

Enum EstadoPrenda {
    1 Nuevo;
    2 Promocion;
    3 Liquidacion;
}

Class TipoVenta{
    int cantidadDeCuotas;
}

TipoVenta Tarjeta(cuotas){
    cantidadDeCuotas = cuotas;
}

TipoVenta Efectivo(0){
}

calcularPrecio(prenda, medioDePago){

    descuento = calcularDescuento(prenda)
    precio = prenda.precio * descuento;

    return precio;
}

calcularDescuento(prenda){
    switch(prenda.estado){
        case Promocion: return prenda.descuento;
            break;
        case Liquidacion: return 0.5;
            break;
        case Nuevo:
        case default: return 0;
            break;
    }
}

crearVenta(Usuario usuario, Item items,TipoVenta medioDePago){
    int subMonto;
    int interes;
    let venta = new Venta();

    venta.prendas = items;
    venta.fecha = Date.Today();
    venta.comprador = usuario;
    venta.TipoVenta = medioDePago;

    venta.prendas.foreach(item => subMonto+= (calcularPrecio(item.prenda) * item.cantidad))
    interes = calcularInteresCuotas(venta);
    
    venta.montoTotal = subMonto + interes;

    db.postVenta(venta); //codigo simplificado para insertar venta en la DB
    return venta;
}

calcularInteresCuotas(Venta venta){
    int interes = 0;
    venta.prendas.foreach(x => interes+= (venta.metodoPago.cantidadDeCuotas * coeficienteFijo + (x.prenda.precio * 0.01 * x.cantidad)));

    return interes;
}

getVentasByFecha(Date fecha){
    ventas = db.GetByFecha(fecha); //codigo simplificado para conseguir ventas segun fecha desde la DB

    return ventas;
}

calcularGananciasByFecha(Date fecha){
    ventas = getVentasByFecha(Date fecha);

    int ganancias = 0;
    ventas.foreach(venta => ganancias+= venta.montoTotal);

    return ganancias;
}