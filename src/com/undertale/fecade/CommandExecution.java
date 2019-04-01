package com.undertale.fecade;

import com.undertale.model.Command;
import com.undertale.model.UndertaleMap;

public class CommandExecution {
	private HelpExecution help;
	private GoExecution go;
	private ReadExecution read;
	private SaveExecution save;
	private NewExecution newGame;
	private CheckExecution check;
	private TakeExecution take;
	
	
	public CommandExecution() {
		help = new HelpExecution();
		go = new GoExecution();
		read = new ReadExecution();
		save = new SaveExecution();
		newGame = new NewExecution();
		check = new CheckExecution();
		take = new TakeExecution();
	}
	
	public void execute(Command command, UndertaleMap map) {
		String firstword = command.getfirstWord();
		if(firstword.equals("HELP")) {
			help.excute(command, map);
		} else if(firstword.equals("GO")) {
			go.excute(command, map);
		} else if(firstword.equals("READ")) {
			read.excute(command, map);
		} else if(firstword.equals("NEW")) {
			newGame.excute(command, map);
		} else if(firstword.equals("SAVE")) {
			save.excute(command, map);
		} else if(firstword.equals("CHECK")) {
			check.excute(command, map);
		} else if(firstword.equals("TAKE")) {
			take.excute(command, map);
			System.out.println("execute");
		}

	}
}
