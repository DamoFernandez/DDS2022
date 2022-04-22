//hacer todos los imports necesario


public main(){

    const TipoPrenda zapatos = new TipoPrenda("Zapatos", CategoriaPrenda.Calzado);
    const Prenda zapatosRojos = new Prenda(zapatos,Material.Cuero,Color.Rojo);

    const Prenda zapatosNegroYBlanco = new Prenda(zapatos,Material.Cuero,Color.Negro,Color.Blanco);

    const Prenda zapatoSinTipo = new Prenda(null,Material.Cuero,Color.Rojo); //Aca espero una excepcion del FaltaTipoException
    const Prenda zapatoSinMaterial = new Prenda(zapatos,nullo,Color.Rojo); //Aca espero una excepcion del FaltaMaterialException
    const Prenda zapatoSinColor = new Prenda(zapatos,Material.Cuero,null); //Aca espero una excepcion del FaltaColorPrincipalException
    
    
}