package br.com.projetosalura.AppTabelaFipe.demo.main;

import br.com.projetosalura.AppTabelaFipe.demo.main.brandMenu.BrandMenu;
import br.com.projetosalura.AppTabelaFipe.demo.models.VehicleType;

import java.util.Scanner;

public class MainMenu {

    public void showMenu() {
        System.out.println("Bem vindo!");
        System.out.println("Selecione um Tipo de Veículo:");
        System.out.println("""
            1 - Carros
            2 - Motos
            3 - Caminhões \n
            """);
        VehicleType vehicleType = new VehicleType();
        vehicleType.chooseType(new Scanner(System.in).nextInt());
        BrandMenu.displayBrands(vehicleType);
    }

}
