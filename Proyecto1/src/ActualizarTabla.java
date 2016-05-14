
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;


/**
 *
 * @author Juany
 */
public class ActualizarTabla implements Runnable {
 
    private JLabel hora;
    
    
    public ActualizarTabla(JLabel hora){
        this.hora = hora;
    }
    
    
    
    public void run(){
        while(true){
            Date h = new Date();
            DateFormat f = new SimpleDateFormat("hh:mm:ss");
            
            hora.setText(f.format(h));
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
                    
                    }
            
        }
    }
}