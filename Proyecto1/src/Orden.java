
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manuel
 */
public class Orden extends Thread {

    Empleado empleado;
    Producto producto;
    Cola empleadosD;
    Lista inventario;
    JTable tabla;
    Lista catalogo;

    public Orden(String param, Empleado employee, Producto product, Cola empleados, Lista materiales, JTable table, Lista num) {
        super(param);
        this.empleado = employee;
        this.producto = product;
        this.empleadosD = empleados;
        this.inventario = materiales;
        this.tabla = table;
        this.catalogo = num;
    }

    public void run() {
        String[] fila = new String[3];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        fila[0] = empleado.getNombre();
        fila[1] = producto.getNombre();
        boolean finished = true;
        Pila temporal = new Pila();

        for (int i = 0; i < producto.getMateriales().getSize(); i++) {
            for (int k = 0; k < inventario.getSize(); k++) {
                if (((Material) producto.getMateriales().get(i)).getNombre().
                        toLowerCase().equals(((Material) ((Pila) inventario.get(k)).peek()).getNombre().toLowerCase())) {
                    if (((Material) producto.getMateriales().get(i)).getMarca().
                            toLowerCase().equals(((Material) ((Pila) inventario.get(k)).peek()).getMarca().toLowerCase())) {
                        if (((Pila) inventario.get(k)).isEmpty() == false) {
                             temporal.push(((Pila) inventario.get(k)).pop());
                            this.esperarXsegundos(producto.getMateriales().getSize() - i);
                            fila[2] = ((Material) ((Pila) inventario.get(k)).peek()).getNombre();
                            modelo.insertRow(0, fila);
                        } else {
                            finished = false;
                            JOptionPane.showMessageDialog(null, "El empleado " + empleado.getNombre()
                                    + " no ha podido terminar el producto: " + producto.getNombre(),
                                    "FALTA DE MATERIALES", JOptionPane.ERROR_MESSAGE, null);
                            i = producto.getMateriales().getSize();
                            k = inventario.getSize();
                        }
                    }
                }
            }
        }

        if (finished == true) {
            JOptionPane.showMessageDialog(null, "El empleado " + empleado.getNombre()
                    + " ha terminado con exito el producto: " + producto.getNombre(),
                    "ENSAMBLAJE TERMINADO", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            while (temporal.isEmpty() == false) {
                for (int k = 0; k < catalogo.size; k++) {
                    if (((Material) catalogo.get(k)).getNombre().toLowerCase().
                            equals(((Material) temporal.peek()).getNombre().toLowerCase())) {
                        if (((Material) catalogo.get(k)).getMarca().toLowerCase().
                                equals(((Material) temporal.peek()).getMarca().toLowerCase())) {
                                ((Pila)inventario.get(k)).push(temporal.pop());
                        }
                    }
                }
            }

        }
        empleadosD.queue(empleado);
    }

    private void esperarXsegundos(int segundos) {
        try {
            this.sleep(segundos * 2000);
        } catch (InterruptedException ex) {
            this.currentThread().interrupt();
        }
    }
}
