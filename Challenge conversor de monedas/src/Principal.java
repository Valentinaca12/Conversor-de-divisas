import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        DivisasMap divisasMap = new DivisasMap();

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - USD (Dólar)
                    2 - ARS (Peso argentino)
                    3 - BLR (Real brasileño)
                    4 - COP (Peso colombiano)
                    5 - CLP (Peso chileno)
                    6 - EUR (Euro)
                                        
                    0 - Salir
                    """;

            System.out.println("*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*");
            System.out.println("¡BIENVENID@ AL CONVERSOR DE DIVISAS!");
            System.out.println("*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*\n");

            System.out.println("Por favor, ingrese la opción que desea convertir:");
            System.out.println(menu);
            var base = teclado.nextLine();
            base = divisasMap.getAbreviatura(base);

            if (!base.equals("Salir")) {
                System.out.println("Usted ha elegido: " + base + "\n");

                System.out.println("Ahora, por favor ingrese la divisa a la que desea hacer la conversión de " + base + ":");
                System.out.println(menu);
                var objetivo = teclado.nextLine();

                objetivo = divisasMap.getAbreviatura(objetivo);

                if (!objetivo.equals("Salir")) {
                    System.out.println("Por último, ingrese el monto que desea convertir:");

                    var monto = teclado.nextLine();

                    Divisas divisas = consulta.setDivisa(base, objetivo, monto);
                    System.out.println("*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*");
                    System.out.printf("La conversión de %s %s equivale a %.2f %s \n", monto, base, divisas.conversion_result(), objetivo);
                    System.out.println("*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°*°* \n");

                }else {
                    System.out.println("El programa ha finalizado, gracias por usar nuestros servicios");
                    break;
                }
            }else {
                System.out.println("El programa ha finalizado, gracias por usar nuestros servicios");
                break;
            }
        }
    }
}

