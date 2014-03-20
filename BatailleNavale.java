
/**
 *
 * @author Morane Otilia
 */
public class BatailleNavale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Terminal.ecrireString("Bienvenue au Jeux de la semaine: Bataille navale !!!");
        Terminal.sautDeLigne();
        int taille = 0;
        int bat =0;
        while (taille<= 1 || bat <= 0 || (taille-2)<= bat){
        Terminal.ecrireString("quelle taille?");
        taille = Terminal.lireInt();
        Terminal.ecrireString("combien de bateaux?");
        bat = Terminal.lireInt();
        if (taille<= 1) Terminal.ecrireStringln("le tableau est trop petit");
        if (bat <= 0) Terminal.ecrireStringln("il faut un numero positif");
        if ((taille-2)<= bat) Terminal.ecrireStringln("il y a trop d bateaux");
        }
        
            
        boolean [] joueur = new boolean [taille];
        int jouurbat= 0; // nombre de bateaux joueuer positioner
        int pos = 0;
        while (bat> jouurbat){
            
                Terminal.ecrireString("position du bateau n°"+jouurbat+ ":");
                pos = Terminal.lireInt();
                
                while ( pos< 0 || pos>= taille || joueur [pos]== true) {
                    Terminal.ecrireString("position erreur! retapez bateau n°"+jouurbat+ ":");
                    pos = Terminal.lireInt();
                }
                joueur [pos]= true;
                jouurbat++;
                }   
           
   
        boolean [] ordi = new boolean [taille];
        int ordibat= 0; // nombre de bateaux ORDI positioner
        int posod = 0;
        while (bat> ordibat){
            
                posod= (int)(Math.random()*taille);
                
                if ( !ordi [posod]) {
                    ordi[posod]= true;
                      ordibat++;
                }   
            }
//Les coups du joueur sont notés sur un papier or les coups d'ordi sont inscrit dans tabcoupordi
    char [] tabcoupordi = new char [taille];
    for (int n = 0; n< taille; n++){
        tabcoupordi[n]= ' ';
    }
    Terminal.ecrireStringln("Start game!");
    
    
    while (jouurbat != 0 && ordibat != 0){
        int posOnGame = 0;
        do {
            
        
        Terminal.ecrireString("A toi de jouer, choisi une case (si ce choix est deja fais, tu n'a pas d nouvelle chanc)? ");
        posOnGame = Terminal.lireInt();
        if (posOnGame<0 || posOnGame>= taille)
            Terminal.ecrireStringln("ERREURE!! indic invalide");
        } while (posOnGame<0|| posOnGame>=taille);
        if (ordi [posOnGame]){
            Terminal.ecrireStringln("coulé!!");
            ordi [posOnGame]= false;
            ordibat--;
        }
        else { Terminal.ecrireStringln("à l'eau!!");}
        // tour de l'ordi
        do {
            posOnGame= (int)(Math.random()*taille);
        } while (tabcoupordi [posOnGame]!=' ');
        Terminal.ecrireStringln("je joue la case "+ posOnGame);
        afficherTab(joueur);
        Terminal.ecrireString("(t)ouché ou dans l'(e)au? t/e");
        char rep = Terminal.lireChar();
        if ((rep != 't' && joueur[posOnGame])|| (rep == 't'&& !joueur[posOnGame])){
            Terminal.ecrireStringln("pas vrai!");
            rep = joueur[posOnGame]?'t':'e';
            
        }
       if (rep== 't'){
           joueur [posOnGame]= false;
           jouurbat --;
       }
    }//fin du while
    if (ordibat == 0)
        Terminal.ecrireStringln("Tu as gagné!");
    if (jouurbat == 0)
       Terminal.ecrireStringln("J'ai gagné!");
    
  
    
    
    }// fin du main
    public static void afficherTab (boolean [] tab){
        for (int i= 0; i< tab.length;i++){
            if (i<10) Terminal.ecrireChar(' ');
            Terminal.ecrireString(i+ " ");
        }
        Terminal.sautDeLigne();
        for (int i=0; i<tab.length;i++)
            Terminal.ecrireString(" "+(tab[i]?'x':'.')+" ");
        Terminal.sautDeLigne();
        }
    
    }// fin d la classe
    
