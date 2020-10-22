import javax.swing.JOptionPane;
/**
 * Este programa crea un juego de cuatro en raya en el cual se puede jugar un jugador contra la maquina.
 * 
 * @author (James araya Rodríguez) 
 * @version (--/10/20)
 */
public class JugadorVsComputador
{
    /**
     *Este metodo recibe un nombre y un numero 
     *para almacenar el jugador y la posicion que desea jugar
     *
     *Ejecuta el juego
     *
     *@param jugador1
     *@param Ficha1
     * 
     */
    public static void main()
    {
        int vertical=0;
        //Inicializa la matriz
        String juego[][];
        juego = new String[6][7];
        
        //Fichas del juego
        String espacio="   ";
        String blanca="B";
        
        boolean gano=false;
        int contador=0;
        int contador1=0;
        String negra="N";
        int jugadas=0;
        boolean columnaLlena=false;
            
        //Rellena la matriz con espacios vacios
        for (int fila =0; fila<6; fila++)
        {
            for (int columna=0; columna<7; columna++)
            {
                juego [fila][columna]= espacio;
            }
        }
    
        //Imprimeel tablero de juego y solicita los nombres de los jugadores
        String resultado="";
        String lineas ="       1        2        3        4        5        6        7    \n";
        for (String fila[]:juego)
        {
            for (String columna:fila)
            {
                resultado +="   |   ";
                resultado += columna;
            }
            resultado +="  |\n   ----------------------------------------------------    \n";
        }
        String jugador1=JOptionPane.showInputDialog(lineas+resultado+"Nombre jugador 1: \n");  
        String jugador2="Computador";
        //Inicio de juego con 42 movimientos posibles ya que el tablero es de 6 x 7.
        while (jugadas < 42)
        {
            if(jugadas%2==0)
            {
                
                
                //imprime el tablero con las nuevas jugadas e indica laopcion elegida
                resultado="";
                lineas ="       1        2        3        4        5        6        7    \n";
                for (String fila[]:juego)
                {
                    for (String columna:fila)
                    {
                        resultado +="   |   ";
                        resultado += columna;
                    }
                    resultado +="  |\n   ----------------------------------------------------    \n";
                }
                if (gano==true)
                {
                    JOptionPane.showMessageDialog(null,lineas+resultado+"\n   FIN DEL JUEGO");
                    System.exit(0);
                }
                int ficha =0;
                while(ficha==0 || ficha>7 )
                {
                    ficha=Integer.parseInt(JOptionPane.showInputDialog(lineas+resultado+"\n\n   Turno de "+ jugador1+"      "+ jugadas +" movimientos "+". \n  Ingrese la posicion deseada: \n "));
                
                }
                
                //recorre las filas y asigna una posicion
                for (int fila=5; fila>=0; fila-- )
                {
                    //revisa que la columna no este llena si el ultimo espacio de la columna es igual le resta 1 al contador de movimientos
                    if (juego[0][ficha-1].equals(blanca) || juego[0][ficha-1].equals(negra))
                    {
                        columnaLlena=true;
                    }
                    //revisa que la columna este vacia para ṕoder jugar si hay espacio la marca sino sube a la siguiente fila
                    if (juego[fila][ficha-1].equals(espacio))   
                    {
                        juego [fila][ficha-1]=blanca;
                        break;
                    }
                }
                   
                //revisa las horizontales
                //entra a latabla y compara cada ficha con la que sigue
                for (String fila[]:juego)
                {
                    for (String columna:fila)
                    {
                        if (columna.equals(blanca))//si es igual suma
                        {
                            contador=contador+1;
                        }
                        else
                        {
                            contador=0;//sino se inicia de nuevo
                        }
                        if(contador==4)
                        {
                            JOptionPane.showMessageDialog(null,jugador1+" ha ganado la partida. ");
                            gano=true;
                            
                        }
                    }
                }
                        
                //recorre las columnas buscando un ganador
                
                while ( vertical !=7)
                {
                    for  (int fila=5; fila>0; fila--)
                    {
                        for (int columna=vertical; columna<vertical+1; columna++)//solo recorre la columna 1 vez y se sale
                        {
                            if (juego[fila][columna].equals(blanca))
                            {
                                contador1=contador1+1;
                            }
                            else if(contador1==4)
                            {
                                JOptionPane.showMessageDialog(null,jugador1+" ha ganado la partida. ");
                                gano=true;
                                
                            }
                            else{
                                contador1=0;
                            }
                        }
                        if (gano==true){ break;}
                    }
                    if (gano==true){ break;}
                    vertical=vertical+1;//aumenta la columana para para compararlo con la siguiente fila
                    //ademas solo se rocorre 6 veces al llegar a la 7 se sale del while
                    contador1=0; 
                }
                vertical=0; //permite poner el valor que aumenta las columnas en 0 para volver a entrar en la siguente jugada
                    
                //Recorre el tablero de forma diagonal 
                for (int fila=0; fila<juego.length-3; fila++)//compara las 4 primeras diagonales de izquierda a derecha 
                {                                             //y aumenta la fila para volverlo hacer pero en la que sigue
                    
                   for(int columna=0; columna<4; columna++)
                   {
                       if(juego[fila][columna].equals(blanca) && juego[fila+1][columna+1].equals(blanca) && juego[fila+2][columna+2].equals(blanca) && juego[fila+3][columna+3].equals(blanca))
                       {
                           JOptionPane.showMessageDialog(null,jugador1+" ha ganado la partida. ");
                           gano=true;
                       }
                    }
                }
                
                
                for (int fila=5; fila>=3; fila--)
                {
                   for(int columna=0; columna<=3; columna++)//compara las 4 primeras diagonales de derecha a izquierda
                   {                                        //y disminuye la fila para volverlo hacer pero en la que sigue
                       if(juego[fila][columna].equals(blanca) && juego[fila-1][columna+1].equals(blanca) && juego[fila-2][columna+2].equals(blanca) && juego[fila-3][columna+3].equals(blanca))
                       {
                           JOptionPane.showMessageDialog(null,jugador1+" ha ganado la partida. ");
                           gano=true;
                       }
                    }
                }
                    
                //Si la columna que eligio el jugador esta llena le da la oportunidad de volver a tirar.
                if (columnaLlena==true)
                {
                    JOptionPane.showMessageDialog(null,"   La columna esta llena intente denuevo");
                    jugadas=jugadas-1;
                }
                if (gano==false)
                {
                    
                    jugadas =jugadas + 1;//contador de jugadas validas
                    columnaLlena=false;//indica que aun la columna sigue vacia
                }else{jugadas=43;}
            }
            //*****************************************************************************************************************************************
            
            if(jugadas%2!=0)
            {
                //indica el turno del jugador
                int ficha2=0;
                while(ficha2==0 || ficha2>7 )
                {
                    ficha2=(int)(Math.random()*8);
                }
                
                //recorre las filas y asigna una posicion
                for (int fila=5; fila>=0; fila-- )
                {
                    //revisa que la columna no este llena si el ultimo espacio de la columna es igual le resta 1 al contador de movimientos
                    if (juego[0][ficha2-1].equals(negra) || juego[0][ficha2-1].equals(blanca))
                    {
                        columnaLlena=true;
                    }
                    //revisa que la columna este vacia para ṕoder jugar si hay espacio la marca sino sube a la siguiente fila
                    if (juego[fila][ficha2-1].equals(espacio))   
                    {
                        juego [fila][ficha2-1]=negra;
                        break;
                    }
                }
                //imprime el tablero con las nuevas jugadas
                resultado="";
                lineas ="       1        2        3        4        5        6        7    \n";
                for (String fila[]:juego)
                {
                    for (String columna:fila)
                    {
                        resultado +="   |   ";
                        resultado += columna;
                    }
                    resultado +="  |\n   ----------------------------------------------------    \n";;
                }
                if (gano==true)
                {
                    JOptionPane.showMessageDialog(null,lineas+resultado+"\n   FIN DEL JUEGO");
                    System.exit(0);
                }
                //JOptionPane.showMessageDialog(null,lineas+resultado+"\n  Computador jugo en la posicion "+ficha2);
                    
                //revisa las horizontales
                //entra a latabla y compara cada ficha con la que sigue
                for (String fila[]:juego)
                {
                    for (String columna:fila)
                    {
                        if (columna.equals(negra))//si es igual suma
                        {
                            contador=contador+1;
                        }
                        else
                        {
                            contador=0;//sino se inicia de nuevo
                        }
                        if(contador==4)
                        {
                            JOptionPane.showMessageDialog(null,jugador2+" ha ganado la partida. ");
                            gano=true;
                        }
                    }
                }
                        
                //recorre las columnas buscando un ganador
                
                while ( vertical !=7)
                {
                    for  (int fila=5; fila>0; fila--)
                    {
                        for (int columna=vertical; columna<vertical+1; columna++)//solo recorre la columna 1 vez y se sale
                        {
                            if (juego[fila][columna].equals(negra))
                            {
                                contador1=contador1+1;
                            }
                            else if(contador1==4)
                            {
                                JOptionPane.showMessageDialog(null,jugador2+" ha ganado la partida. ");
                                gano=true;
                            }
                            else{
                                contador1=0;
                            }
                        }
                        if (gano==true){ break;}
                    }
                    if (gano==true){ break;}
                    vertical=vertical+1;//aumenta la columana para para compararlo con la siguiente fila
                    //ademas solo se rocorre 6 veces al llegar a la 7 se sale del while
                }
                vertical=0; //permite poner el valor que aumenta las columnas en 0 para volver a entrar en la siguente jugada
                contador=0;     
                //Recorre el tablero de forma diagonal 
                for (int fila=0; fila<juego.length-3; fila++)//compara las 4 primeras diagonales de izquierda a derecha 
                {                                             //y aumenta la fila para volverlo hacer pero en la que sigue
                    
                   for(int columna=0; columna<4; columna++)
                   {
                       if(juego[fila][columna].equals(negra) && juego[fila+1][columna+1].equals(negra) && juego[fila+2][columna+2].equals(negra) && juego[fila+3][columna+3].equals(negra))
                       {
                           JOptionPane.showMessageDialog(null,jugador2+" ha ganado la partida. ");
                           gano=true;
                       }
                    }
                }
                
                for (int fila=5; fila>=3; fila--)
                {
                   for(int columna=0; columna<=3; columna++)//compara las 4 primeras diagonales de derecha a izquierda
                   {                                        //y disminuye la fila para volverlo hacer pero en la que sigue
                       if(juego[fila][columna].equals(negra) && juego[fila-1][columna+1].equals(negra) && juego[fila-2][columna+2].equals(negra) && juego[fila-3][columna+3].equals(negra))
                       {
                           JOptionPane.showMessageDialog(null,jugador2+" ha ganado la partida. ");
                           gano=true;
                       }
                    }
                }
                    
                //Si la columna que eligio el jugador esta llena le da la oportunidad de volver a tirar.
                if (columnaLlena==true)
                {
                    JOptionPane.showMessageDialog(null,"   La columna esta llena intente denuevo");
                    jugadas=jugadas-1;
                }
                if (gano==false)
                {
                    columnaLlena=false;//indica que aun la columna sigue vacia
                    jugadas =jugadas + 1;//contador de jugadas validas
                }else{jugadas=43;}
            }
        }    
        if(jugadas==42 && gano!=true)
        {
            JOptionPane.showMessageDialog(null,lineas+resultado+"Ha ocurrido un empate");
        }
    }
}