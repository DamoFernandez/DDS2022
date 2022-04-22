// hacer imports de los enums necesarios;

Public Class Prenda(){
    TipoPrenda tipo;
    Material material;
    Color colorPrinciapl;
    Color colorSecundario;

    constructor(tipo, material, color){

        if(tipo == null) throw new FaltaTipoException();
        if(material == null) throw new FaltaMaterialException();
        if(color == null) throw new FaltaColorPrincipalException();

        this.tipo = tipo;
        this.material = material;
        this.colorPrinciapl = color;
        this.colorSecundario = null;
    }

    constructor(tipo, material, colorPrinciapl, colorSecundario){

        if(tipo == null) throw new FaltaTipoException();
        if(material == null) throw new FaltaMaterialException();
        if(colorPrinciapl == null) throw new FaltaColorPrincipalException();
        if(colorSecundario == null) throw new FaltaColorSecundarioException();

        this.tipo = tipo;
        this.material = material;
        this.colorPrinciapl = colorPrinciapl;
        this.colorSecundario = colorSecundario;
    }
}

Public class PrendasException extends Exception(){
     
    Public FaltaTipoException(){
        Super("falta Tipo de la prenda")
    }

    Public FaltaMaterialException(){
        Super("falta material de la prenda")
    }
    
    Public FaltaColorPrincipalException(){
        Super("falta color principal de la prenda")
    }

    Public FaltaColorSecundarioException(){
        Super("falta color secundario de la prenda")
    }
}

Prenda remeraMangasCortasAzul = new 