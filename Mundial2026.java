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

        // ===== EQUIPOS (para tabla) =====
        String[] equipos = {
            "Mexico","Sudafrica","Corea","Chequia",
            "Canada","Bosnia","Qatar","Suiza",
            "Brasil","Marruecos","Haiti","Escocia",
            "EEUU","Paraguay","Australia","Turquia",
            "Alemania","Curazao","Costa de Marfil","Ecuador",
            "Paises Bajos","Japon","Suecia","Tunez",
            "Belgica","Egipto","Iran","Nueva Zelanda",
            "Espana","Cabo Verde","Arabia Saudita","Uruguay",
            "Francia","Senegal","Irak","Noruega",
            "Argentina","Argelia","Austria","Jordania",
            "Portugal","RD Congo","Uzbekistan","Colombia",
            "Inglaterra","Croacia","Ghana","Panama"
        };

        // PJ, PG, PE, PP, GF, GC, DG, TA, TR, PTS
        int[][] tabla = new int[48][10];

        // ===== FIXTURE (Fecha 1) =====
        String[][] fixture = {
            {"Grupo A","Mexico vs Sudafrica","20 de Junio","14:00","Inter Miami Stadium"},
            {"Grupo A","Corea vs Chequia","20 de Junio","18:00","Inter Miami Stadium"},
            {"Grupo B","Canada vs Bosnia","21 de Junio","14:00","Toronto Stadium"},
            {"Grupo B","Qatar vs Suiza","21 de Junio","18:00","Toronto Stadium"},
            {"Grupo C","Brasil vs Marruecos","22 de Junio","14:00","Maracana Stadium"},
            {"Grupo C","Haiti vs Escocia","22 de Junio","18:00","Maracana Stadium"},
            {"Grupo D","EEUU vs Paraguay","23 de Junio","14:00","Dallas Stadium"},
            {"Grupo D","Australia vs Turquia","23 de Junio","18:00","Dallas Stadium"},
            {"Grupo E","Alemania vs Curazao","24 de Junio","14:00","Berlin Stadium"},
            {"Grupo E","Costa de Marfil vs Ecuador","24 de Junio","18:00","Berlin Stadium"},
            {"Grupo F","Paises Bajos vs Japon","25 de Junio","14:00","Amsterdam Stadium"},
            {"Grupo F","Suecia vs Tunez","25 de Junio","18:00","Amsterdam Stadium"},
            {"Grupo G","Belgica vs Egipto","26 de Junio","14:00","Brussels Arena"},
            {"Grupo G","Iran vs Nueva Zelanda","26 de Junio","18:00","Brussels Arena"},
            {"Grupo H","Espana vs Cabo Verde","27 de Junio","14:00","Madrid Stadium"},
            {"Grupo H","Arabia Saudita vs Uruguay","27 de Junio","18:00","Madrid Stadium"},
            {"Grupo I","Francia vs Senegal","28 de Junio","14:00","Paris Stadium"},
            {"Grupo I","Irak vs Noruega","28 de Junio","18:00","Paris Stadium"},
            {"Grupo J","Argentina vs Argelia","29 de Junio","14:00","Monumental Stadium"},
            {"Grupo J","Austria vs Jordania","29 de Junio","18:00","Monumental Stadium"},
            {"Grupo K","Portugal vs RD Congo","30 de Junio","14:00","Lisbon Stadium"},
            {"Grupo K","Uzbekistan vs Colombia","30 de Junio","18:00","Lisbon Stadium"},
            {"Grupo L","Inglaterra vs Croacia","1 de Julio","14:00","Wembley Stadium"},
            {"Grupo L","Ghana vs Panama","1 de Julio","18:00","Wembley Stadium"}
        };

        // ===== INFO PAISES =====
        String[][] infoPaises = {
            {"Mexico","Ciudad de Mexico","Malagon, Sanchez, Montes, Vasquez, Gallardo, Edson Alvarez, Chavez, Antuna, Orbelin, Lozano, Gimenez"},
            {"Sudafrica","Pretoria","Williams, Mudau, Kekana, Mvala, Modiba, Sithole, Mokoena, Tau, Zwane, Appollis, Foster"},
            {"Corea","Seul","Kim Seung-gyu, Seol, Kim Min-jae, Kim Young-gwon, Lee Ki-je, Hwang In-beom, Park Yong-woo, Lee Kang-in, Son, Hwang Hee-chan, Cho Gue-sung"},
            {"Chequia","Praga","Stanek, Coufal, Krejci, Holes, Zeleny, Soucek, Kral, Cerny, Barak, Provod, Schick"},
            {"Canada","Ottawa","Crepeau, Johnston, Bombito, Cornelius, Davies, Eustaquio, Kone, Buchanan, David, Larin, Hoilett"},
            {"Bosnia","Sarajevo","Sehic, Dedic, Ahmedhodzic, Bicakcic, Kolasinac, Pjanic, Krunic, Stevanovic, Demirovic, Dzeko, Hajradinovic"},
            {"Qatar","Doha","Barsham, Miguel, Salman, Khoukhi, Hassan, Hatem, Madibo, Afif, Al-Haydos, Almoez, Ali Assad"},
            {"Suiza","Berna","Sommer, Widmer, Akanji, Schar, Rodriguez, Freuler, Xhaka, Aebischer, Vargas, Embolo, Okafor"},
            {"Brasil","Brasilia","Alisson, Danilo, Marquinhos, Gabriel Magalhaes, Arana, Bruno Guimaraes, Casemiro, Rodrygo, Paqueta, Vinicius, Richarlison"},
            {"Marruecos","Rabat","Bono, Hakimi, Aguerd, Saiss, Mazraoui, Amrabat, Ounahi, Ziyech, Harit, Boufal, En-Nesyri"},
            {"Haiti","Puerto Principe","Placide, Arcus, Ade, Duverne, Christian, Leverton Pierre, Etienne, Nazon, Deedson, Pierrot, Mondesir"},
            {"Escocia","Edimburgo","Gunn, Hendry, Porteous, Tierney, Robertson, McGregor, McGinn, Gilmour, McTominay, Christie, Adams"},
            {"EEUU","Washington D.C.","Turner, Dest, Richards, Ream, Robinson, Adams, McKennie, Musah, Weah, Pulisic, Balogun"},
            {"Paraguay","Asuncion","Coronel, Rojas, Balbuena, Alderete, Alonso, Cubas, Villasanti, Gomez, Almiron, Enciso, Sanabria"},
            {"Australia","Canberra","Ryan, Atkinson, Souttar, Burgess, Bos, Irvine, Baccus, McGree, Boyle, Goodwin, Duke"},
            {"Turquia","Ankara","Cakir, Celik, Demiral, Bardakci, Kadioglu, Yokuslu, Calhanoglu, Guler, Kokcu, Akturkoglu, Yilmaz"},
            {"Alemania","Berlin","Neuer, Kimmich, Rudiger, Tah, Mittelstadt, Andrich, Kroos, Musiala, Gundogan, Sane, Havertz"},
            {"Curazao","Willemstad","Room, Martina, Kongolo, Rosier, Kuwas, Bacuna, Anita, Antonisse, Elson Hooi, Janga, Kastaneer"},
            {"Costa de Marfil","Yamusukro","Fofana, Singo, Ndicka, Diomande, Konan, Kessie, Sangare, Adingra, Pepe, Boga, Haller"},
            {"Ecuador","Quito","Galindez, Preciado, Torres, Hincapie, Estupinan, Moises Caicedo, Gruezo, Sarmiento, Kendry Paez, Plata, Enner Valencia"},
            {"Paises Bajos","Amsterdam","Verbruggen, Dumfries, De Vrij, Van Dijk, Ake, De Jong, Reijnders, Simons, Malen, Gakpo, Depay"},
            {"Japon","Tokio","Suzuki, Sugawara, Tomiyasu, Itakura, Ito, Endo, Morita, Kubo, Kamada, Mitoma, Ueda"},
            {"Suecia","Estocolmo","Olsen, Lustig, Lindelof, Hien, Gudmundsson, Cajuste, Ekdal, Forsberg, Kulusevski, Isak, Elanga"},
            {"Tunez","Tunez","Dahmen, Drager, Talbi, Meriah, Abdi, Laidouni, Skhiri, Achouri, Ben Slimane, Sliti, Jaziri"},
            {"Belgica","Bruselas","Casteels, Castagne, Faes, Vertonghen, Theate, Onana, Tielemans, De Bruyne, Doku, Lukaku, Trossard"},
            {"Egipto","El Cairo","El Shenawy, Hany, Abdelmonem, Hegazi, Hamdi, Elneny, Hamdy Fathy, Trezeguet, Zizo, Salah, Mostafa Mohamed"},
            {"Iran","Teheran","Beiranvand, Moharrami, Hosseini, Kanaani, Rezaeian, Ezatolahi, Ghoddos, Gholizadeh, Jahanbakhsh, Taremi, Azmoun"},
            {"Nueva Zelanda","Wellington","Crocombe, Payne, Boxall, Pijnaker, Cacace, Bell, Garbett, Stamenic, Singh, Greive, Chris Wood"},
            {"Espana","Madrid","Simon, Carvajal, Laporte, Le Normand, Cucurella, Rodri, Fabian, Pedri, Yamal, Morata, Nico Williams"},
            {"Cabo Verde","Praia","Vozinha, Tavares, Stopira, Roberto Lopes, Joao Paulo, Andrade, Monteiro, Bebe, Ryan Mendes, Jovane, Diney"},
            {"Arabia Saudita","Riad","Al-Owais, Abdulhamid, Al-Amri, Lajami, Al-Shahrani, Kanno, Al-Malki, Al-Dawsari, Al-Buraikan, Al-Obud, Al-Shehri"},
            {"Uruguay","Montevideo","Rochet, Nandez, Araujo, Gimenez, Olivera, Ugarte, Valverde, Bentancur, Pellistri, Nunez, De la Cruz"},
            {"Francia","Paris","Maignan, Kounde, Upamecano, Saliba, Theo Hernandez, Tchouameni, Camavinga, Dembele, Griezmann, Mbappe, Thuram"},
            {"Senegal","Dakar","Mendy, Sabaly, Koulibaly, Niakhate, Jakobs, Gueye, Pape Matar Sarr, Camara, Sarr, Ismaila Sarr, Mane"},
            {"Irak","Bagdad","Hassan, Adnan, Al-Hamadi, Ali Faez, Muhanad, Rashid, Iqbal, Ali Jasim, Hameed, Bayesh, Aymen Hussein"},
            {"Noruega","Oslo","Nyland, Ryerson, Ajer, Ostigard, Meling, Berge, Odegaard, Aursnes, Bobb, Sorloth, Haaland"},
            {"Argentina","Buenos Aires","Martinez, Molina, Romero, Otamendi, Tagliafico, De Paul, Enzo, Mac Allister, Messi, Alvarez, Di Maria"},
            {"Argelia","Argel","Mandrea, Atal, Mandi, Bensebaini, Tougai, Bennacer, Zerrouki, Mahrez, Belaili, Gouiri, Slimani"},
            {"Austria","Viena","Schlager, Posch, Danso, Lienhart, Mwene, Laimer, Seiwald, Sabitzer, Baumgartner, Wimmer, Arnautovic"},
            {"Jordania","Amman","Abu Laila, Naser, Al-Arab, Abu Hashish, Haddad, Al-Rashdan, Rawashdeh, Al-Tamari, Olwan, Abu Zraiq, Naimat"},
            {"Portugal","Lisboa","Diogo Costa, Cancelo, Dias, Pepe, Mendes, Palhinha, Bruno Fernandes, Vitinha, Bernardo Silva, Leao, Cristiano Ronaldo"},
            {"RD Congo","Kinsasa","Mpasi, Kalulu, Mbemba, Inonga, Masuaku, Moutoussamy, Pickel, Kakuta, Bongonda, Wissa, Bakambu"},
            {"Uzbekistan","Taskent","Yusupov, Sayfiev, Ashurmatov, Alikulov, Nasrullaev, Hamraliev, Shukurov, Masharipov, Fayzullaev, Urunov, Shomurodov"},
            {"Colombia","Bogota","Camilo Vargas, Munoz, Davinson, Lucumi, Mojica, Lerma, Richard Rios, James, Arias, Luis Diaz, Cordoba"},
            {"Inglaterra","Londres","Pickford, Walker, Stones, Guehi, Shaw, Rice, Bellingham, Foden, Saka, Kane, Gordon"},
            {"Croacia","Zagreb","Livakovic, Stanisic, Sutalo, Gvardiol, Sosa, Modric, Kovacic, Brozovic, Majer, Pasalic, Kramaric"},
            {"Ghana","Acra","Ati-Zigi, Odoi, Djiku, Amartey, Mensah, Partey, Kudus, Salis, Paintsil, Semenyo, Inaki Williams"},
            {"Panama","Ciudad de Panama","Mosquera, Murillo, Escobar, Cordoba, Davis, Carrasquilla, Godoy, Martinez, Barcenas, Fajardo, Ismael Diaz"}
        };

        // ===== BANDERAS (matrices base 6x6 con letras de color) =====
        // K=Black, R=Red, G=Green, Y=Yellow, B=Blue, W=White, C=Cyan, M=Magenta
        String[][][] banderas = {
            // 0 Mexico
            {{"G","G","W","W","R","R"},{"G","G","W","W","R","R"},{"G","G","W","W","R","R"},{"G","G","W","W","R","R"},{"G","G","W","W","R","R"},{"G","G","W","W","R","R"}},
            // 1 Sudafrica
            {{"R","R","R","R","R","R"},{"R","G","G","Y","B","B"},{"K","G","G","Y","B","B"},{"K","G","G","Y","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 2 Corea
            {{"W","W","W","W","W","W"},{"W","W","R","R","W","W"},{"W","R","R","B","B","W"},{"W","B","B","R","R","W"},{"W","W","B","B","W","W"},{"W","W","W","W","W","W"}},
            // 3 Chequia
            {{"W","W","W","W","W","W"},{"B","W","W","W","W","W"},{"B","B","W","W","W","W"},{"B","B","R","R","R","R"},{"B","R","R","R","R","R"},{"R","R","R","R","R","R"}},
            // 4 Canada
            {{"R","R","W","W","R","R"},{"R","R","W","W","R","R"},{"R","R","W","R","R","R"},{"R","R","R","R","W","R"},{"R","R","W","W","R","R"},{"R","R","W","W","R","R"}},
            // 5 Bosnia
            {{"B","B","B","Y","Y","Y"},{"B","B","B","B","Y","Y"},{"B","B","B","B","B","Y"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 6 Qatar
            {{"W","M","M","M","M","M"},{"W","M","M","M","M","M"},{"W","M","M","M","M","M"},{"W","M","M","M","M","M"},{"W","M","M","M","M","M"},{"W","M","M","M","M","M"}},
            // 7 Suiza
            {{"R","R","R","R","R","R"},{"R","R","W","W","R","R"},{"R","W","W","W","W","R"},{"R","R","W","W","R","R"},{"R","R","W","W","R","R"},{"R","R","R","R","R","R"}},
            // 8 Brasil
            {{"G","G","G","G","G","G"},{"G","G","Y","Y","G","G"},{"G","Y","Y","Y","Y","G"},{"G","Y","B","B","Y","G"},{"G","G","Y","Y","G","G"},{"G","G","G","G","G","G"}},
            // 9 Marruecos
            {{"R","R","R","R","R","R"},{"R","R","G","G","R","R"},{"R","G","R","R","G","R"},{"R","G","R","R","G","R"},{"R","R","G","G","R","R"},{"R","R","R","R","R","R"}},
            // 10 Haiti
            {{"B","B","B","B","B","B"},{"B","B","W","W","B","B"},{"B","B","W","W","B","B"},{"R","R","W","W","R","R"},{"R","R","W","W","R","R"},{"R","R","R","R","R","R"}},
            // 11 Escocia
            {{"W","B","B","B","B","W"},{"B","W","B","B","W","B"},{"B","B","W","W","B","B"},{"B","B","W","W","B","B"},{"B","W","B","B","W","B"},{"W","B","B","B","B","W"}},
            // 12 EEUU
            {{"B","B","R","R","R","R"},{"B","B","W","W","W","W"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"}},
            // 13 Paraguay
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 14 Australia
            {{"B","B","B","B","B","B"},{"B","W","B","B","W","B"},{"B","B","B","W","B","B"},{"B","B","W","B","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 15 Turquia
            {{"R","R","R","R","R","R"},{"R","W","W","R","R","R"},{"R","W","R","W","R","R"},{"R","W","R","W","R","R"},{"R","W","W","R","R","R"},{"R","R","R","R","R","R"}},
            // 16 Alemania
            {{"K","K","K","K","K","K"},{"K","K","K","K","K","K"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"}},
            // 17 Curazao
            {{"B","B","B","B","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"},{"Y","Y","Y","Y","Y","Y"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 18 Costa de Marfil
            {{"Y","Y","W","W","G","G"},{"Y","Y","W","W","G","G"},{"Y","Y","W","W","G","G"},{"Y","Y","W","W","G","G"},{"Y","Y","W","W","G","G"},{"Y","Y","W","W","G","G"}},
            // 19 Ecuador
            {{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"B","B","B","B","B","B"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"}},
            // 20 Paises Bajos
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 21 Japon
            {{"W","W","W","W","W","W"},{"W","W","R","R","W","W"},{"W","R","R","R","R","W"},{"W","R","R","R","R","W"},{"W","W","R","R","W","W"},{"W","W","W","W","W","W"}},
            // 22 Suecia
            {{"B","B","Y","B","B","B"},{"B","B","Y","B","B","B"},{"Y","Y","Y","Y","Y","Y"},{"B","B","Y","B","B","B"},{"B","B","Y","B","B","B"},{"B","B","Y","B","B","B"}},
            // 23 Tunez
            {{"R","R","R","R","R","R"},{"R","R","W","W","R","R"},{"R","W","W","W","W","R"},{"R","W","W","W","W","R"},{"R","R","W","W","R","R"},{"R","R","R","R","R","R"}},
            // 24 Belgica
            {{"K","K","Y","Y","R","R"},{"K","K","Y","Y","R","R"},{"K","K","Y","Y","R","R"},{"K","K","Y","Y","R","R"},{"K","K","Y","Y","R","R"},{"K","K","Y","Y","R","R"}},
            // 25 Egipto
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"K","K","K","K","K","K"},{"K","K","K","K","K","K"}},
            // 26 Iran
            {{"G","G","G","G","G","G"},{"G","G","G","G","G","G"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"}},
            // 27 Nueva Zelanda
            {{"B","B","B","B","B","B"},{"B","R","B","B","R","B"},{"B","B","B","R","B","B"},{"B","B","R","B","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 28 Espana
            {{"R","R","R","R","R","R"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"R","R","R","R","R","R"}},
            // 29 Cabo Verde
            {{"B","B","B","B","B","B"},{"B","B","B","B","B","B"},{"W","W","W","W","W","W"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"G","G","G","G","G","G"}},
            // 30 Arabia Saudita
            {{"G","G","G","G","G","G"},{"G","G","G","G","G","G"},{"G","W","W","W","W","G"},{"G","W","W","W","W","G"},{"G","G","G","G","G","G"},{"G","G","G","G","G","G"}},
            // 31 Uruguay
            {{"W","W","W","W","W","W"},{"B","B","B","B","B","B"},{"W","W","W","W","W","W"},{"B","B","B","B","B","B"},{"W","W","W","W","W","W"},{"B","B","B","B","B","B"}},
            // 32 Francia
            {{"B","B","W","W","R","R"},{"B","B","W","W","R","R"},{"B","B","W","W","R","R"},{"B","B","W","W","R","R"},{"B","B","W","W","R","R"},{"B","B","W","W","R","R"}},
            // 33 Senegal
            {{"G","G","Y","Y","R","R"},{"G","G","Y","Y","R","R"},{"G","G","Y","Y","R","R"},{"G","G","Y","Y","R","R"},{"G","G","Y","Y","R","R"},{"G","G","Y","Y","R","R"}},
            // 34 Irak
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"K","K","K","K","K","K"},{"K","K","K","K","K","K"}},
            // 35 Noruega
            {{"R","R","B","R","R","R"},{"R","R","B","R","R","R"},{"B","B","B","B","B","B"},{"R","R","B","R","R","R"},{"R","R","B","R","R","R"},{"R","R","B","R","R","R"}},
            // 36 Argentina
            {{"C","C","C","C","C","C"},{"C","C","C","C","C","C"},{"W","W","W","W","W","W"},{"W","W","Y","Y","W","W"},{"C","C","C","C","C","C"},{"C","C","C","C","C","C"}},
            // 37 Argelia
            {{"G","G","G","W","W","W"},{"G","G","G","W","W","W"},{"G","G","G","W","W","W"},{"G","G","G","W","W","W"},{"G","G","G","W","W","W"},{"G","G","G","W","W","W"}},
            // 38 Austria
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"W","W","W","W","W","W"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"}},
            // 39 Jordania
            {{"K","K","K","K","K","K"},{"W","W","W","W","W","W"},{"G","G","G","G","G","G"},{"R","R","R","G","G","G"},{"R","R","W","W","W","W"},{"R","R","K","K","K","K"}},
            // 40 Portugal
            {{"G","G","R","R","R","R"},{"G","G","R","R","R","R"},{"G","G","R","R","R","R"},{"G","G","R","R","R","R"},{"G","G","R","R","R","R"},{"G","G","R","R","R","R"}},
            // 41 RD Congo
            {{"B","B","Y","R","B","B"},{"B","Y","R","B","B","B"},{"Y","R","B","B","B","B"},{"R","B","B","B","B","B"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 42 Uzbekistan
            {{"B","B","B","B","B","B"},{"W","W","W","W","W","W"},{"R","R","R","R","R","R"},{"W","W","W","W","W","W"},{"G","G","G","G","G","G"},{"G","G","G","G","G","G"}},
            // 43 Colombia
            {{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"Y","Y","Y","Y","Y","Y"},{"B","B","B","B","B","B"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"}},
            // 44 Inglaterra
            {{"W","W","R","R","W","W"},{"W","W","R","R","W","W"},{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","R","R","W","W"},{"W","W","R","R","W","W"}},
            // 45 Croacia
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"W","W","B","B","W","W"},{"W","W","B","B","W","W"},{"B","B","B","B","B","B"},{"B","B","B","B","B","B"}},
            // 46 Ghana
            {{"R","R","R","R","R","R"},{"R","R","R","R","R","R"},{"Y","Y","K","K","Y","Y"},{"Y","Y","K","K","Y","Y"},{"G","G","G","G","G","G"},{"G","G","G","G","G","G"}},
            // 47 Panama
            {{"W","W","R","R","R","R"},{"W","W","R","R","R","R"},{"B","B","W","W","W","W"},{"B","B","W","W","W","W"},{"B","B","W","W","W","W"},{"B","B","W","W","W","W"}}
        };

        // ===== MENU PRINCIPAL =====
        int opcion = -1;

        while (opcion != 0) {

            System.out.println(CYAN +
            "\n ███╗   ███╗██╗   ██╗███╗   ██╗██████╗ ██╗ █████╗ ██╗     " + "\n" +
            " ████╗ ████║██║   ██║████╗  ██║██╔══██╗██║██╔══██╗██║     " + "\n" +
            " ██╔████╔██║██║   ██║██╔██╗ ██║██║  ██║██║███████║██║     " + "\n" +
            " ██║╚██╔╝██║██║   ██║██║╚██╗██║██║  ██║██║██╔══██║██║     " + "\n" +
            " ██║ ╚═╝ ██║╚██████╔╝██║ ╚████║██████╔╝██║██║  ██║███████╗" + "\n" +
            " ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝" + RESET);
            System.out.println(AMARILLO +
            "  ██████╗ ██████╗  ██████╗ ██████╗ " + "\n" +
            " ╚════██╗██╔═████╗╚════██╗██╔════╝ " + "\n" +
            "  █████╔╝██║██╔██║ █████╔╝███████╗ " + "\n" +
            " ██╔═══╝ ████╔╝██║██╔═══╝ ██╔═══██╗" + "\n" +
            " ███████╗╚██████╔╝███████╗╚██████╔╝" + "\n" +
            " ╚══════╝  ╚═════╝ ╚══════╝ ╚═════╝ " + RESET);

            System.out.println(MAGENTA + "\n======= MENU PRINCIPAL =======" + RESET);
            System.out.println(BLANCO + "1. Ver grupos");
            System.out.println("2. Banderas");
            System.out.println("3. Tabla de posiciones");
            System.out.println("4. Fixture");
            System.out.println("5. Informacion de pais");
            System.out.println("0. Salir" + RESET);
            System.out.print(AMARILLO + "Escoge una opcion: " + RESET);

            while (!sc.hasNextInt()) { sc.next(); }
            opcion = sc.nextInt();

            switch (opcion) {

                // ============================================================
                case 1: // VER GRUPOS
                // ============================================================
                    System.out.println(AZUL + "\n===== GRUPOS DEL MUNDIAL =====" + RESET);
                    for (int i = 0; i < grupos.length; i++) {
                        System.out.println(AMARILLO + "\nGRUPO " + grupos[i] + RESET);
                        for (int j = 0; j < paisesPorGrupo[i].length; j++) {
                            System.out.println("  " + (j + 1) + ". " + paisesPorGrupo[i][j]);
                        }
                    }
                    break;

                // ============================================================
                case 2: // BANDERAS
                // ============================================================
                    System.out.println(CYAN + "\n===== MENU BANDERAS =====" + RESET);
                    System.out.println("1. Ver una bandera");
                    System.out.println("2. Ver banderas de un grupo");
                    System.out.println("3. Ver todas las banderas");
                    System.out.print("Escoge una opcion: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    int opBandera = sc.nextInt();

                    System.out.println("\nEscoge el tamano:");
                    System.out.println("1. Icono  (3x9)");
                    System.out.println("2. Pequeno (6x18)");
                    System.out.println("3. Mediano (9x27)");
                    System.out.println("4. Grande  (12x36)");
                    System.out.print("Tu opcion: ");
                    while (!sc.hasNextInt()) { sc.next(); }
                    int tam = sc.nextInt();

                    int filas = 3, cols = 9;
                    if (tam == 2) { filas = 6;  cols = 18; }
                    if (tam == 3) { filas = 9;  cols = 27; }
                    if (tam == 4) { filas = 12; cols = 36; }

                    if (opBandera == 1) {
                        // Pedir grupo y pais
                        for (int i = 0; i < grupos.length; i++) {
                            System.out.println((i + 1) + ". Grupo " + grupos[i]);
                        }
                        System.out.print("Escoge el grupo: ");
                        while (!sc.hasNextInt()) { sc.next(); }
                        int gB = sc.nextInt() - 1;

                        if (gB < 0 || gB >= grupos.length) {
                            System.out.println(ROJO + "Grupo invalido." + RESET);
                            break;
                        }
                        System.out.println("\nEscoge el pais del Grupo " + grupos[gB] + ":");
                        for (int i = 0; i < paisesPorGrupo[gB].length; i++) {
                            System.out.println((i + 1) + ". " + paisesPorGrupo[gB][i]);
                        }
                        System.out.print("Tu opcion: ");
                        while (!sc.hasNextInt()) { sc.next(); }
                        int pB = sc.nextInt() - 1;

                        if (pB < 0 || pB >= paisesPorGrupo[gB].length) {
                            System.out.println(ROJO + "Pais invalido." + RESET);
                            break;
                        }

                        // Buscar indice global del pais
                        String nombrePais = paisesPorGrupo[gB][pB];
                        int idxBandera = -1;
                        for (int i = 0; i < equipos.length; i++) {
                            if (equipos[i].equals(nombrePais)) { idxBandera = i; break; }
                        }

                        if (idxBandera == -1) {
                            System.out.println(ROJO + "Bandera no encontrada." + RESET);
                            break;
                        }

                        // Imprimir bandera escalada
                        System.out.println(AMARILLO + "\nBandera de: " + nombrePais + RESET);
                        String[][] base = banderas[idxBandera];
                        int baseF = base.length;
                        int baseC = base[0].length;

                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < cols; j++) {
                                int fi = (i * baseF) / filas;
                                int ci = (j * baseC) / cols;
                                String ch = base[fi][ci];
                                String color = RESET;
                                if (ch.equals("K")) color = BG_BLACK;
                                else if (ch.equals("R")) color = BG_RED;
                                else if (ch.equals("G")) color = BG_GREEN;
                                else if (ch.equals("Y")) color = BG_YELLOW;
                                else if (ch.equals("B")) color = BG_BLUE;
                                else if (ch.equals("W")) color = BG_WHITE;
                                else if (ch.equals("C")) color = BG_CYAN;
                                else if (ch.equals("M")) color = BG_MAGENTA;
                                System.out.print(color + "  " + RESET);
                            }
                            System.out.println();
                        }

                    } else if (opBandera == 2) {
                        // Ver grupo completo
                        for (int i = 0; i < grupos.length; i++) {
                            System.out.println((i + 1) + ". Grupo " + grupos[i]);
                        }
                        System.out.print("Escoge el grupo: ");
                        while (!sc.hasNextInt()) { sc.next(); }
                        int gGrupo = sc.nextInt() - 1;

                        if (gGrupo < 0 || gGrupo >= grupos.length) {
                            System.out.println(ROJO + "Grupo invalido." + RESET);
                            break;
                        }

                        System.out.println(VERDE + "\n===== GRUPO " + grupos[gGrupo] + " =====" + RESET);
                        for (int p = 0; p < paisesPorGrupo[gGrupo].length; p++) {
                            String nombreP = paisesPorGrupo[gGrupo][p];
                            int idxG = -1;
                            for (int i = 0; i < equipos.length; i++) {
                                if (equipos[i].equals(nombreP)) { idxG = i; break; }
                            }
                            if (idxG == -1) continue;

                            System.out.println(AMARILLO + "\nBandera de: " + nombreP + RESET);
                            String[][] base = banderas[idxG];
                            int baseF = base.length;
                            int baseC = base[0].length;
                            for (int i = 0; i < filas; i++) {
                                for (int j = 0; j < cols; j++) {
                                    int fi = (i * baseF) / filas;
                                    int ci = (j * baseC) / cols;
                                    String ch = base[fi][ci];
                                    String color = RESET;
                                    if (ch.equals("K")) color = BG_BLACK;
                                    else if (ch.equals("R")) color = BG_RED;
                                    else if (ch.equals("G")) color = BG_GREEN;
                                    else if (ch.equals("Y")) color = BG_YELLOW;
                                    else if (ch.equals("B")) color = BG_BLUE;
                                    else if (ch.equals("W")) color = BG_WHITE;
                                    else if (ch.equals("C")) color = BG_CYAN;
                                    else if (ch.equals("M")) color = BG_MAGENTA;
                                    System.out.print(color + "  " + RESET);
                                }
                                System.out.println();
                            }
                        }

                    } else if (opBandera == 3) {
                        // Ver todas
                        for (int g = 0; g < grupos.length; g++) {
                            System.out.println(VERDE + "\n===== GRUPO " + grupos[g] + " =====" + RESET);
                            for (int p = 0; p < paisesPorGrupo[g].length; p++) {
                                String nombreP = paisesPorGrupo[g][p];
                                int idxT = -1;
                                for (int i = 0; i < equipos.length; i++) {
                                    if (equipos[i].equals(nombreP)) { idxT = i; break; }
                                }
                                if (idxT == -1) continue;
                                System.out.println(AMARILLO + "\nBandera de: " + nombreP + RESET);
                                String[][] base = banderas[idxT];
                                int baseF = base.length;
                                int baseC = base[0].length;
                                for (int i = 0; i < filas; i++) {
                                    for (int j = 0; j < cols; j++) {
                                        int fi = (i * baseF) / filas;
                                        int ci = (j * baseC) / cols;
                                        String ch = base[fi][ci];
                                        String color = RESET;
                                        if (ch.equals("K")) color = BG_BLACK;
                                        else if (ch.equals("R")) color = BG_RED;
                                        else if (ch.equals("G")) color = BG_GREEN;
                                        else if (ch.equals("Y")) color = BG_YELLOW;
                                        else if (ch.equals("B")) color = BG_BLUE;
                                        else if (ch.equals("W")) color = BG_WHITE;
                                        else if (ch.equals("C")) color = BG_CYAN;
                                        else if (ch.equals("M")) color = BG_MAGENTA;
                                        System.out.print(color + "  " + RESET);
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    } else {
                        System.out.println(ROJO + "Opcion invalida." + RESET);
                    }
                    break;
