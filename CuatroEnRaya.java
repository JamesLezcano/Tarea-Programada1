import javax.swing.JOptionPane;
/**
 * Este programa presenta un menu mediante el cual hace un llamado al juego de cuatro en raya.
 * El llamado a los juegos se realizan mediante los metodos constructores de cada opcion.
 * 
 * @author (James araya Rodríguez) 
 * @version (--/10/20)
 */
public class CuatroEnRaya
{
    /**
     *Este metodo recibe un un numero  para ejecutar el menu de juego.
     *
     *Hace un llamado a las clases que ejecutan el juego
     *
     *@param jugador1
     *@param Ficha1
     */
    public static void main(String args[])
    {
        
        JugadorVsJugador jugador=new JugadorVsJugador();
        JugadorVsComputador computador =new JugadorVsComputador();
        int opcion;
        do
            {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("    Cuatro en Raya \n"+"\n    Elija el modo de juego\n"+"\n  1- Jugador vs Jugador\n"
            +"  2- Jugador vs Computador"+"\n  3- Salir"));
           
            switch(opcion)
            {
                case 1:
                    jugador.main();
                    break;
                case 2:
                    computador.main();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Gracias");
                    break;
               
                default:
                    JOptionPane.showMessageDialog(null,"Opcion incorrecta intentelo de nuevo");
            }
        }while(opcion!=3);
    }
}
 