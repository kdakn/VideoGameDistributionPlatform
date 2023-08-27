import Pages.*;

import java.util.ArrayList;

import Entities.*;

public class Driver {
	

	public static void main(String[] args) {
		
		
		
		Developer ea = new Developer("eagames", "e123456", "EA Games");
		Developer valve = new Developer("valve", "v123456", "Valve");
		Developer ubisoft = new Developer("ubisoft", "u123456", "Ubisoft");
		Developer konami = new Developer("konami", "k123456", "KONAMÝ");
		Developer rockstar = new Developer("rockstar", "r123456", "Rockstar Games");
		
		Gamer admin = new Gamer("admin", "123456");
		admin.setBalance(1500);
		List.gamers.add(admin);
		
		List.developers.add(ea);
		List.developers.add(valve);
		List.developers.add(ubisoft);
		List.developers.add(konami);
		List.developers.add(rockstar);
		
		Game fifa = new Game("FIFA 2022", 2021, ea, "Sports", 599.95 );
		ea.getList().add(fifa);
		Game f1 = new Game("F1 2022", 2021, ea, "Racing", 499.95);
		ea.getList().add(f1);
		Game csgo = new Game("Counter-Strike: Global Offensive", 2012, valve, "FPS", 249.95);
		valve.getList().add(csgo);
		Game hl = new Game("Half-Life", 1998, valve, "FPS", 19.95);
		valve.getList().add(hl);
		Game acv = new Game("Assassin's Creed Valhalla", 2020, ubisoft, "Action", 599.95);
		ubisoft.getList().add(acv);
		Game acu = new Game("Assassin's Creed Unity", 2014, ubisoft, "Action", 120.90);
		ubisoft.getList().add(acu);
		Game farcry = new Game("Far Cry 6", 2021, ubisoft, "FPS", 569.0);
		ubisoft.getList().add(farcry);
		Game pes = new Game("eFootball 2023", 2022, konami, "Sports", 299.95);
		konami.getList().add(pes);
		Game gta = new Game("GTA V", 2015, rockstar, "Action", 208.99);
		rockstar.getList().add(gta);
		Game rdr2 = new Game("Red Dead Redemption 2", 2018, rockstar, "Action", 199.95);
		rockstar.getList().add(rdr2);
		Game maxp = new Game("Max Payne 3", 2012, rockstar, "TPS", 98.90);
		rockstar.getList().add(maxp);
		
		
		List.games.add(fifa);
		List.games.add(f1);
		List.games.add(csgo);
		List.games.add(hl);
		List.games.add(acv);
		List.games.add(acu);
		List.games.add(farcry);
		List.games.add(pes);
		List.games.add(gta);
		List.games.add(rdr2);
		List.games.add(maxp);
		
		admin.getGames().add(acu);
		
		
		LoginPage lp = new LoginPage();
		lp.getFrame().setVisible(true);
		

	}

}
