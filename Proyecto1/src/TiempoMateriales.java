


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Juany
 */
public class TiempoMateriales implements Runnable {
 
    private JLabel hora;
    String tiempo;
    Lista timeUp;
    
    public TiempoMateriales(JLabel hora){
        this.hora = hora;
        if(timeUp == null)
            timeUp = new Lista();
    }
    
    public void inicioProceso (String duracion) throws ParseException{
       
        String[] arr = duracion.split(";");
        int horas = Integer.parseInt(arr[0]);
        int minutos = Integer.parseInt(arr[1]);
        
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        Date d = df.parse(hora.getText()); 
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        gc.add(Calendar.MINUTE, horas);
        gc.add(Calendar.HOUR, horas);
        Date d2 = gc.getTime();
        timeUp.push(df.format(d2));
    }
    
    public void run(){
        while(true){
            Date h = new Date();
            DateFormat f = new SimpleDateFormat("hh:mm:ss");
            
            hora.setText(f.format(h));
            tiempo  = hora.getText();
            for (int i = 0; i < timeUp.getSize(); i++) {
                if(((String)timeUp.get(i)).equals(tiempo)){
                    timeUp.remove(timeUp.find(i));
                }
                    
            }
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
                    
                    }
            
        }
    }
}