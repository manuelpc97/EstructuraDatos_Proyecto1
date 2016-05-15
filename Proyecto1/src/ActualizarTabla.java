
import static java.lang.Thread.sleep;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juany
 */
public class ActualizarTabla implements Runnable {
 
   
    private JTable tabla;
    
   
    public ActualizarTabla(JTable tabla){
        this.tabla = tabla;
    }
    
    public void run(){
        while (true){
            /*while(!vehiculos.isEmpty()){
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Placa");
                model.addColumn("Marca");
                model.addColumn("Modelo");
                model.addColumn("Año");
                model.addColumn("Precio Renta");
                model.addColumn("Estado");

                for (int i = 0; i < vehiculos.size(); i++) {
                    Object[] newrow = {(Arrays.toString(vehiculos.get(i).getPlaca1())+"-"+Arrays.toString(vehiculos.get(i).getPlaca2())),
                        vehiculos.get(i).getMarca(),vehiculos.get(i).getModelo(),vehiculos.get(i).getAño(),vehiculos.get(i).getPrecio_renta(),
                        vehiculos.get(i).isRentado()
                    };
                    model.addRow(newrow);
                }

                tabla.setModel(model);

                try{
                    sleep(5000);
                } catch (Exception e){

                }
            }*/
        }
    }
}