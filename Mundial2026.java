import java.util.Scanner;

public class Mundial2026 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== COLORES ANSI =====
        String RESET   = "\u001B[0m";
        String VERDE   = "\u001B[32m";
        String AZUL    = "\u001B[34m";
        String AMARILLO= "\u001B[33m";
        String ROJO    = "\u001B[31m";
        String CYAN    = "\u001B[36m";
        String MAGENTA = "\u001B[35m";
        String BLANCO  = "\u001B[37m";

        String BG_BLACK  = "\u001B[40m";
        String BG_RED    = "\u001B[41m";
        String BG_GREEN  = "\u001B[42m";
        String BG_YELLOW = "\u001B[43m";
        String BG_BLUE   = "\u001B[44m";
        String BG_MAGENTA= "\u001B[45m";
        String BG_CYAN   = "\u001B[46m";
        String BG_WHITE  = "\u001B[47m";

        // ===== GRUPOS =====
        String[] grupos = {"A","B","C","D","E","F","G","H","I","J","K","L"};

        String[][] paisesPorGrupo = {
            {"Mexico","Sudafrica","Corea","Chequia"},
            {"Canada","Bosnia","Qatar","Suiza"},
            {"Brasil","Marruecos","Haiti","Escocia"},
            {"EEUU","Paraguay","Australia","Turquia"},
            {"Alemania","Curazao","Costa de Marfil","Ecuador"},
            {"Paises Bajos","Japon","Suecia","Tunez"},
            {"Belgica","Egipto","Iran","Nueva Zelanda"},
            {"Espana","Cabo Verde","Arabia Saudita","Uruguay"},
            {"Francia","Senegal","Irak","Noruega"},
            {"Argentina","Argelia","Austria","Jordania"},
            {"Portugal","RD Congo","Uzbekistan","Colombia"},
            {"Inglaterra","Croacia","Ghana","Panama"}
        };

  
