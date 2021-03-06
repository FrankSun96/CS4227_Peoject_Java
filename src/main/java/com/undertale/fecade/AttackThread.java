package com.undertale.fecade;

import com.undertale.model.Charactor;


public class AttackThread extends Thread{
	private Charactor chara;
	private float hp;
	private float damage;
	private float armor;
	private float ch_hp;
	private float ch_arm;
	private float ch_armor;
	private float ch_attack;
	private float ch_defense;
	private String ch_name;
	
	AttackThread(Charactor charactor, float hp, float damage, float armor){
		this.hp = hp;
		this.damage = damage;
		this.armor = armor;
		this.chara = charactor;
		this.ch_name = chara.getName();
		this.ch_arm = chara.getArm();
		this.ch_armor = chara.getArmor();
		this.ch_attack = chara.getAttack();
		this.ch_defense = chara.getDefense();
		this.ch_hp = chara.getHP();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		if((ch_armor + ch_defense) > damage) {
			damage = damage - 2;
		}
		if((ch_attack + ch_arm) < armor) {
			ch_arm = ch_arm - 2;
		}
		while(true) {
			boolean crit = false;
			float ch_damage = ch_attack + ch_arm;
			System.out.println("\n******************************************************************************");
			System.out.println(ch_name + "! Now you are fighting with a creature !");
			System.out.println("Your hp: "+ ch_hp + "  The creature hp: "+ hp + " Beat it warrior!");
			System.out.println("\n******************************************************************************");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			crit = critMethod();
			if(ch_arm != 0 && crit == true) {
				System.out.println("\n\nYes! You got a crit! Your damage will +2 in this fighting round!\n\n");
				ch_hp = ch_hp - damage;
				hp = hp - ch_damage -2;
			}else {
				ch_hp = ch_hp - damage;
				hp = hp - ch_damage;
			}
			System.out.println("\n******************************************************************************");
			System.out.println(ch_name + "! Now you are fighting with a creature !");
			System.out.println("Your hp: "+ ch_hp + "  The creature hp: "+ hp + " Keep going on warrior!");
			System.out.println("\n******************************************************************************");
			chara.setHP(ch_hp);
			if(hp <= 0 && ch_hp > 0) {
				
				break;
			}
			if(ch_hp <= 0 ) {
				break;
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean critMethod() {
		boolean crit = false;
		int num =(int)(Math.random() * 10);
		if(10 > num && num >= 5) {
			crit = true;
		}
		return crit;
	}
}

