package client;

public class Client {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int puntos;

    public Client(String nombre, String primerApellido, String segundoApellido, int puntos) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.puntos = puntos;
    }

    public String getNivelFidelizacion(int puntos) {
        if (puntos >= 6001) {
            return "Gold";
        } else if (puntos >= 3001) {
            return "Silver";
        } else if (puntos >= 500) {
            return "Inicial";
        } else {
            return "No Aplica";
        }
    }

    public String getBeneficios() {
        String nivel = this.getNivelFidelizacion(this.puntos);
        return switch (nivel) {
            case "Gold" ->
                    "· 1 regalo cada 2 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.\n· Regalo especial 1 vez al mes.";
            case "Silver" -> "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.";
            case "Inicial" -> "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 10% de descuento.";
            default -> "No tiene beneficios.";
        };
    }
}
