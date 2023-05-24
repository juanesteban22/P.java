package Imc;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
public class IndiceMasaCorporal {
	
	ArrayList<Double> Peso = new ArrayList<Double>();
	ArrayList<Double> Talla = new ArrayList<Double>();
	ArrayList<Double> imc = new ArrayList<Double>();
	ArrayList<String> listaNombres=new ArrayList<String>();
	ArrayList<Integer> numerosTel = new ArrayList<Integer>();
	double val = 0,imc1 = 0;
	String nombre = "",menu = "", actualizar ="";
	public void iniciar () {
	PedirUsuario();
	CalcularImc();
	ValidarImc();
	BuscarNombres();
	ActualizarPersona();
	elim();
	}
	public void menu() {
		menu = "Menu INdice de masa corpora\n";
		menu += "1.Registrar otra persona";
		menu += "2.Buscar Persona";//Indicar cuantas perosna se encuentran en el resultado
		menu += "3.Imprimir Lista";
		menu += "4.Actualizar Persona";
		menu += "5.Eliminar Persona";
		menu += "6. Salir";
		int men = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (men) {
		case 1:
			PedirUsuario();
			break;
		case 2:
			BuscarNombres();
			break;
		case 3:
			ValidarImc();
			
			break;
		case 4:ActualizarPersona();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Gracias por usar el progra bay");
			break;

		default:
			JOptionPane.showMessageDialog(null, " el numero no es valido");
			break;
		}
	}
	public void PedirUsuario() {

		
		int n = Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero de personas a validar"));
		for (int i = 0; i < n; i++) {
			listaNombres.add(JOptionPane.showInputDialog("Ingresa el nombre de la persona"));
			numerosTel.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero celular")));
		}
		IngresaImc(n);
	}
	public void IngresaImc(int n) {

		for (int j = 0; j < n; j++) {
			val = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el Peso"));
			Peso.add(val);
		}
		
		for (int i = 0; i < Peso.size(); i++) {
			Talla.add(Double.parseDouble(JOptionPane.showInputDialog("Ingresa la aultura")));
		}
		System.out.println(Peso);
		System.out.println(Talla);

	}
	public void CalcularImc () {

		for (int i = 0; i < Peso.size(); i++) {
			imc1= Peso.get(i)/(Talla.get(i)*Talla.get(i));
			imc.add(imc1);
		}
			System.out.println(imc);
	}
	public void ValidarImc() {

		for (int i = 0; i < Peso.size(); i++) {
			if(imc.get(i)<18) {
				System.out.println(listaNombres.get(i) + " = [" + "Anorexia" + ", " + numerosTel.get(i) + "]");
			}else if (imc.get(i)>=18 && imc.get(i)<20) {
				System.out.println(listaNombres.get(i) + " = [" + "delgadez" + ", " + numerosTel.get(i) + "]");
			}else if (imc.get(i)>=20 && imc.get(i)<27) {
				System.out.println(listaNombres.get(i) + " = [" + "Normal" + ", " + numerosTel.get(i) + "]");
			}else if (imc.get(i)>=27 && imc.get(i)<30) {
				System.out.println(listaNombres.get(i) + " = [" + "obesidad grado1" + ", " + numerosTel.get(i) + "]");
			}else if (imc.get(i)>=30 && imc.get(i)<35) {
				System.out.println(listaNombres.get(i) + " = [" + "obesidad grado2" + ", " + numerosTel.get(i) + "]");
			}else if (imc.get(i)>=35 && imc.get(i)<40) {
				System.out.println(listaNombres.get(i) + " = [" + "obesidad grado3" + ", " + numerosTel.get(i) + "]");
			}else {
				 System.out.println(listaNombres.get(i) + " = [" + "obesidad morbida" + ", " + numerosTel.get(i) + "]");
			}
	}
	}
	public void BuscarNombres() {

		String con = "";
		do {
			 nombre = JOptionPane.showInputDialog("Ingresa el nombre que quieres buscar");
			
			 for (int i = 0; i < listaNombres.size(); i++) {
				 if (nombre.equalsIgnoreCase(listaNombres.get(i))) {
				 System.out.println("El nombre "+nombre+" se encuentra en la posición "+i);
				 }
				 }
			 con = JOptionPane.showInputDialog("Ingresa si para buscar otro nombre");
		} while (con.equalsIgnoreCase("si"));
	}
	public void ActualizarPersona() {
		int numv = Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero de perosnas a actualizar"));
		for (int i = 0; i < numv ; i++) {
			if (listaNombres.size() != numerosTel.size()) {
	            System.out.println("Los dos ArrayList no tienen el mismo tamaño.");
	            return;
	        }
	        int input =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de teléfono que desea actualizar:"));

			int index = numerosTel.indexOf(input);

	        if (index == -1) {
	            JOptionPane.showMessageDialog(null, "El número de teléfono ingresado no se encuentra en la lista.");
	            return;
	        }

	        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");

	        listaNombres.set(index, nuevoNombre);
	        JOptionPane.showMessageDialog(null, "El nombre se ha actualizado correctamente.");
	        System.out.println(listaNombres.get(i) + " = [" + imc1 + ", " + numerosTel.get(i) + "]");
	        
	        System.out.println(listaNombres);
		}
	}
	public void elim() {
		int numv = Integer.parseInt(JOptionPane.showInputDialog("INgresa el numero de personas a eliminar"));
		for (int i = 0; i < numv; i++) {
			 int input =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de teléfono de la persona que  desea eliminar:"));
			 int index = numerosTel.indexOf(input);
			  if (index == -1) {
		            JOptionPane.showMessageDialog(null, "El número de teléfono ingresado no se encuentra en la lista.");
		            return;
		        }
			  listaNombres.remove(index);
			  numerosTel.remove(index);
			  JOptionPane.showMessageDialog(null, "El nombre se ha actualizado correctamente.");
			  System.out.println("nombre = ["+listaNombres.get(i) + "numero:"+ numerosTel.get(i)+"]");
			  System.out.print(listaNombres.get(i));
			  
		}
	}
}