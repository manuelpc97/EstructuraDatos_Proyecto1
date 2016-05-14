
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class RevisionTiempo implements Runnable {
 
    private JLabel hora;
    String tiempo;//el tiempo de la clase
    Lista timeUp;
    
    public RevisionTiempo(JLabel hora){
        this.hora = hora;
    }
    
    public void inicioProceso (String duracion) throws ParseException{
       //Este metodo se llama solamente cuando inicia el proceso, no en cola
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
        
        if(timeUp == null){
            timeUp = new Lista();
            timeUp.push(df.format(d2));
        }else
            timeUp.push(df.format(d2));
    }
    
    
    
    public void run(){
        while(true){
            Date h = new Date();
            DateFormat f = new SimpleDateFormat("hh:mm:ss");
            tiempo  = hora.getText();
            for (int i = 0; i < timeUp.getSize(); i++) {
                if(((String)timeUp.get(i)).equals(tiempo)){
                    //llamar proceso de actualizar la tabla
                    timeUp.remove(timeUp.find(i));
                }
                    
            }
            try{
                Thread.sleep(495);
            }catch(InterruptedException ex){
                    
                    }
            
        }
    }
}
