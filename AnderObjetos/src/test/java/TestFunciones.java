import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.Test;

public class TestFunciones {
	
	String nombre = "Carlos gonzalez";
	char sexo = 'H';
	int edad = 34;
	float altura = (float) 1.78;
	float peso = (float) 67.6;
	Alumno alumno = new Alumno(nombre,sexo,edad,altura,peso);
	FuncionesMain funciones = new FuncionesMain();
	
	@Test
	public void test2() {
		LeerDatos leerDatosMock = mock(LeerDatos.class);
		Scanner reader = new Scanner(System.in);
		FuncionesMain fm = new FuncionesMain();
		when(leerDatosMock.RecogerOpcionInt(reader, 0, 100, "Introduce la cantidad de alumnos: ")).thenReturn(0);
		Alumno[] resultado = fm.CargarDatos(reader, leerDatosMock);
		
		assertEquals(resultado.length,0);
	}
	@Test
	public void test3() {
		LeerDatos leerDatosMock = mock(LeerDatos.class);
		Scanner reader = new Scanner(System.in);
		FuncionesMain fm = new FuncionesMain();
		when(leerDatosMock.RecogerOpcionInt(reader, 0, 100, "Introduce la cantidad de alumnos: ")).thenReturn(1);
		when(nombre = leerDatosMock.IntroducirNombre(reader)).thenReturn("Sara");
		when(sexo = leerDatosMock.IntroducirValidarSexo(reader)).thenReturn('M');
		when(edad= leerDatosMock.RecogerOpcionInt(reader,0,200,"Introduce la edad: ")).thenReturn(20);
		when(altura= leerDatosMock.RecogerOpcionFloat(reader,0,(float) 2.5,"Introduce la altura: ")).thenReturn(1.60f);
		when(peso= leerDatosMock.RecogerOpcionFloat(reader,0,150,"Introduce el peso: ")).thenReturn(52f);
		Alumno[] resultado = fm.CargarDatos(reader, leerDatosMock);
		
		assertEquals(resultado.length,1);
		assertEquals(resultado[0].getNombre(),"Sara");
		assertEquals(resultado[0].getSexo(),'M');
		assertEquals(resultado[0].getEdad(),20);
		assertEquals(resultado[0].getAltura(),1.6,0.2);
		assertEquals(resultado[0].getPeso(),52,0.2);
		
	}
}