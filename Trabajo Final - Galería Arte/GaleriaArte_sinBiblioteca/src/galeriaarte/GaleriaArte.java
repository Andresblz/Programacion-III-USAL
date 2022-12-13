package galeriaarte;

import view.View;

public class GaleriaArte {
    public static void main(String[] args) {
        String[] menu = new String[4];
        StringBuilder sb = new StringBuilder();
        
        /*
         * Main menu
         */
        sb.append("\nMENU PRINCIPAL:")
                .append("\n\t1.- Archivos")
                .append("\n\t2.- Gestión de la galería")
                .append("\n\t3.- Listados")
                .append("\n\t4.- Salir del programa")
                .append("\n(1, 2, 3, 4) ? ");
        menu[0] = sb.toString();
        
        /*
         * Files menu
         */
        sb.setLength(0);
        sb.append("\nARCHIVOS:")
                .append("\n\ta.- Importar CSV")
                .append("\n\tb.- Exportar CSV")
                .append("\n\tc.- Exportar HTML")
                .append("\n\tq.- Volver al menú principal")
                .append("\n(a, b, c, q) ? ");
        menu[1] = sb.toString();
        
        /*
         * Gallery management menu
         */
        sb.setLength(0);
        sb.append("\nGESTIÓN DE LA GALERÍA:")
                .append("\n\ta.- Añadir una figura al inventario")
                .append("\n\tb.- Consultar datos de una figura")
                .append("\n\tc.- Modificar datos de una figura")
                .append("\n\td.- Eliminar una figura del inventario")
                .append("\n\tq.- Volver al menú principal")
                .append("\n(a, b, c, d, q) ? ");
        menu[2] = sb.toString();
        
        /*
         * List menu
         */
        sb.setLength(0);
        sb.append("\nLISTADOS:")
                .append("\n\ta.- Listado por identificador")
                .append("\n\tb.- Listado por año e identificador")
                .append("\n\tc.- Listado por fabricante y año")
                .append("\n\tq.- Volver al menú principal")
                .append("\n(a, b, c, q) ? ");
        menu[3] = sb.toString();
    
        View v = new View();
        v.importBinaryFile();
        v.runMenu(menu);
    }
}
