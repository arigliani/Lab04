package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model m= new Model();
		
		boolean b= m.controllaSoloInt("hfhtr55544");
		if(b==true){
			System.out.println(" ook");
		}else{
			System.out.println("caratteri alfabetici");
		}

	}

}
